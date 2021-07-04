package com.example.Speedrun.REST.API.repository;

import com.example.Speedrun.REST.API.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Long getIdByName(String oldName);

    void updateNameById(Long id);
}
