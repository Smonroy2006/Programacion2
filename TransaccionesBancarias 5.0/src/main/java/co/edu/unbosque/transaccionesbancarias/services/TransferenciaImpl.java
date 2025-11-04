package co.edu.unbosque.transaccionesbancarias.services;

import co.edu.unbosque.transaccionesbancarias.model.DataMapper;
import co.edu.unbosque.transaccionesbancarias.model.Transaccion;
import co.edu.unbosque.transaccionesbancarias.model.TransaccionDTO;
import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;
import co.edu.unbosque.transaccionesbancarias.model.persistence.IDAOTransaccion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

/**
 * Servicio con los servicios disponibles para el objeto Transaccion
 */
@Stateless
public class TransferenciaImpl implements ITransferencia<TransaccionDTO,String> {

    ModelMapper modelMapper;

    @Inject
    private IDAOTransaccion<Transaccion, String> DAO;

    /**
     * Constructor vacio
     */
    public TransferenciaImpl() {
        modelMapper = new ModelMapper();
    }

    /**
     * Servicio para mostrar todos los objetos guardados
     * @return retorna todos los objetos guardados
     */
    @Override
    public List<TransaccionDTO> getTransacciones() {
        List<Transaccion> transaccionList = DAO.consultar();
        return modelMapper.map(transaccionList, new TypeToken<List<TransaccionDTO>>() {}.getType());
    }

    /**
     * Servicio para guarda un objeto
     * @param objetoGuardar Objeto que se va a guardar
     * @throws IDDuplicate lanza la excepcion por si hay un ID duplicado
     */
    @Override
    public void registrarTransaccion(TransaccionDTO objetoGuardar) throws IDDuplicate {

        DAO.save(modelMapper.map(objetoGuardar, Transaccion.class));

    }

    /**
     * Servicio para actualizar/reemplazar un objeto guardado
     * @param objetoGuardar objeto que va a ser alamacenado
     */
    @Override
    public void actualizarTransaccion(TransaccionDTO objetoGuardar) {
        DAO.update(modelMapper.map(objetoGuardar, Transaccion.class));
    }

    /**
     * Servicio para eliminar un objeto guardado
     * @param id id para encontrar el objeto a eliminar
     */
    @Override
    public void eliminarTransaccion(String id) {
        DAO.delete(id);
    }


}
