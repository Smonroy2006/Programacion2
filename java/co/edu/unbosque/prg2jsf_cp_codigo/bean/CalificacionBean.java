package co.edu.unbosque.prg2jsf_cp_codigo.bean;

import co.edu.unbosque.prg2jsf_cp_codigo.model.CalificacionDTO;
import co.edu.unbosque.prg2jsf_cp_codigo.model.exception.NullException;
import co.edu.unbosque.prg2jsf_cp_codigo.service.ICalificacion;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.List;

/**
 * Bean del objeto Calificacion
 */
@Named("calificacionBean")
@ViewScoped
public class CalificacionBean  implements Serializable {

    /*
    TODO
    Terminar de configirar las excepciones, con lo de faces para indicar si se
    guardo o si hubo un error
     */

    private CalificacionDTO calificacion;
    private String ID;
    private String IDProducto;

    @Inject
    private ICalificacion<CalificacionDTO, String> calificacionService;
    private List<CalificacionDTO> calificaciones;

    /**
     * Metodo iniciador, para inicializar las variables, objetos y listas
     */
    @PostConstruct
    public void init(){
        ID = "";
        IDProducto = "";
        calificaciones = calificacionService.getCalificaciones();
        calificacion = new CalificacionDTO();
    }

    /**
     * Metodo para registrar un producto
     * @return, retorna la pagina principal, index
     */
    public String registrar(){

        if(IDProducto == null || IDProducto.trim().isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: El id del producto es nulo.", null));
            return "index.xhtml";
        }

        try {
            calificacionService.registrarCalificacion(IDProducto, calificacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro exitoso",""));
        } catch (NullException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar la calificacion: " + e.getMessage(), null));
        }
        return "index.xhtml";
    }

    /**
     * Metodo para eliminar un objeto almacenado en memoria
     * @return, retorna la pagina principal, index
     */
    public String eliminar(){
        calificacionService.eliminarCalificacion(ID);
        return "index.xhtml";
    }

    /**
     * Metodo para actualziar un objeto y reemplazarlo
     * @return, retorna la pagina principal, index
     */
    public String actualizar(){
        calificacionService.actualizarCalifiacion(calificacion, ID);
        return "index.xhtml";
    }

    /*
    Getters and Setters
     */

    public CalificacionDTO getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionDTO calificacion) {
        this.calificacion = calificacion;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(String IDProducto) {
        this.IDProducto = IDProducto;
        this.calificacion = new CalificacionDTO();
    }

    public List<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
