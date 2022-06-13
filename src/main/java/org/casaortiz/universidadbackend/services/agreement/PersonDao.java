package org.casaortiz.universidadbackend.services.agreement;

import org.casaortiz.universidadbackend.model.entities.Person;

import java.util.Optional;

public interface PersonDao extends GenericDao<Person>{
    Optional<Person> findByFirstLastName(String firstname, String lastName);
    Optional<Person> findByDni(String dni);
    Iterable<Person> findPersonByLastName(String lastName);
}
