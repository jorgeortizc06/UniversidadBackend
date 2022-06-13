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
public class StudentDaoImpl extends PersonDaoImpl implements StudentDao {

    @Autowired
    public StudentDaoImpl(@Qualifier("repositoryStudents") PersonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Person> searchStudentByCareerName(String nameCarrer) {
        return ((StudentRepository) repository).searchStudentByCareerName(nameCarrer);
    }
}
