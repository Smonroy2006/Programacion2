package co.edu.unbosque.transaccionesbancarias.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Objeto / entidad de cliente
 */
@Table(name = "Cliente")
@NamedQueries(@NamedQuery(name="Cliente.findAll", query="SELECT e FROM Cliente e"))
@Entity
public class Cliente {

    @Id
    @Column (name="IDENTIFICACION")
    private int identificacion;

    @Column (name="TIPODOCUMENTO")
    private String tipoDocumento;

    @Column (name="NOMBRE")
    private String nombre;

    @Column (name="APELLIDO")
    private String apellido;

    @Column (name="CORREO")
    private String correo;


    /*
    Fetch sirve para controlar cuando traemos los datos de la base de datos, el "LAZY" le dice a la base de datos que solo
    Me pase los datos cuando yo hago un "get"
     */
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Transaccion> transacciones;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<TransaccionTelefonica> telefonicas;

    /**
     * Constructor vacio
     */
    public Cliente() {
    }

    /**
     * Constructor con instancias locales del objeto
     * @param tipoDocumento,tipo de identificacion del objeto
     * @param identificacion, identicacion del objeto
     * @param nombre, nombre del objeto
     * @param apellido, apellido del objeto
     * @param correo, correo del objeto
     */
    public Cliente(String tipoDocumento, int identificacion, String nombre, String apellido, String correo) {
        this.tipoDocumento = tipoDocumento;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    /*
    Getters & Setters
     */

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
