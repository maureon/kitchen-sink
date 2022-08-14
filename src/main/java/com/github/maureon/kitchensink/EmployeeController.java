package com.github.maureon.kitchensink;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeRepository personRepository;
	
	 // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/persons")
	  List<Employee> all() {
	    return personRepository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/persons")
	  Employee newPerson(@RequestBody Employee newPerson) {
	    return personRepository.save(newPerson);
	  }

	  // Single item	  
	  @GetMapping("/persons/{id}")
	  Employee one(@PathVariable String id) {
	    
	    return personRepository.findById(id)
	      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource"));
	  }

	  @PutMapping("/persons/{id}")
	  Employee replacePerson(@RequestBody Employee newPerson, @PathVariable String id) {
	    Employee existingPerson = personRepository
	    		.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource"));
	    existingPerson.setFirstname(newPerson.getFirstname());
	    existingPerson.setFirstname(newPerson.getLastname());
	    return personRepository.save(existingPerson);	     
	  }

	  @DeleteMapping("/persons/{id}")
	  void deletePerson(@PathVariable String id) {
		  personRepository.deleteById(id);
	  }
		
}
