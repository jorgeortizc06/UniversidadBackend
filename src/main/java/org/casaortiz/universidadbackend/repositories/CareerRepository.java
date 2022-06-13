package org.casaortiz.universidadbackend.repositories;

import org.casaortiz.universidadbackend.model.entities.Career;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository = CRUD of spring
 * Spring => CrudRepository, PagingAndSortingRepository, etc
 */
public interface CareerRepository extends CrudRepository<Career, Integer> {
    //@Query("select c from Career c where c.name like %?1%")
    Iterable<Career> findCareersByNameContains(String name);
    //@Query("select c from Career c where upper(c.name) like upper(%?1%)")
    Iterable<Career> findCareersByNameIgnoreCase(String name);
    //@Query("select c from Career c where c.numberYears > ?1")
    Iterable<Career> findCareersByNumberYearsAfter(Integer numberYears);
}
