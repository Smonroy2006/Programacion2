package co.edu.unbosque.prg2jsf_ptc.services;

import java.util.List;

/**
 * Interface of the object User
 * @param <T> Type of the object, user
 * @param <K>  key of the object, String
 */
public interface IUser <T,K>{

    /**
     * Method to get all the objects that are in the program
     * @return return a list of objects
     */
    public List<T> getAll();

    /**
     * Method to save an object in the system
     * @param object object to be saves
     */
    public void save(T object);

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


}
