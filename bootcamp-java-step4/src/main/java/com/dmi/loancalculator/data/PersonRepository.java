package com.dmi.loancalculator.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dmi.loancalculator.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);
    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
