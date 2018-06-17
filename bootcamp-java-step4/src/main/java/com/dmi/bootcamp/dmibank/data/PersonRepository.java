package com.dmi.bootcamp.dmibank.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmi.bootcamp.dmibank.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
