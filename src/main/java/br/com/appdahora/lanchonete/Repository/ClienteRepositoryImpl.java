package br.com.appdahora.lanchonete.Repository;

import br.com.appdahora.lanchonete.Model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Cliente> findAll() {
        return manager.createQuery("from Cliente",
                Cliente.class).getResultList();
    }
    @Override
    public Cliente findById(Long id) {
        return manager.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return manager.merge(cliente);
    }
    @Override
    @Transactional
    public void deleteById(Long id) {
        Cliente cliente = findById(id);
        manager.remove(cliente);
    }
}