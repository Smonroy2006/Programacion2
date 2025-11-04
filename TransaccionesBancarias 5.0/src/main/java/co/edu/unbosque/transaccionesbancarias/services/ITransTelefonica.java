package co.edu.unbosque.transaccionesbancarias.services;

import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;

import java.util.List;

/**
 * Interface, con los servicios disponibles para los objetos
 * @param <T> Type, tipo del objeto, Transaccion
 * @param <K> Key, Llave del objeto, String ID
 */
public interface ITransTelefonica<T,K> {

    /**
     * Metodo mostrar todos los objetos guardados
     * @return retorna la lista de objetos guardados
     */
    public List<T> getTransacciones();

    /**
     * Metodo para guardar un objeto
     * @param objetoGuardar elemento para ser guardado
     */
    public void registrarTransaccion(T objetoGuardar) throws IDDuplicate;

    /**
     * Metodo para actualizar un objeto
     * @param objetoGuardar objeto que va a reemplazar
     * @param id Id del objeto a guardar
     */
    public void actualizarTransaccion(T objetoGuardar);

    /**
     * Metodo para elimianr un objeto
     * @param id id del objeto a eliminar
     */
    public void eliminarTransaccion(K id);

}
