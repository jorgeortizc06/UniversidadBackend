package org.casaortiz.universidadbackend.repositories;

import org.casaortiz.universidadbackend.model.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositoryStudents") //define el bean con ese nombre
public interface StudentRepository extends PersonRepository{
    @Query("Select s from Student s where s.career.name = ?1")
    Iterable<Person> findStudentByCareerName(String nameCarrer);
}
