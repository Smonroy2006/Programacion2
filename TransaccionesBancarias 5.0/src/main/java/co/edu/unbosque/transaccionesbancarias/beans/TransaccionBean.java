package co.edu.unbosque.transaccionesbancarias.beans;

import co.edu.unbosque.transaccionesbancarias.model.Transaccion;
import co.edu.unbosque.transaccionesbancarias.model.TransaccionDTO;
import co.edu.unbosque.transaccionesbancarias.model.TransaccionTelefonica;
import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;
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

@Named("transaccionBean")
@RequestScoped
public class TransaccionBean {

    private TransaccionDTO transaccion;
    private String id;

    @Inject
    private ITransferencia<TransaccionDTO, String> service;
    private List<TransaccionDTO> transacciones;

    /**
     * Inicializador para iniciar las variables
     */
    @PostConstruct
    public void init(){
        transaccion = new TransaccionDTO();
        id = "";
        transacciones = service.getTransacciones();
    }

    /**
     * Metodo para registrar un objeto
     * @return retorna la pagina principal
     */
    public String registrar(){
        try {
            service.registrarTransaccion(transaccion);
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
        service.actualizarTransaccion(transaccion);
        return "index.xhtml";
    }

    /*
    Getters & Setters
     */

    public TransaccionDTO getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(TransaccionDTO transaccion) {
        this.transaccion = transaccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<TransaccionDTO> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<TransaccionDTO> transacciones) {
        this.transacciones = transacciones;
    }
}
