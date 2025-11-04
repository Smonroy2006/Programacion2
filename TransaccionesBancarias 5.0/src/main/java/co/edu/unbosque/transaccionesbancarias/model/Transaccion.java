package co.edu.unbosque.transaccionesbancarias.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * Objeto entidad de transaccion
 */
@Table(name = "transacciones")
@NamedQueries(@NamedQuery(name="Transaccion.findAll", query="SELECT e FROM Cliente e"))
@Entity
public class Transaccion {

    //Instancias
    @Id
    @Column
    private String id;
    @Column
    private String nombre;
    @Column
    private double valor;
    @Column
    private String banco;
    @Column
    private Date fecha;


    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    //Constructor
    /**
     * Constructor vacio
     */
    public Transaccion() {
    }

    /**
     * Constructor con intancias propias
     * @param id, identificador del objeto
     * @param nombre, Nombre de la persona que hizo la transaccion
     * @param valor, valor que toma la transaccion
     * @param banco, banco del que se hizo la transaccion
     * @param fecha, fecha en la que se hizo la transaccion
     */
    public Transaccion(String id, String nombre, double valor, String banco, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.banco = banco;
        this.fecha = fecha;
    }

    /*
    Getters & Setters
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
