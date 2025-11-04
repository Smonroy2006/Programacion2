package co.edu.unbosque.transaccionesbancarias.model.persistence;

import co.edu.unbosque.transaccionesbancarias.model.Cliente;
import co.edu.unbosque.transaccionesbancarias.model.exception.IDDuplicate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ClienteDAOImpl implements IDAOCliente<Cliente, Integer> {

    @PersistenceContext(unitName="transaccionesPU")
    private EntityManager em;


    @Override
    public List<Cliente> consultar() {
        return em.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
    }

    @Override
    public void save(Cliente objetoGuardar) throws IDDuplicate {
        em.persist(objetoGuardar);
    }

    @Override
    public void delete(Integer id) {


        em.remove(em.getReference(Cliente.class, id));
    }

    @Override
    public void update(Cliente objetoActualziar) {
        em.merge(objetoActualziar);
    }

    @Override
    public Cliente find(Integer id) {
        return em.find(Cliente.class, id);
    }
}
