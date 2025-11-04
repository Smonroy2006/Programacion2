package co.edu.unbosque.prg2jsf_ptc.services;

import co.edu.unbosque.prg2jsf_ptc.model.*;
import co.edu.unbosque.prg2jsf_ptc.model.persistence.IDAOInstallement;
import co.edu.unbosque.prg2jsf_ptc.model.persistence.IDAOPayment;
import co.edu.unbosque.prg2jsf_ptc.model.persistence.IDAOUser;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.List;


/**
 * Service of the object installemet
 */
@Stateless
public class InstallmentImpl implements IInstallment<InstallmentDTO, String>{

    private ModelMapper modelMapper;

    @Inject
    private IDAOInstallement<Installment, String> DAO;

    /**
     * Method that gets all the objects in the system
     * @return the list of objects
     */
    @Override
    public List<InstallmentDTO> getAll() {

        List<Installment> installments = DAO.getAll();

        return modelMapper.map(installments, new TypeToken<List<InstallmentDTO>>() {}.getType());
    }

    /**
     * Method that save in the system an object
     * @param installment, the installment to be save
     */
    @Override
    public void save(InstallmentDTO installment) {
            DAO.save(modelMapper.map(installment, Installment.class));
    }

    /**
     * Method that delete an object in the system
     * @param ID identificator of the object
     */
    @Override
    public void delete(String ID) {
        DAO.delete(ID);
    }

    /**
     * Method that update or replace an object in the system
     * @param object User to be updated
     */
    @Override
    public void update(InstallmentDTO object) {
        DAO.update(modelMapper.map(object, Installment.class));
    }

}
