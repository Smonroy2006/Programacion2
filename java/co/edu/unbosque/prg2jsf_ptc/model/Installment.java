package co.edu.unbosque.prg2jsf_ptc.model;

import jakarta.persistence.*;

@Table(name="installment")
@Entity
@NamedQueries(@NamedQuery(name="Installment.findAll", query="SELECT e FROM Installment e"))
public class Installment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int numberInstallment;
    @Column
    private double value;
    @Column
    private double interest;
    @Column
    private double capital;

    @ManyToOne
    @JoinColumn(name = "payment")
    private Payment payment;

    /**
     * Empty Constructor
     */
    public Installment() {
    }


    /**
     *Contructor with local parameters
     * @param id, id to identify the installmert
     * @param value, the value of one specfic installemt
     * @param interest, the number that adds to the value
     * @param capital, the value that lows the total value
     * @param payment, the payment that the installment are from
     * @param numberInstallment, the number of the installment
     */
    public Installment(int id, int numberInstallment, double value, double interest, double capital, Payment payment) {
        this.id = id;
        this.numberInstallment = numberInstallment;
        this.value = value;
        this.interest = interest;
        this.capital = capital;
        this.payment = payment;
    }

    /*
    Getters & Setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberInstallment() {
        return numberInstallment;
    }

    public void setNumberInstallment(int numberInstallment) {
        this.numberInstallment = numberInstallment;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
