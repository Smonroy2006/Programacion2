package co.edu.unbosque.transaccionesbancarias.model;

/**
 * Objeto / entidad de cliente
 */
public class ClienteDTO {

    private String tipoDocumento;
    private int identificacion;
    private String nombre;
    private String apellido;
    private String correo;

    /**
     * Constructor vacio
     */
    public ClienteDTO() {
    }

    /**
     * Constructor con instancias locales del objeto
     * @param tipoDocumento,tipo de identificacion del objeto
     * @param identificacion, identicacion del objeto
     * @param nombre, nombre del objeto
     * @param apellido, apellido del objeto
     * @param correo, correo del objeto
     */
    public ClienteDTO(String tipoDocumento, int identificacion, String nombre, String apellido, String correo) {
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
