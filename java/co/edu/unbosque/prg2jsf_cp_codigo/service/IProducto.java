package co.edu.unbosque.prg2jsf_cp_codigo.service;

import co.edu.unbosque.prg2jsf_cp_codigo.model.exception.NullException;

import java.util.List;

/**
 * Interface, con los servicio disponibles para los objetos
 * @param <T>, Type, Tipo de objeto, Producto
 * @param <K> Key, Llave del objeto, ID
 */
public interface IProducto<T,K> {

    /**
     * Metodo para traer todos los objetos guardados
     * @return, retorna la lista de objetos guardados
     */
    List<T> getProductos();

    List<T> consultarByName(String Name);

    /**
     * Metodo para almacenar un objeto
     * @param objetoGuardar, objeto a guardar en memoria
     */
    public void registrarProducto(T objetoGuardar) throws NullException;

    /**
     * Metodo para actualizar un objeto
     * @param objetoActualizar, objeto a actualizar
     * @param ID, id del objeto a reemplazar
     */
    public void actualizarProducto(T objetoActualizar, K ID);

    /**
     * Metodo para eliminar un objeto guardado
     * @param ID, ID del objeto a eliminar
     */
    public void eliminarProducto(K ID);

}
