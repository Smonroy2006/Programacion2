package co.edu.unbosque.prg2jsf_ptc.model;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PaymentDTO {

    private String code;
    private int numberInstallments;
    private String nameCommerce;
    private double price;
    private double iva;
    private boolean status;
    private Date date;
    private User user;
    private List<Installment> installments;

    /**
     * Empty Constructor
     */
    public PaymentDTO() {
    }

    /**
     * Contructor with all the local parameters
     *
     * @param code                String, code to identify the payment
     * @param numberInstallments, number of installments that the payment have
     * @param nameCommerce        String, the name of the commerce
     * @param price               Double, the price of the purchase
     * @param iva                 Double, IVA
     * @param status              Booolean, the approval of the payment
     * @param date                Calendar, the date of the purschase
     * @param user                User, the user that make the payment
     * @param installments        List, the installements of the payment
     */
    public PaymentDTO(String code, int numberInstallments, String nameCommerce, double price, double iva, boolean status, Date date, User user, List<Installment> installments) {
        this.code = code;
        this.numberInstallments = numberInstallments;
        this.nameCommerce = nameCommerce;
        this.price = price;
        this.iva = iva;
        this.status = status;
        this.date = date;
        this.user = user;
        this.installments = installments;
    }


    /*
    Getters & Setters
     */

    public int getNumberInstallments() {
        return numberInstallments;
    }

    public void setNumberInstallments(int numberInstallments) {
        this.numberInstallments = numberInstallments;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameCommerce() {
        return nameCommerce;
    }

    public void setNameCommerce(String nameCommerce) {
        this.nameCommerce = nameCommerce;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }
}
