package co.edu.unbosque.prg2jsf_cp_codigo.model.persistence;

import co.edu.unbosque.prg2jsf_cp_codigo.model.exception.NullException;

import java.util.List;

/**
 * Inerface de todos los DAOs de las entidades dentro del programa
 * @param <T> Type, Tipo del objeto, en este caso que producto
 * @param <K> Key, Tipod de llave del objeto que se manipulo
 */
public interface IDAO <T, K> {

    /**
     * Metodo para consultar la lista de todos los producto
     * @return, retorna la lista de objetos que almacena
     */
    public List<T> consultar();

    /**
     * Metodo para buscar por un nombre un producto o calificacion
     * @param Name, nombre que ingresa
     * @return retorna una lista del objeto que encontro
     */
    public List<T> consultarByName(String Name);

    /**
     * Metodo para guardar un objeto dentro de la lista
     * @param objetoGuardar, objeto que ingresa para ser almacenado
     */
    public void save(T objetoGuardar) throws NullException;

    /**
     * Metodo para eliminar un producto dentro de la lista
     * @param id
     */
    public void delete(K id);

    /**
     * Metodo para actulizar un objeto dentro de la lista, y ser reconocido por el ID
     * @param objetoActualizar, Objeto que ingresa para ser actualizado, o reemplazado
     * @param id, ID que reconoce el objeto para ser actualizado
     */
    public void update(T objetoActualizar, K id);

    /**
     * Metodo para buscar un objeto dentro de la lista mediante el ID
     * @param id, identificador del objeto
     * @return, retorna el objeto encontrado con ese ID
     */
    public T find(K id);

}
