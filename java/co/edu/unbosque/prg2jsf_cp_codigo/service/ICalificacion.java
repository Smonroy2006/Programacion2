package co.edu.unbosque.prg2jsf_cp_codigo.service;

import co.edu.unbosque.prg2jsf_cp_codigo.model.exception.NullException;

import java.util.List;

/**
 * Interface, con los servicios disponibles para los objetos
 * @param <T> Type, Tipo de objeto, Producto
 * @param <K> Key, Llave del objeto, ID
 */
public interface ICalificacion<T,K> {

    /**
     * Metodo para traer todos los objetos guardados
     * @return, retorna la lista de objetos guardados
     */
    List<T> getCalificaciones();

    /**
     * Metodo para almacenar un objeto
     * @param objetoGuardar, objeto a guardar en memoria
     */
    public void registrarCalificacion(String ID, T objetoGuardar) throws NullException;

    /**
     * Metodo para actualizar un objeto
     * @param objetoActualizar, objeto a actualizar
     * @param ID, id del objeto a reemplazar
     */
    public void actualizarCalifiacion(T objetoActualizar, K ID);

    /**
     * Metodo para eliminar un objeto guardado
     * @param ID, ID del objeto a eliminar
     */
    public void eliminarCalificacion(K ID);

}
