package co.edu.unbosque.transaccionesbancarias.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * Clase que hereda de transaccion y contiene todas las instancia de transaccion telefonica y transaccion
 */
@Table(name = "transtelefonica")
@NamedQueries(@NamedQuery(name="TransTelefonica.findAll", query="SELECT e FROM Cliente e"))
@Entity
public class TransaccionTelefonica extends Transaccion{

    //Instacias
    @Id
    @Column
    private String nombreDestinatario;
    @Column
    private String operador;
    @Column
    private String numeroTelefonico;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    //Constructores

    /**
     * Constructor vacio
     */
    public TransaccionTelefonica() {
    }

    /**
     * Constructor con instancias locales
     * @param nombreDestinatario, nombre de la persona que recibira la transaccion
     * @param operador, operador de la persona que recibira la transaccion
     * @param numeroTelefonico, numero telefonico de la persona que recibe la transaccion
     */
    public TransaccionTelefonica(String nombreDestinatario, String operador, String numeroTelefonico) {
        this.nombreDestinatario = nombreDestinatario;
        this.operador = operador;
        this.numeroTelefonico = numeroTelefonico;
    }

    /**
     * Constructor con las instacias de la super clase(Transacciones)
     * @param id, identificador de la transaccion
     * @param nombre, nombre de la persona que hace la transaccion
     * @param valor, valor de la transaccion
     * @param banco, banco desde donde se hace la transaccion
     * @param fecha, fecha que se hace la transaccion
     */
    public TransaccionTelefonica(String id, String nombre, double valor, String banco, Date fecha) {
        super(id, nombre, valor, banco, fecha);
    }

    /**
     * Constructor con las instancias locales y de la super clase
     * @param id, identificador de la transaccion
     * @param nombre, nombre de la persona que hace la transaccion
     * @param valor, valor de la transaccion
     * @param banco, banco desde donde se hace la transaccion
     * @param fecha, fecha desde donde se hace la transaccion
     * @param nombreDestinatario, nombre la persona que recibe la transaccion
     * @param operador, operador de la persona que recibe la transaccion
     * @param numeroTelefonico, numero de la persona que recibe la transaccion
     */
    public TransaccionTelefonica(String id, String nombre, double valor, String banco, Date fecha, String nombreDestinatario, String operador, String numeroTelefonico) {
        super(id, nombre, valor, banco, fecha);
        this.nombreDestinatario = nombreDestinatario;
        this.operador = operador;
        this.numeroTelefonico = numeroTelefonico;
    }

    /*
    Getters & Setters
     */

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
}
