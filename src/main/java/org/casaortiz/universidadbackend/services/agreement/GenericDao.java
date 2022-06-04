package org.casaortiz.universidadbackend.services.agreement;

import java.util.Optional;

public interface GenericDao<E> {
    //Optional = encapsula el error null pointer exception
    Optional<E> findById(Integer id);
    E save(E e);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
