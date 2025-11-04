package co.edu.unbosque.prg2jsf_ptc.services;

import co.edu.unbosque.prg2jsf_ptc.model.*;
import co.edu.unbosque.prg2jsf_ptc.model.persistence.IDAOInstallement;
import co.edu.unbosque.prg2jsf_ptc.model.persistence.IDAOPayment;
import co.edu.unbosque.prg2jsf_ptc.model.persistence.IDAOUser;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.*;

@Stateless
public class PaymentImpl implements IPayment<PaymentDTO, String> {

    private final ModelMapper modelMapper;
    private final Random random;

    @Inject
    private IDAOPayment<Payment, String> DAO;

    @Inject
    private IDAOUser<User, String> DAOUser;

    @Inject
    private IDAOInstallement<Installment, String> DAOInstallement;

    @Inject
    private IInstallment<InstallmentDTO, String> serviceInstallment;

    public PaymentImpl() {
        modelMapper = new ModelMapper();
        random = new Random();
    }

    /**
     * Method that gets all the objects in the system
     *
     * @return the list of objects
     */
    @Override
    public List<PaymentDTO> getAll() {

        List<Payment> payments = DAO.getAll();

        return modelMapper.map(payments, new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }

    /**
     * Method to save a payment, create the installments
     *
     * @param object,  the payment to be save
     * @param userDTO, user to add the payment
     */
    @Override
    public void save(PaymentDTO object, UserDTO userDTO) {

        // Map DTOs to entities
        Payment payment = modelMapper.map(object, Payment.class);
        User user = modelMapper.map(userDTO, User.class);

        // Inicializa info de pago
        payment.setDate(Calendar.getInstance().getTime());
        payment.setStatus(random.nextBoolean());
        payment.setCode(UUID.randomUUID().toString());
        payment.setIva(0.16);

        // Busca usuario por identificación
        String identification = user.getIdentification();
        User userFound = DAOUser.find(identification);
        boolean isNewUser = (userFound == null);

        // Si no existe, lo crea y lo actualiza en memoria
        if (isNewUser) {
            DAOUser.save(user);
            userFound = user;
        }
        payment.setUser(userFound);

        // Añade el pago a la lista del usuario (si no está ya)
        if (userFound.getPayments() == null) {
            userFound.setPayments(new ArrayList<>());
        }
        userFound.getPayments().add(payment);

        // Lógica de monto total
        double price = payment.getPrice();
        double ivaAmount = price * 0.16;
        double totalPrice = price + ivaAmount;

        // Aplica descuento si es nuevo usuario
        if (isNewUser) {
            totalPrice -= price * 0.02;
        }

        // Calcula cuotas
        int numberInstallments = payment.getNumberInstallments();
        double interestRate = 0.0134;
        double installmentValue = (numberInstallments > 1)
                ? (totalPrice * interestRate) / (1 - Math.pow(1 + interestRate, -numberInstallments))
                : totalPrice;

        // Crea lista de cuotas
        List<Installment> installments = new ArrayList<>();
        for (int j = 1; j <= numberInstallments; j++) {
            Installment installment = new Installment();

            double interest = numberInstallments > 1
                    ? Math.round((totalPrice * interestRate) * 100.0) / 100.0
                    : 0;
            double capital = numberInstallments > 1
                    ? Math.round((installmentValue - interest) * 100.0) / 100.0
                    : installmentValue;

            installment.setNumberInstallment(j+1);
            installment.setValue(installmentValue);
            installment.setCapital(capital);
            installment.setInterest(interest);
            installment.setPayment(payment);
            installments.add(installment);
        }

        // Asigna cuotas al pago
        payment.setInstallments(installments);

        DAO.save(payment);

        // Guarda las cuotas y el pago
        for (Installment installment : installments) {
            installment.setPayment(payment);
            DAOInstallement.save(installment); // Si tienes un DAO específico para cuotas, úsalo aquí
        }


    }

    /**
     * Method that delete an object in the system
     *
     * @param ID identificator of the object
     */
    @Override
    public void delete(String ID) {
        DAO.delete(ID);
    }

    /**
     * Method that update or replace an object in the system
     *
     * @param object User to be updated
     */
    @Override
    public void update(PaymentDTO object) {
        DAO.update(modelMapper.map(object, Payment.class));
    }

    @Override
    public void find(String code) {
        DAO.find(code);
    }
}

