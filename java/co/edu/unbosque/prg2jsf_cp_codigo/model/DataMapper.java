package co.edu.unbosque.prg2jsf_cp_codigo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para mapear los datos, de un Objeto DTO a una entidad para almacenar
 */
public class DataMapper {

    /**
     * Constructor vacio
     */
    public DataMapper() {
    }

    /*
    Seccion para producto
     */

    //Seccion para objetos
    /**
     * Metodo para mapear de DTO a entidad
     * @param dto, dto a mapear
     * @return retorna el objeto mapeado a entidad
     */
    public static Producto fromToProducto(ProductoDTO dto){
        Producto entity = new  Producto();
        entity = new Producto(dto.getNombre(), dto.getID(), dto.getCategoria(), dto.getDescripcion(), dto.isEstado(), dto.getPromedioCalificaciones(), dto.getCantidadComentarios(), dto.getCalificaciones(),dto.getCalificacion(), dto.getUltimaCalificacionFecha());
        return entity;
    }

    /**
     * Metodo para mapear de entidad a DTO
     * @param entity, objeto a mapear
     * @return retorna el objeto mapeado a DTO
     */
    public  static ProductoDTO fromToProductoDTO(Producto entity){
        ProductoDTO dto = new ProductoDTO();
        dto = new ProductoDTO(entity.getNombre(), entity.getID(), entity.getCategoria(), entity.getDescripcion(), entity.isEstado(), entity.getPromedioCalificaciones(), entity.getCantidadComentarios(), entity.getCalificaciones(),entity.getCalificacion(), entity.getUltimaCalificacionFecha());
        return dto;
    }

    //Seccion para listas
    /**
     * Metodo para mapear una ListaDTO a una ListaEntidad
     * @param dtoList, lista a mapear
     * @return lista mapeada a entidad
     */
    public static List<Producto> fromToListProducto(List<ProductoDTO> dtoList){
        List<Producto> listEntity = new ArrayList<>();
        for (ProductoDTO d : dtoList) {
            listEntity.add(new Producto(d.getNombre(), d.getID(), d.getCategoria(), d.getDescripcion(), d.isEstado(), d.getPromedioCalificaciones(), d.getCantidadComentarios(), d.getCalificaciones(),d.getCalificacion(), d.getUltimaCalificacionFecha()));
        }
        return listEntity;
    }

    /**
     * Metodo para mapear de listaEntidad a listaDTO
     * @param listEntity, lista a mapear
     * @return lista mapeada a DTO
     */
    public static List<ProductoDTO> fromToListProductoDTO(List<Producto> listEntity){
        List<ProductoDTO> listDTO = new ArrayList<>();
        for (Producto e :  listEntity) {
            listDTO.add(new ProductoDTO(e.getNombre(), e.getID(), e.getCategoria(), e.getDescripcion(), e.isEstado(), e.getPromedioCalificaciones(), e.getCantidadComentarios(), e.getCalificaciones(),e.getCalificacion(), e.getUltimaCalificacionFecha()));
        }
        return listDTO;
    }

    /*
    Seccion para califiacion
     */

    //Seccion para objetos
    /**
     * Metodo para pasar de DTO a Entidad
     * @param dto, dto a mapear
     * @return entidad mapeada
     */
    public static Calificacion fromToCalificacion(CalificacionDTO dto) {
        Calificacion entity = new Calificacion();
        entity = new Calificacion(dto.getID(), dto.getFechaCalificacion(), dto.getAutor(), dto.getCalificacion(), dto.getComentario(), dto.getProducto());
        return entity;
    }

    /**
     * Metodo para mapear de Entidad a DTO
     * @param entity, entidad que se mapeara a DTO
     * @return retorna el objeto mapeado
     */
    public static CalificacionDTO fromToCalificacionDTO(Calificacion entity) {
        CalificacionDTO dto = new CalificacionDTO();
        dto = new CalificacionDTO(entity.getID(), entity.getFechaCalificacion(), entity.getAutor(), entity.getCalificacion(), entity.getComentario(), entity.getProducto());
        return dto;
    }

    //Seccion para listas
    /**
     * Metodo para mapear una lista de DTOs a entidades
     * @param listDTO, lista dto para mapear
     * @return lista mapeada a entidad
     */
    public static List<Calificacion> fromToListCalificaciones(List<CalificacionDTO> listDTO) {
        List<Calificacion> listEntity = new ArrayList<>();
        for (CalificacionDTO d : listDTO) {
            listEntity.add(new Calificacion(d.getID(),d.getFechaCalificacion(), d.getAutor(), d.getCalificacion(), d.getComentario(), d.getProducto()));
        }
        return listEntity;
    }

    /**
     * Metodo para mapear una lista de entidades a DTOs
     * @param listEntity, lista entiad para mapear
     * @return lista mapeada a dto
     */
    public static List<CalificacionDTO> fromToListCalificacionesDTO(List<Calificacion> listEntity) {
        List<CalificacionDTO> listDTO = new ArrayList<>();
        for (Calificacion e : listEntity) {
            listDTO.add(new CalificacionDTO(e.getID(),e.getFechaCalificacion(),e.getAutor(), e.getCalificacion(), e.getComentario(), e.getProducto()));
        }
        return listDTO;
    }
}
