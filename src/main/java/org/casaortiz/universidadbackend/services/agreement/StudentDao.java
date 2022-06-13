package org.casaortiz.universidadbackend.services.agreement;


import org.casaortiz.universidadbackend.model.entities.Person;

public interface StudentDao extends PersonDao{
    Iterable<Person> findStudentByCareerName(String nameCarrer);
}
