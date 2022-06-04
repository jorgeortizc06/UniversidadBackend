package org.casaortiz.universidadbackend.repositories;

import org.springframework.stereotype.Repository;

@Repository("repositoryStudents") //define el bean con ese nombre
public interface StudentRepository extends PersonRepository{
}
