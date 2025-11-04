package co.edu.unbosque.transaccionesbancarias.beans;

import co.edu.unbosque.transaccionesbancarias.model.Transaccion;
import co.edu.unbosque.transaccionesbancarias.model.TransaccionDTO;
import co.edu.unbosque.transaccionesbancarias.model.TransaccionTelefonica;
import co.edu.unbosque.transaccionesbancarias.model.TransaccionTelefonicaDTO;
import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;
import co.edu.unbosque.transaccionesbancarias.services.ITransTelefonica;
import co.edu.unbosque.transaccionesbancarias.services.ITransferencia;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

/**
 * Bean de conexion con la vista
 */
@Named("telefonicaBean")
@RequestScoped
public class TransTelefonicaBean {

    private TransaccionTelefonicaDTO telefonia;
    private String id;

    @Inject
    private ITransTelefonica<TransaccionTelefonicaDTO, String> service;
    private List<TransaccionTelefonicaDTO> transacciones;

    /**
     * Constructor para iniciar las variables
     */
    @PostConstruct
    public void init(){
        id = "";
        transacciones = service.getTransacciones();
    }

    /**
     * Metodo para registrar un objeto
     * @return retorna la pagina principal
     */
    public String registrar(){
        try {
            service.registrarTransaccion(telefonia);
            return "index.xhtml";
        } catch (IDDuplicate e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
        }
        return "index.xhtml";
    }

    /**
     * Metodo para eliminar un objeto guardado
     * @return retorna la pagina principal
     */
    public String eliminar(){
        service.eliminarTransaccion(id);
        return "index.xhtml";
    }

    /**
     * Metodo para actualizar un objeto almacenado
     * @return retorna la pagina principal
     */
    public String actualizar(){
        service.actualizarTransaccion(telefonia);
        return "index.xhtml";
    }

    /*
    Getters & Setters
     */

    public TransaccionTelefonicaDTO getTelefonia() {
        return telefonia;
    }

    public void setTelefonia(TransaccionTelefonicaDTO telefonia) {
        this.telefonia = telefonia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TransaccionTelefonicaDTO> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<TransaccionTelefonicaDTO> transacciones) {
        this.transacciones = transacciones;
    }
}
