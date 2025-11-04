package co.edu.unbosque.transaccionesbancarias.model;

import java.util.Date;

/**
 * Objeto entidad de transaccion
 */
public class TransaccionDTO {

    //Instancias
    private String id;
    private String nombre;
    private double valor;
    private String banco;
    private Date fecha;
    private ClienteDTO cliente;

    /*
    TODO agregar constructores y getters and setters nuevos
     */

    //Constructor
    /**
     * Constructor vacio
     */
    public TransaccionDTO() {
    }

    /**
     * Constructor con instancias propias
     * @param id, identificador del objeto
     * @param nombre, Nombre de la persona que hizo la transaccion
     * @param valor, valor que toma la transaccion
     * @param banco, banco del que se hizo la transaccion
     * @param fecha, fecha en la que se hizo la transaccion
     */
    public TransaccionDTO(String id, String nombre, double valor, String banco, Date fecha) {
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

