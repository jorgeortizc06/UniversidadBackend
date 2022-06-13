package org.casaortiz.universidadbackend.repositories;

import org.casaortiz.universidadbackend.model.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean //no me genera el bean del padre, solo me interesa el bean de las clases hijas
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("select p from Person p where p.firstName = ?1 and p.lastName = ?2")
    Optional<Person> searchByFirstLastName(String firstname, String lastName);
    @Query("select p from Person p where p.dni = ?1")
    Optional<Person> searchByDni(String dni);
    @Query("select p from Person p where p.lastName like %?1%")
    Iterable<Person> searchPersonByLastName(String lastName);
}
