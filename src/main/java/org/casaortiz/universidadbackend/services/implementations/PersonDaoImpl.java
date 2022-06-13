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
    public Optional<Person> searchByFirstLastName(String firstname, String lastName) {
        return repository.searchByFirstLastName(firstname, lastName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> searchByDni(String dni) {
        return repository.searchByDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> searchPersonByLastName(String lastName) {
        return repository.searchPersonByLastName(lastName);
    }
}
