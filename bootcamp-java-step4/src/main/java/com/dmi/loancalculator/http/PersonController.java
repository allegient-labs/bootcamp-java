package com.dmi.loancalculator.http;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dmi.loancalculator.data.PersonRepository;
import com.dmi.loancalculator.domain.Person;

@RestController
@RequestMapping("/person")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
        Optional<Person> op = personRepository.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
        if (op.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        
        person = personRepository.save(person);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/person/find/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Person> find(@PathVariable("id") Long id) {
        return personRepository.findById(id)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/findAll")
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") Long id, @RequestBody Person person) {
        return personRepository.findById(id)
                .map(p -> {
                    p.setLastName(person.getFirstName());
                    p.setLastName(person.getLastName());
                    personRepository.save(p);
                    return new ResponseEntity<>(p, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return personRepository.findById(id)
                .map(p -> {
                    personRepository.delete(p);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
