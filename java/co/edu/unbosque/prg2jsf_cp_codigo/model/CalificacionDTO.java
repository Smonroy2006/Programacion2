package co.edu.unbosque.prg2jsf_cp_codigo.model;

import java.util.Date;

/**
 * Entidad calificacion donde se obtienen las varaibles que componen a este objeto que utilizara el DAO
 * y la clase califiacion sera asignada a un producto (Siempre)
 */
public class CalificacionDTO {

    private String ID;
    private Date fechaCalificacion;
    private String autor;
    private int calificacion;
    private String comentario;
    private Producto producto;

    /**
     * Constructor vacio para crear una calificacion sin parametros
     */
    public CalificacionDTO() {
    }

    /**
     * Constructor con parametros locales de la clase
     * @param ID, ID identificador del comentario
     * @param calificacion, la calificacion dada en un valor de 1 a 5
     * @param comentario, el comentario que se le asigno al producto, en la calificacion
     * @param producto, El producto al que se le asigna el comentario
     */
    public CalificacionDTO(String ID,Date fechaCalificacion, String Autor, int calificacion, String comentario, Producto producto) {
        this.ID = ID;
        this.fechaCalificacion = fechaCalificacion;
        this.autor = Autor;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.producto = producto;
    }

    /*
    Getters & Setters
     */

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(Date fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
