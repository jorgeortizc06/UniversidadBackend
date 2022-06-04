package org.casaortiz.universidadbackend.services.implementations;

import org.casaortiz.universidadbackend.model.entities.Person;
import org.casaortiz.universidadbackend.repositories.PersonRepository;
import org.casaortiz.universidadbackend.repositories.StudentRepository;
import org.casaortiz.universidadbackend.services.agreement.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service //lo hago bean
public class StudentDaoImpl implements StudentDao {
    @Autowired
    @Qualifier("repositoryStudents") //Le llamos a un bean que hemos asignado con ese nombre
    private PersonRepository personRepository; //PersonRepository no es un bean

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    @Transactional
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }
}
