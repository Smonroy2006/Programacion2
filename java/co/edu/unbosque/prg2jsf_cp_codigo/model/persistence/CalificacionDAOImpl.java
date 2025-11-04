package co.edu.unbosque.prg2jsf_cp_codigo.model.persistence;

import co.edu.unbosque.prg2jsf_cp_codigo.model.Calificacion;
import co.edu.unbosque.prg2jsf_cp_codigo.model.exception.NullException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO del objeto Califiacion, con todos los metodos del CRUD
 */
@ApplicationScoped
public class CalificacionDAOImpl implements IDAO<Calificacion, String>{

    /*
    TODO
    - Configirar las excepciones
     */

    private static final List<Calificacion> listaCalifiaciones;

    /**
     * Metodo para inicializar la lista, y agregar valores a lista antes de empezar
     */
    static {
        listaCalifiaciones = new ArrayList<>();
    }

    /**
     * Metodo para consultar que objetos estan el lista de objetos
     * @return, retorna la lista de objetos dentro del DAO
     */
    @Override
    public List<Calificacion> consultar() {
        return listaCalifiaciones;
    }

    @Override
    public List<Calificacion> consultarByName(String Name) {

        List<Calificacion> lista = new ArrayList<>();

        for(Calificacion calificacion : listaCalifiaciones){
            if(calificacion.getAutor().trim().toLowerCase().equals(Name.trim().toLowerCase())){
                lista.add(calificacion);
            }
        }

        return lista;
    }

    /**
     * Metodo para guardar un objeto en la lista del DAO
     * @param objetoGuardar, Objeto que ingresa para ser almacenado
     */
    @Override
    public void save(Calificacion objetoGuardar) throws NullException {

        if(objetoGuardar == null){
            throw new NullException("La calificacion tiene que tener valores");
        }

        listaCalifiaciones.add(objetoGuardar);
    }

    /**
     * Metodo para eliminar un producto en la lista por su id
     * @param id, ID que ingresa para ser buscado en la lista
     */
    @Override
    public void delete(String id) {
        Calificacion calificacionEliminar = find(id);
        listaCalifiaciones.remove(calificacionEliminar);
    }

    /**
     * Metodo para reemplazar un objeto guardado por otro con diferente informacion
     * @param objetoActualizar, Objeto que va a reemplazar
     * @param id, ID del objeto que va a ser reemplazado
     */
    @Override
    public void update(Calificacion objetoActualizar, String id) {

        Calificacion calificacionEliminar = find(id);
        listaCalifiaciones.remove(calificacionEliminar);
        listaCalifiaciones.add(objetoActualizar);

    }

    /**
     * Metodo para buscar un objeto en la lista con su ID
     * @param id, ID del objeto a buscar
     * @return, retorna el objeto que encontro en la lista
     */
    @Override
    public Calificacion find(String id) {

        Calificacion calificacionToFind = new Calificacion();

        for(Calificacion calificacion : listaCalifiaciones){
            if(calificacion.getID().equals(id)){
                calificacionToFind = calificacion;
            } else {
                calificacionToFind = null;
            }
        }

        return calificacionToFind;
    }
}
