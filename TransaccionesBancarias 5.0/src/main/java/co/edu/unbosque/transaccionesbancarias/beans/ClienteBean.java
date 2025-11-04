package co.edu.unbosque.transaccionesbancarias.beans;

import co.edu.unbosque.transaccionesbancarias.model.ClienteDTO;
import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;
import co.edu.unbosque.transaccionesbancarias.services.ICliente;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("clienteBean")
@RequestScoped
public class ClienteBean {

    private ClienteDTO cliente;
    private Integer identificacion;

    @Inject
    private ICliente<ClienteDTO, Integer> service;
    private List<ClienteDTO> clientes;

    /**
     * Inicializador para iniciar las variables
     */
    @PostConstruct
    public void init() {
        cliente = new ClienteDTO();
        identificacion = 0;
        clientes = service.getClientes();
    }

    /**
     * Metodo para registrar un cliente en el sistema
     * @return retorna la pagina principal
     */
    public String registrar(){
        try{
            service.registrarCliente(cliente);
            return "index.xhtml";
        } catch (IDDuplicate e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El cliente ya existe", e.getMessage()));
        }
        return "index.xhtml";
    }

    public String eliminar(){
        service.eliminarCliente(identificacion);
        return "index.xhtml";
    }

    public String actualizar(){
        service.actualizarCliente(cliente);
        return "index.xhtml";
    }

    /*
    Getters & Setters
     */

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public ICliente<ClienteDTO, Integer> getService() {
        return service;
    }

    public void setService(ICliente<ClienteDTO, Integer> service) {
        this.service = service;
    }

    public List<ClienteDTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteDTO> clientes) {
        this.clientes = clientes;
    }
}
