package org.casaortiz.universidadbackend.services.implementations;

import org.casaortiz.universidadbackend.model.entities.Person;
import org.casaortiz.universidadbackend.repositories.PersonRepository;
import org.casaortiz.universidadbackend.services.agreement.PersonDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonDaoImpl extends GenericDaoImpl<Person, PersonRepository> implements PersonDao {

    public PersonDaoImpl(PersonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findByFirstLastName(String firstname, String lastName) {
        return repository.findByFirstLastName(firstname, lastName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findByDni(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> findPersonByLastName(String lastName) {
        return repository.findPersonByLastName(lastName);
    }
}
