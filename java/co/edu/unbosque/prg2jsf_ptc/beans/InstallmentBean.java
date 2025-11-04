package co.edu.unbosque.prg2jsf_ptc.beans;

import co.edu.unbosque.prg2jsf_ptc.model.InstallmentDTO;
import co.edu.unbosque.prg2jsf_ptc.model.Payment;
import co.edu.unbosque.prg2jsf_ptc.model.PaymentDTO;
import co.edu.unbosque.prg2jsf_ptc.model.UserDTO;
import co.edu.unbosque.prg2jsf_ptc.services.IInstallment;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("installmentBean")
@RequestScoped
public class InstallmentBean {

    private InstallmentDTO installment;
    private PaymentDTO payment;
    private UserDTO user;
    private String ID;
    private String idObject;
    private List<InstallmentDTO> installments;

    @Inject
    private IInstallment<InstallmentDTO, String> service;

    @PostConstruct
    public void init(){
        installment = new InstallmentDTO();
        ID = "";
        idObject = "";
        installments = service.getAll();
        payment = new PaymentDTO();
        user = new UserDTO();
    }

    public String save(){
        service.save(installment);
        return "index.xthml";
    }

    public String delete(){
        service.delete(ID);
        return "index.xhtml";
    }

    public String update(){
        service.delete(ID);
        return "index.xhtml";
    }

    /*
     Getters & Setters
     */

    public InstallmentDTO getInstallment() {
        return installment;
    }

    public void setInstallment(InstallmentDTO installment) {
        this.installment = installment;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIdObject() {
        return idObject;
    }

    public void setIdObject(String idObject) {
        this.idObject = idObject;
    }

    public List<InstallmentDTO> getInstallments() {
        return installments;
    }

    public void setInstallments(List<InstallmentDTO> installments) {
        this.installments = installments;
    }

    public IInstallment<InstallmentDTO, String> getService() {
        return service;
    }

    public void setService(IInstallment<InstallmentDTO, String> service) {
        this.service = service;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
