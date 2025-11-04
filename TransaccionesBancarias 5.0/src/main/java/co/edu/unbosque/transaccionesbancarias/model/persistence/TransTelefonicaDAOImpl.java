package co.edu.unbosque.transaccionesbancarias.model.persistence;

import co.edu.unbosque.transaccionesbancarias.model.Transaccion;
import co.edu.unbosque.transaccionesbancarias.model.TransaccionTelefonica;
import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * DAO del objeto Transaccion, con todos los metodos CRUD
 */
@ApplicationScoped
public class TransTelefonicaDAOImpl implements IDAOTransTelefonica<TransaccionTelefonica, String> {

    //Lista de objetos, transaccion
    private EntityManager em;

    /**
     * Metodo para mostrar todas las transacciones
     *
     * @return la lista de transacciones
     */
    @Override
    public List<TransaccionTelefonica> consultar() {
        return em.createNamedQuery("TransTelefonica.findAll").getResultList();
    }

    /**
     * Metodo para guardar un objeto dentro de la lista
     *
     * @param objetoGuardar, objeto para poder guardar
     * @throws IDDuplicate lanza la excepcion de que si un ID ya existe dentro de la base de datos
     */
    @Override
    public void save(TransaccionTelefonica objetoGuardar) throws IDDuplicate {

        if (em.contains(objetoGuardar.getId())) {
            throw new IDDuplicate("El ID no puede ser el mismo");
        }


        em.persist(objetoGuardar);

    }

    /**
     * Metodo para eliminar un objeto de la lista
     *
     * @param id id para encontrar el objeto dentro de la lista
     */
    @Override
    public void delete(String id) {

        em.remove(em.find(TransaccionTelefonica.class, id));

    }

    /**
     * Metodo para actualizar un objeto
     *
     * @param objetoActualziar objeto que sera para reemplazar el objeto
     */
    @Override
    public void update(TransaccionTelefonica objetoActualziar) {

        em.merge(objetoActualziar);

    }

    /**
     * Metodo para encontrar un objeto dentro de la lista
     *
     * @param id id para encontrar el objeto dentro de la lista
     * @return retorna el objeto que encontro de la lista
     */
    @Override
    public TransaccionTelefonica find(String id) {
        return em.find(TransaccionTelefonica.class, id);
    }
}
