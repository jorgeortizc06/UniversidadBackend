package org.casaortiz.universidadbackend.repositories;

import org.casaortiz.universidadbackend.model.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean //no me genera el bean del padre, solo me interesa el bean de las clases hijas
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
