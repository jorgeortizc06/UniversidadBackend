package org.casaortiz.universidadbackend.services.agreement;

import org.casaortiz.universidadbackend.model.entities.Person;

import java.util.Optional;

public interface PersonDao {
    //Optional = encapsula el error null pointer exception
    Optional<Person> findById(Integer id);
    Person save(Person person);
    Iterable<Person> findAll();
    void deleteById(Integer id);
}
