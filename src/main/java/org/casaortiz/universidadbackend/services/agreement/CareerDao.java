package org.casaortiz.universidadbackend.services.agreement;

import org.casaortiz.universidadbackend.model.entities.Career;

import java.util.Optional;

/**
 * Interfaces de los metodos a usar en el CRUD
 */
public interface CareerDao {
    //Optional = encapsula el error null pointer exception
    Optional<Career> findById(Integer id);
    Career save(Career career);
    Iterable<Career> findAll();
    void deleteById(Integer id);
}
