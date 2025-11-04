package co.edu.unbosque.prg2jsf_ptc.model.persistence;

import co.edu.unbosque.prg2jsf_ptc.model.Payment;
import co.edu.unbosque.prg2jsf_ptc.model.User;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.id.IntegralDataTypeHolder;

import java.util.List;

@Stateless
public class DAOUserImpl implements IDAOUser<User, String>{

    @PersistenceContext(unitName = "PagosTCMyDB")
    private EntityManager em;

    /**
     * Method to get all the objects in the database
     * @return the objects in the database
     */
    @Override
    public List<User> getAll() {
        return em.createNamedQuery("User.findAll",  User.class).getResultList();
    }

    /**
     * Mehtod to save a object into the database
     * @param object payment to save
     */
    @Override
    public void save(User object) {
        em.persist(object);
    }

    /**
     * Method to find and delete an object in the database
     * @param ID Identification of the object in the database
     */
    @Override
    public void delete(String ID) {
        em.remove(em.find(User.class, ID));
    }

    /**
     * Method to update or replace an object in the database
     * @param object
     */
    @Override
    public void update(User object) {
        em.merge(object);
    }

    /**
     * Method to find an object in the database
     * @param ID identification of the object
     * @return the object that the method found
     */
    @Override
    public User find(String ID) {
        return em.find(User.class, ID);
    }
}
