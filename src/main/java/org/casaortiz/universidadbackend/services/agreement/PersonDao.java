package org.casaortiz.universidadbackend.services.agreement;

import org.casaortiz.universidadbackend.model.entities.Person;

import java.util.Optional;

public interface PersonDao extends GenericDao<Person>{
    Optional<Person> searchByFirstLastName(String firstname, String lastName);
    Optional<Person> searchByDni(String dni);
    Iterable<Person> searchPersonByLastName(String lastName);
}
