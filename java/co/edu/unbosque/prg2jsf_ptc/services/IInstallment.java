package co.edu.unbosque.prg2jsf_ptc.services;

import co.edu.unbosque.prg2jsf_ptc.model.*;

import java.util.List;

/**
 * Inteface of the service installement
 * @param <T> Type of the object, installement
 * @param <K> Key of the object, String
 */
public interface IInstallment<T,K> {

    /**
     * Method to get all the objects that are in the program
     * @return return a list of objects
     */
    public List<T> getAll();

    /**
     * Method to save an object in the system
     * @param installment, the installment to be save
     */
    public void save(T installment);

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
