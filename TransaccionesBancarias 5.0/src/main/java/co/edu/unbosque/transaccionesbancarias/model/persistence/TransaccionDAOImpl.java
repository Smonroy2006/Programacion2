package co.edu.unbosque.transaccionesbancarias.model.persistence;

import co.edu.unbosque.transaccionesbancarias.model.Transaccion;
import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * DAO del objeto Transaccion, con todos los metodos CRUD
 */
@ApplicationScoped
@PersistenceContext(unitName = "transaccionPU")
public class TransaccionDAOImpl implements IDAOTransaccion<Transaccion, String> {

    //Lista de objetos, transaccion
    private EntityManager em;

    /**
     * Metodo para mostrar todas las transacciones
     * @return la lista de transacciones
     */
    @Override
    public List<Transaccion> consultar() {
        return em.createNamedQuery("Transaccion.findAll", Transaccion.class).getResultList();
    }

    /**
     * Metodo para guardar un objeto dentro de la lista
     * @param objetoGuardar, objeto para poder guardar
     * @throws IDDuplicate lanza la excepcion de que si un ID ya existe dentro de la base de datos
     */
    @Override
    public void save(Transaccion objetoGuardar) throws IDDuplicate {

            if(em.contains(objetoGuardar)){
                throw new IDDuplicate("El ID no puede ser el mismo");
            }


        em.persist(objetoGuardar);

    }

    /**
     * Metodo para eliminar un objeto de la lista
     * @param id id para encontrar el objeto dentro de la lista
     */
    @Override
    public void delete(String id) {

        em.remove(em.find(Transaccion.class, id));

    }

    /**
     * Metodo para actualizar un objeto
     * @param objetoActualziar objeto que sera para reemplazar el objeto
     */
    @Override
    public void update(Transaccion objetoActualziar) {

        if(objetoActualziar != null){
            em.persist(objetoActualziar);
        }

    }

    /**
     * Metodo para encontrar un objeto dentro de la lista
     * @param id id para encontrar el objeto dentro de la lista
     * @return retorna el objeto que encontro de la lista
     */
    @Override
    public Transaccion find(String id) {
        return em.find(Transaccion.class, id);
    }
}
