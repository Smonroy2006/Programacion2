package co.edu.unbosque.prg2jsf_cp_codigo.service;

import co.edu.unbosque.prg2jsf_cp_codigo.model.Calificacion;
import co.edu.unbosque.prg2jsf_cp_codigo.model.CalificacionDTO;
import co.edu.unbosque.prg2jsf_cp_codigo.model.DataMapper;
import co.edu.unbosque.prg2jsf_cp_codigo.model.Producto;
import co.edu.unbosque.prg2jsf_cp_codigo.model.exception.NullException;
import co.edu.unbosque.prg2jsf_cp_codigo.model.persistence.IDAO;
import co.edu.unbosque.prg2jsf_cp_codigo.model.persistence.ProductoDAOImpl;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Clase con los servicio disponibles para el objeto Calificacion
 */
@Stateless
public class CalificacionImplementacion implements ICalificacion<CalificacionDTO, String>{

    /*
    TODO
    - Configurar las excepciones
    - Revisar como añadir el comentario a un objeto
    - Revisar para implementar el codigo UUII dentro del objeto
     */

    @Inject
    private IDAO<Calificacion, String> DAO;

    @Inject
    private IDAO<Producto, String> DAOProducto;
    @Inject
    private ProductoDAOImpl productoDAOImpl;


    /**
     * Metodo para mostrar todas las transacciones guardadas
     * @return, retorna los objetos guardados
     */
    @Override
    public List<CalificacionDTO> getCalificaciones() {
        List<Calificacion> listaCalificaciones = DAO.consultar();
        return DataMapper.fromToListCalificacionesDTO(listaCalificaciones);
    }

    /**
     * Servicio para guardar un objeto
     * @param IDProducto, ID del producto para asignar la calificacion al producto
     * @param objetoGuardar, Objeto que se va a guardar
     */
    @Override
    public void registrarCalificacion(String IDProducto, CalificacionDTO objetoGuardar) throws NullException {

        Producto producto = DAOProducto.find(IDProducto);

        if(producto == null){
            throw new NullException("No existe el producto con el id: " + IDProducto);
        }

        objetoGuardar.setID(UUID.randomUUID().toString());
        objetoGuardar.setFechaCalificacion(new Date());
        objetoGuardar.setProducto(producto);

        actualizarProducto(producto, objetoGuardar);

        DAO.save(DataMapper.fromToCalificacion(objetoGuardar));

    }

    /**
     * Servicio para reemplazar un objeto con nueva informacion
     * @param objetoActualizar, Objeto que va a reemplazar
     * @param ID, ID para identificar el objeto almacenado
     */
    @Override
    public void actualizarCalifiacion(CalificacionDTO objetoActualizar, String ID) {

        DAO.update(DataMapper.fromToCalificacion(objetoActualizar), ID);

    }

    /**
     * Servicio para eliminar un objeto almacenado
     * @param ID, ID para identificar el objeto almacenado
     */
    @Override
    public void eliminarCalificacion(String ID) {

        DAO.delete(ID);

    }

    public void actualizarProducto(Producto producto, CalificacionDTO objetoGuardar){

        if(producto.getCalificaciones() == null){
            producto.setCalificaciones(new ArrayList<>());
        }

        producto.getCalificaciones().add(DataMapper.fromToCalificacion(objetoGuardar));
        producto.setCantidadComentarios(producto.getCantidadComentarios()+1);

        double sumatoriaCalifiaciones = 0;

        for(Calificacion calificacion : producto.getCalificaciones()){
            sumatoriaCalifiaciones += calificacion.getCalificacion();
        }

        double promedio = 0;
        if(!producto.getCalificaciones().isEmpty()){
            promedio = sumatoriaCalifiaciones / producto.getCalificaciones().size();
        }

        producto.setPromedioCalificaciones(promedio);
        producto.setUltimaCalificacionFecha(new Date());

    }
}
