package co.edu.unbosque.transaccionesbancarias.model.persistence;

import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;

import java.util.List;

/**
 * Interface del objeto cliente con todo el CRUD
 * @param <T> type, tipo de objeto, cliente
 * @param <K> key, tipo de llave int = identifiacion
 */
public interface IDAOCliente<T,K> {

    /**
     * Metodo para consultar un objeto
     * @return retorna la lista de objetos
     */
    public List<T> consultar();

    /**
     * Metodo para guardar los objetos dentro de la lista
     * @param objetoGuardar, objeto que entra para guardar
     */
    public void save(T objetoGuardar) throws IDDuplicate;

    /**
     * Metodo para eliminar un objeto dentro dentro de la lista
     * @param id id del objeto a eliminar
     */
    public void delete(K id);

    /**
     * Metodo para actualizar/reemplazar un objeto dentro de la lista
     * @param objetoActualziar metodo para actualizar un objeto
     */
    public void update(T objetoActualziar);

    /**
     * Metodo para encontrar un objeto dentro de la lista
     * @param id id del objeto a encontrar
     * @return el objeto encontrado de la lista
     */
    public T find(K id);

}
