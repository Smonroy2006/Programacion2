package co.edu.unbosque.vidapersonalservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Vidapersonal")
@NamedQueries(@NamedQuery(name="vidaPersonal.findAll", query="SELECT e FROM VidaPersonal e"))
public class VidaPersonal {


    @Id
    private String id;
    @Column
    private String nombre;

    public VidaPersonal() {
    }

    public VidaPersonal(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

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
}
