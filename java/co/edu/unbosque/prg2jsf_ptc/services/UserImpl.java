package co.edu.unbosque.prg2jsf_ptc.services;

import co.edu.unbosque.prg2jsf_ptc.model.User;
import co.edu.unbosque.prg2jsf_ptc.model.UserDTO;
import co.edu.unbosque.prg2jsf_ptc.model.persistence.IDAOUser;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

/**
 * Service of the object User
 */
@Stateless
public class UserImpl implements IUser<UserDTO, String>{

    private ModelMapper modelMapper;

    @Inject
    private IDAOUser<User, String> DAO;

    public UserImpl() {
        modelMapper = new ModelMapper();
    }

    /**
     * Method that gets all the objects in the system
     * @return the list of objects
     */
    @Override
    public List<UserDTO> getAll() {

        List<User> users = DAO.getAll();

        return modelMapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
    }

    /**
     * Method that save in the system an object
     * @param object Object to be save
     */
    @Override
    public void save(UserDTO object) {
        DAO.save(modelMapper.map(object, User.class));
    }

    /**
     * Method that delete an object in the system
     * @param ID identificator of the object
     */
    @Override
    public void delete(String ID) {
        DAO.delete(ID);
    }

    /**
     * Method that update or replace an object in the system
     * @param object User to be updated
     */
    @Override
    public void update(UserDTO object) {
        DAO.update(modelMapper.map(object, User.class));
    }
}
