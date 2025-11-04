package co.edu.unbosque.transaccionesbancarias.services;

import co.edu.unbosque.transaccionesbancarias.model.*;
import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;
import co.edu.unbosque.transaccionesbancarias.model.persistence.IDAOCliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

/**
 * Servicio con los servicio disponibles para el objeto Cliente
 */
@Stateless
public class ClienteImpl implements ICliente<ClienteDTO, Integer> {

    ModelMapper modelMapper;

    @Inject
    private IDAOCliente<Cliente, Integer> DAO;

    /**
     * Constructor vacio
     */
    public ClienteImpl() {
        modelMapper = new ModelMapper();
    }

    /**
     * Servicio para mostrar todos los objetos guardados
     * @return retorna todos los objetos guardados
     */
    @Override
    public List<ClienteDTO> getClientes() {
        List<Cliente> clientes = DAO.consultar();


        return modelMapper.map(clientes, new TypeToken<List<ClienteDTO>>() {}.getType());
    }

    /**
     * Servicio para guarda un objeto
     * @param objetoGuardar Objeto que se va a guardar
     * @throws IDDuplicate lanza la excepcion por si hay un ID duplicado
     */
    @Override
    public void registrarCliente(ClienteDTO objetoGuardar) throws IDDuplicate {

        DAO.save(modelMapper.map(objetoGuardar, Cliente.class));

    }

    /**
     * Servicio para actualizar/reemplazar un objeto guardado
     * @param objetoGuardar objeto que va a ser alamacenado
     */
    @Override
    public void actualizarCliente(ClienteDTO objetoGuardar) {
        DAO.update(modelMapper.map(objetoGuardar, Cliente.class));
    }

    /**
     * Servicio para eliminar un objeto guardado
     * @param id id para encontrar el objeto a eliminar
     */
    @Override
    public void eliminarCliente(Integer id) {
        DAO.delete(id);
    }
}
