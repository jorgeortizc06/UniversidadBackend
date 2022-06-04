package org.casaortiz.universidadbackend.services.implementations;

import org.casaortiz.universidadbackend.services.agreement.GenericDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericDaoImpl <E, R extends CrudRepository<E, Integer>> implements GenericDao<E> {
    
    protected final R repository;

    public GenericDaoImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
