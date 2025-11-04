package co.edu.unbosque.vidafinanciera.model;

import jakarta.persistence.*;

import java.util.UUID;


public class VidaFinancieraDTO {

    private String id;
    private String banco;
    private boolean endeudado;

    public VidaFinancieraDTO() {
    }

    public VidaFinancieraDTO(String id, String banco, boolean endeudado) {
        this.id = id;
        this.banco = banco;
        this.endeudado = endeudado;
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
