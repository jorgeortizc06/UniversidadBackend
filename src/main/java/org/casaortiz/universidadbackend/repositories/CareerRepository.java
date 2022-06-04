package org.casaortiz.universidadbackend.repositories;

import org.casaortiz.universidadbackend.model.entities.Career;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository = CRUD of spring
 * Spring => CrudRepository, PagingAndSortingRepository, etc
 */
public interface CareerRepository extends CrudRepository<Career, Integer> {
}
