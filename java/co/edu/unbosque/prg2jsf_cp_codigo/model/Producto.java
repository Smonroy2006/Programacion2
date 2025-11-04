package co.edu.unbosque.prg2jsf_cp_codigo.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Entidad producto donde se obtienen las varaibles que ccomponen a este objeto que utilizara el DAO
 */
public class Producto {

    // Variables del objeto producto
    private String nombre;
    private String ID;
    private String categoria;
    private String descripcion;
    private boolean estado;
    private double promedioCalificaciones;
    private int cantidadComentarios;
    private List<Calificacion> calificaciones;
    private int calificacion;
    private Date ultimaCalificacionFecha;

    /**
     * Constructor vacio, que permite crear el objeto sin parametros
     */
    public Producto() {
    }

    /**
     * Constructor con las variables del producto
     * @param nombre, Nombre que se asigna al producto
     * @param ID, Identificador del producto dentro del sistema
     * @param categoria, Categoria del producto, de que tipo es
     * @param descripcion, Que es producto, una descripcion
     * @param estado, Estado para califiacion, activo o bloqueado
     * @param promedioCalificaciones, Promedio total de todas la califiaciones que contiene
     * @param cantidadComentarios, Cantidad de comentarios que tiene el producto
     * @param calificaciones, Todos los objetos calificaciones asignados al producto
     * @param ultimaCalificacionFecha, Es la fecha de la ultima calificacion hecha por un cliente
     */
    public Producto(String nombre, String ID, String categoria, String descripcion, boolean estado, double promedioCalificaciones, int cantidadComentarios, List<Calificacion> calificaciones, int calificacion, Date ultimaCalificacionFecha) {
        this.nombre = nombre;
        this.ID = ID;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.promedioCalificaciones = promedioCalificaciones;
        this.cantidadComentarios = cantidadComentarios;
        this.calificaciones = calificaciones;
        this.calificacion = calificacion;
        this.ultimaCalificacionFecha = ultimaCalificacionFecha;
    }



    /*
    Getters & Setters
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPromedioCalificaciones() {
        return promedioCalificaciones;
    }

    public void setPromedioCalificaciones(double promedioCalificaciones) {
        this.promedioCalificaciones = promedioCalificaciones;
    }

    public int getCantidadComentarios() {
        return cantidadComentarios;
    }

    public void setCantidadComentarios(int cantidadComentarios) {
        this.cantidadComentarios = cantidadComentarios;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getUltimaCalificacionFecha() {
        return ultimaCalificacionFecha;
    }

    public void setUltimaCalificacionFecha(Date ultimaCalificacionFecha) {
        this.ultimaCalificacionFecha = ultimaCalificacionFecha;
    }
}
