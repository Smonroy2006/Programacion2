package co.edu.unbosque.prg2jsf_ptc.beans;

import co.edu.unbosque.prg2jsf_ptc.model.PaymentDTO;
import co.edu.unbosque.prg2jsf_ptc.model.UserDTO;
import co.edu.unbosque.prg2jsf_ptc.services.IPayment;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named("paymentBean")
@RequestScoped
public class PaymentBean {

    private UserDTO user;
    private PaymentDTO payment;
    private String ID;
    private String idObject;
    private List<PaymentDTO> payments;

    @Inject
    private IPayment<PaymentDTO, String> service;

    @PostConstruct
    public void init(){
        payment=new PaymentDTO();
        ID = "";
        idObject = "";
        payments= service.getAll();
        user = new UserDTO();
    }

    public String save(){
        service.save(payment, user);
        return "index.xthtml";
    }

    public String delete(){
        service.delete(ID);
        return "index.xthtml";
    }

    public String update(){
        service.update(payment);
        return "index.xhtml";
    }

    public void find(){
        service.find(ID);
    }

    /*
    Getters & Setters
     */

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
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

    public List<PaymentDTO> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDTO> payments) {
        this.payments = payments;
    }

    public IPayment<PaymentDTO, String> getService() {
        return service;
    }

    public void setService(IPayment<PaymentDTO, String> service) {
        this.service = service;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
