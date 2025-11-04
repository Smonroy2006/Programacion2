package co.edu.unbosque.prg2jsf_cp_codigo.bean;

import co.edu.unbosque.prg2jsf_cp_codigo.model.ProductoDTO;
import co.edu.unbosque.prg2jsf_cp_codigo.model.exception.NullException;
import co.edu.unbosque.prg2jsf_cp_codigo.service.IProducto;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

/**
 * Bean del objeto Producto
 */
@Named("productoBean")
@RequestScoped
public class ProductoBean implements Serializable {

    /*
    TODO
    Terminar de configirar las excepciones, con lo de faces para indicar si se
    guardo o si hubo un error
     */

    private ProductoDTO producto;
    private String ID;
    private String nameProduct;

    @Inject
    private IProducto<ProductoDTO,String> productoService;
    private List<ProductoDTO> productos;

    /**
     * Metodo iniciador, para inicializar las variables, objetos y listas
     */
    @PostConstruct
    public void init() {
        ID = "";
        nameProduct = "";
        productos = productoService.getProductos();
        producto = new ProductoDTO();
    }

    public void consultarByName(){
        productos = productoService.consultarByName(nameProduct);
    }

    /**
     * Metodo para registrar un producto
     * @return, retorna la pagina principal, index
     */
    public String registrar(){
        try {
            productoService.registrarProducto(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro exitoso",""));
        } catch (NullException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar el producto: " + e.getMessage(), null));
        }
        return "index.xhtml";
    }

    /**
     * Metodo para eliminar un producto
     * @return, retorna la pagina principal, index
     */
    public String eliminar(){
        productoService.eliminarProducto(ID);
        return "index.xhtml";
    }

    /**
     * Metodo para actualizar un producto, con el ID
     * @return, retorna la pagina principal, index
     */
    public String actualizar(ProductoDTO producto, String ID){
        producto.setEstado(!producto.isEstado());
        productoService.actualizarProducto(producto, ID);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Estado actualizado: " + (producto.isEstado() ? "Desbloqueado" : "Bloqueado"), null));
        return "index.xhtml";
    }

    /*
    Getters and Setters
     */

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
