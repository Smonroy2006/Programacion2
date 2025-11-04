package co.edu.unbosque.prg2jsf_ptc.beans;

import co.edu.unbosque.prg2jsf_ptc.model.UserDTO;
import co.edu.unbosque.prg2jsf_ptc.services.IUser;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("userBean")
@RequestScoped
public class UserBean {

    private UserDTO user;
    private String ID;
    private List<UserDTO> users;

    @Inject
    private IUser<UserDTO, String> service;

    @PostConstruct
    public void init(){
        user = new UserDTO();
        ID = "";
        users = service.getAll();
    }

    public String save(){
        service.save(user);
        return "index.xhtml";
    }

    public String delete(){
        service.delete(ID);
        return "index.xhtml";
    }

    public String update(){
        service.update(user);
        return "index.xhtml";
    }

    /*
    Getters & Setters
     */

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public IUser<UserDTO, String> getService() {
        return service;
    }

    public void setService(IUser<UserDTO, String> service) {
        this.service = service;
    }
}
