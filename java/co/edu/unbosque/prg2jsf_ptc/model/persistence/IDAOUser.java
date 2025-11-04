package co.edu.unbosque.prg2jsf_ptc.model.persistence;

import java.util.List;

/**
 * Interface that contains the metods CRUD
 * @param <T> Type, the of the object
 * @param <K> Key, The acces to the object
 */
public interface IDAOUser <T,K>{

    /**
     * A method that return all the objects in the database
     * @return return the objects in the database
     */
    public List<T> getAll();

    /**
     * Method that save the object in the database
     * @param object Type to save in the database
     */
    public void save(T object);

    /**
     * Method to delete a object in the database
     * @param ID Identification of the object
     */
    public void delete(K ID);

    /**
     * Methos to update or replace in the databse
     * @param object Object to be updated
     */
    public void update(T object);

    /**
     * Method to find an object in the database
     * @param ID The object that wants to be found
     */
    public T find(K ID);

}
