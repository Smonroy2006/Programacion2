package co.edu.unbosque.prg2jsf_cp_codigo.service;

import co.edu.unbosque.prg2jsf_cp_codigo.model.DataMapper;
import co.edu.unbosque.prg2jsf_cp_codigo.model.Producto;
import co.edu.unbosque.prg2jsf_cp_codigo.model.ProductoDTO;
import co.edu.unbosque.prg2jsf_cp_codigo.model.exception.NullException;
import co.edu.unbosque.prg2jsf_cp_codigo.model.persistence.IDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

/**
 * Clase con los servicios disponibles para el objeto Producto
 */
@Stateless
public class ProductoImplementacion implements IProducto<ProductoDTO, String>{

    /*
    TODO
    - Configurar las excepciones
    - Revisar como añadir el comentario a un objeto
    - Revisar para implementar el codigo UUII dentro del objeto
     */

    @Inject
    private IDAO<Producto, String> DAO;

    public ProductoImplementacion() {
    }

    /**
     * Servicio para mostrar todas las transacciones guardadas
     * @return, retorna los objetos guardados
     */
    @Override
    public List<ProductoDTO> getProductos() {
        List<Producto> listaProductos = DAO.consultar();
        return DataMapper.fromToListProductoDTO(listaProductos);
    }

    @Override
    public List<ProductoDTO> consultarByName(String Name) {
        List<Producto> listaByCategory = DAO.consultar();
        listaByCategory = DAO.consultarByName(Name);
        return DataMapper.fromToListProductoDTO(listaByCategory);
    }


    /**
     * Servicio para guardar un objeto
     * @param objetoGuardar, objeto a guardar
     */
    @Override
    public void registrarProducto(ProductoDTO objetoGuardar) throws NullException {

        objetoGuardar.setID(UUID.randomUUID().toString());
        objetoGuardar.setEstado(true);
        objetoGuardar.setPromedioCalificaciones(0);
        objetoGuardar.setCantidadComentarios(0);

        DAO.save(DataMapper.fromToProducto(objetoGuardar));
    }

    /**
     * Servicio para actualizar un objeto
     * @param objetoActualizar, objeto con la nueva informacion
     * @param ID, ID del objeto a reemplazar
     */
    @Override
    public void actualizarProducto(ProductoDTO objetoActualizar, String ID) {
        DAO.update(DataMapper.fromToProducto(objetoActualizar), ID);
    }

    /**
     * Servicio para eliminar un objeto guardado
     * @param ID, ID del objeto que se eliminara
     */
    @Override
    public void eliminarProducto(String ID) {
        DAO.delete(ID);
    }
}
