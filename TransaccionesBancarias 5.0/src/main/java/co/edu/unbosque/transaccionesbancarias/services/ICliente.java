package co.edu.unbosque.transaccionesbancarias.services;

import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;

import java.util.List;

/**
 * Interface, con los servicios disponibles para el objeto Cliente
 * @param <T>
 * @param <K>
 */
public interface ICliente<T,K> {

    /**
     * Metodo mostrar todos los objetos guardados
     * @return retorna la lista de objetos guardados
     */
    public List<T> getClientes();

    /**
     * Metodo para guardar un objeto
     * @param objetoGuardar elemento para ser guardado
     */
    public void registrarCliente(T objetoGuardar) throws IDDuplicate;

    /**
     * Metodo para actualizar un objeto
     * @param objetoGuardar objeto que va a reemplazar
     */
    public void actualizarCliente(T objetoGuardar);

    /**
     * Metodo para eliminar un objeto
     * @param id id del objeto a eliminar
     */
    public void eliminarCliente(K id);

}
