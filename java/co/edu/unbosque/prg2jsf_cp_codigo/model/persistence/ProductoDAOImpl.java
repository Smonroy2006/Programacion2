package co.edu.unbosque.prg2jsf_cp_codigo.model.persistence;

import co.edu.unbosque.prg2jsf_cp_codigo.model.Producto;
import co.edu.unbosque.prg2jsf_cp_codigo.model.exception.NullException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO del objeto Producto, con todos los metodos del CRUD
 */
@ApplicationScoped
public class ProductoDAOImpl implements IDAO<Producto, String> {

    /*
    TODO
    - Configirar las excepciones
    - Revisar el metodo de consultar para categoria, que funcion si tener que implemenarlo en IDAO
     */

    private static final List<Producto> listaProductos;

    /**
     * Metodo para inicializar la lista, y agregar valores a lista antes de empezar
     */
    static{
        listaProductos = new ArrayList<Producto>();
    }

    /**
     * Metodo para consultar que objetos estan el lista de objetos
     * @return, retorna la lista de objetos dentro del DAO
     */
    @Override
    public List<Producto> consultar() {
        return listaProductos;
    }

    /**
     * Metodo que busca por el nombre del producto
     * @param Name, nombre del producto
     * @return retorna una lista del producto encontrado
     */
    @Override
    public List<Producto> consultarByName(String Name){
        List<Producto> listaProductosPorName = new ArrayList<>();

        for(Producto producto: listaProductos){
            if(normalizar(producto.getNombre()).equals(normalizar(Name))){
                listaProductosPorName.add(producto);
            }
        }
        return listaProductosPorName;
    }

    /**
     * Metodo para normalizar un String y poder compararlos de mejor forma
     * @param s, String a normalizar
     * @return retorna el string normalizado
     */
    public String normalizar(String s){
        if(s == null){
            return "";
        }
        return s.trim().toLowerCase().replaceAll("\\s+","");
    }

    /**
     * Metodo para guardar un objeto en la lista del DAO
     * @param objetoGuardar, Objeto que ingresa para ser almacenado
     */
    @Override
    public void save(Producto objetoGuardar) throws NullException {

        if(objetoGuardar == null){
            throw new NullException("El producto tiene que tener datos");
        }
        listaProductos.add(objetoGuardar);

    }

    /**
     * Metodo para eliminar un producto en la lista por su id
     * @param id, ID que ingresa para ser buscado en la lista
     */
    @Override
    public void delete(String id) {

        Producto productoEliminar = find(id);
        listaProductos.remove(productoEliminar);


    }

    /**
     * Metodo para reemplazar un objeto guardado por otro con diferente informacion
     * @param objetoActualizar, Objeto que va a reemplazar
     * @param id, ID del objeto que va a ser reemplazado
     */
    @Override
    public void update(Producto objetoActualizar, String id) {

        Producto productoEliminar = find(id);
        listaProductos.remove(productoEliminar);
        listaProductos.add(objetoActualizar);

    }

    /**
     * Metodo para buscar un objeto en la lista con su ID
     * @param id, ID del objeto a buscar
     * @return, retorna el objeto que encontro en la lista
     */
    @Override
    public Producto find(String id) {

        Producto  productoToFind = new Producto();

        for(Producto producto: listaProductos){
            if(producto.getID().equals(id)){
                productoToFind = producto;
            } else {
                productoToFind = null;
            }
        }

        return productoToFind;
    }
}
