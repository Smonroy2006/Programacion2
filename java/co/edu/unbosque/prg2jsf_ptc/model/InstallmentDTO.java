package co.edu.unbosque.prg2jsf_ptc.model;


public class InstallmentDTO {

    private int id;
    private int numberInstallment;
    private double value;
    private double interest;
    private double capital;
    private Payment payment;

    /**
     * Empty Constructor
     */
    public InstallmentDTO() {
    }

    /**
     *Constructor with local parameters
     * @param id String, identification of the object
     * @param value Double, Value of Installment
     * @param interest Double, The interest that takes de installment
     * @param capital Double, the capital of the installment
     * @param payment Payment, The payment that is the installment
     * @param numberInstallment, the number of the installment
     */
    public InstallmentDTO(int id, int numberInstallment, double value, double interest, double capital, Payment payment) {
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
