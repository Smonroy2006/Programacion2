package co.edu.unbosque.prg2jsf_ptc.model.persistence;

import co.edu.unbosque.prg2jsf_ptc.model.Installment;
import co.edu.unbosque.prg2jsf_ptc.model.Payment;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class DAOInstallement implements IDAOInstallement<Installment, String> {

    @PersistenceContext(name="PagosTCMyDB")
    private EntityManager em;

    /**
     * Method to get all the objects in the database
     * @return the objects in the database
     */
    @Override
    public List<Installment> getAll() {
        return em.createNamedQuery("Installment.findAll",  Installment.class).getResultList();
    }

    /**
     * Mehtod to save a object into the database
     * @param object payment to save
     */
    @Override
    public void save(Installment object) {
        em.persist(object);
    }

    /**
     * Method to find and delete an object in the database
     * @param ID Identification of the object in the database
     */
    @Override
    public void delete(String ID) {
        em.remove(em.find(Installment.class, ID));
    }

    /**
     * Method to update or replace an object in the database
     * @param object to be updated
     */
    @Override
    public void update(Installment object) {
        em.merge(object);
    }

    /**
     * Method to find an object in the database
     * @param ID identification of the object
     * @return the object that the method found
     */
    @Override
    public Installment find(String ID) {
        return em.find(Installment.class, ID);
    }

}
