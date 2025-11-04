package co.edu.unbosque.prg2jsf_ptc.model.persistence;

import co.edu.unbosque.prg2jsf_ptc.model.Payment;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


/**
 * Class DAO with methods CRUD direct to the database
 */
@Stateless
public class DAOPaymentImpl implements IDAOPayment<Payment, String>{

    @PersistenceContext(unitName="PagosTCMyDB")
    private EntityManager em;

    /**
     * Method to get all the objects in the database
     * @return the objects in the database
     */
    @Override
    public List<Payment> getAll() {
        return em.createNamedQuery("Payment.findAll",  Payment.class).getResultList();
    }

    /**
     * Mehtod to save a object into the database
     * @param object payment to save
     */
    @Override
    public void save(Payment object) {
        em.persist(object);
    }

    /**
     * Method to find and delete an object in the database
     * @param ID Identification of the object in the database
     */
    @Override
    public void delete(String ID) {
        em.remove(em.find(Payment.class, ID));
    }

    /**
     * Method to update or replace an object in the database
     * @param object
     */
    @Override
    public void update(Payment object) {
        em.merge(object);
    }

    /**
     * Method to find an object in the database
     * @param ID identification of the object
     * @return the object that the method found
     */
    @Override
    public Payment find(String ID) {
        return em.find(Payment.class, ID);
    }
}
