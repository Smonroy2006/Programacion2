package co.edu.unbosque.VidaAcademicaService.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.UUID;

@Entity
@Table(name = "vidaacademica")
@NamedQueries(@NamedQuery(name="VidaAcademica.findAll", query="SELECT e FROM VidaAcademica e"))
public class VidaAcademica {

    @Id
    private String id;
    @Column
    private String titulo;
    @Column
    private String universidad;
    @Column
    private boolean completado;

    public VidaAcademica() {
    }

    public VidaAcademica(String id, String titulo, String universidad, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.universidad = universidad;
        this.completado = completado;
    }

    @PrePersist
    public void generarId(){
        if(id == null || id.isEmpty()){
            id = UUID.randomUUID().toString();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
