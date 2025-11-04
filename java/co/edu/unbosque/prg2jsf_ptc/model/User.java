package co.edu.unbosque.prg2jsf_ptc.model;

import jakarta.persistence.*;

import java.util.List;

@Table(name="users")
@Entity
@NamedQueries(@NamedQuery(name="User.findAll", query = "SELECT e FROM User e"))
/**
 * Clase del objeto user, con sus atributos
 */
public class User {

    @Id
    @Column
    private String identification;
    @Column
    private String name;
    @Column
    private boolean firstPurchase;
    @Column
    private long numberCard;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Payment> payments;

    /**
     * Empty Constructor
     */
    public User() {
    }

    /**
     * Constuctor with local parameter
     * @param identification long, the id of the person
     * @param name String, Name of the persona
     * @param firstPurchase, Boolean, use to identify the person
     * @param numberCard, Long, number of the card that the person use
     * @param payments, List, with all the payments of the person
     */
    public User(String identification, String name, boolean firstPurchase, long numberCard, List<Payment> payments) {
        this.identification = identification;
        this.name = name;
        this.firstPurchase = firstPurchase;
        this.numberCard = numberCard;
        this.payments = payments;
    }

    /*
    Getters & Setters
     */

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFirstPurchase() {
        return firstPurchase;
    }

    public void setFirstPurchase(boolean firstPurchase) {
        this.firstPurchase = firstPurchase;
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
