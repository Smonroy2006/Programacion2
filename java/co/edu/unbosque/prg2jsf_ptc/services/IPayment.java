package co.edu.unbosque.prg2jsf_ptc.services;

import co.edu.unbosque.prg2jsf_ptc.model.UserDTO;

import java.util.List;

/**
 * Interface of the service payment
 * @param <T> Type of the object, Payment
 * @param <K> Key of the object, String
 */
public interface IPayment<T,K> {

    /**
     * Method to get all the objects that are in the program
     * @return return a list of objects
     */
    public List<T> getAll();

    /**
     * Method to save an object in the system
     * @param object object to be saves
     */
    public void save(T object, UserDTO user);

    /**
     * Method to delete an object that are in the system
     * @param ID Identification of the object
     */
    public void delete(K ID);

    /**
     * Method to update or replace an object in the system
     * @param object Object to be replaced
     */
    public void update(T object);

    /**
     * Method to search a payment with his code
     * @param code, the identificaction of the code
     */
    public void find(K code);

}
