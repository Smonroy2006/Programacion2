package co.edu.unbosque.vidafinanciera.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "vidafinanciera")
@NamedQueries(@NamedQuery(name="VidaFinanciera.findAll", query="SELECT e FROM VidaFinanciera e"))
public class VidaFinanciera {

    @Id
    private String id;
    @Column
    private String banco;
    @Column
    private boolean endeudado;

    public VidaFinanciera() {
    }

    public VidaFinanciera(String id, String banco, boolean endeudado) {
        this.id = id;
        this.banco = banco;
        this.endeudado = endeudado;
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

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public boolean isEndeudado() {
        return endeudado;
    }

    public void setEndeudado(boolean endeudado) {
        this.endeudado = endeudado;
    }
}
