package joshua.maia.helloswagger.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import joshua.maia.helloswagger.domain.Person;
import joshua.maia.helloswagger.repository.PersonRepository;

@RestController
@RequestMapping("/rest")
public class HelloSwaggerController {

	@Autowired
	private PersonRepository personRepository;

	@ApiOperation(value = "Register a new person.", response = Person.class, notes = "This operation saves a new record with the person information.")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Returns a Person with code 201.", response = Person.class),
			@ApiResponse(code = 500, message = "Returns a Person with code 500.", response = Person.class)

	})
	@RequestMapping(value = "/person", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Person> save(@RequestBody Person person) {

		try {

			this.personRepository.save(person);

			return new ResponseEntity<Person>(person, HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<Person>(person, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Update a person.", response = Person.class, notes = "This operation update a record with the person information.")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Returns a Person with code 200.", response = Person.class),
			@ApiResponse(code = 500, message = "Returns a Person with code 500.", response = Person.class)

	})
	@RequestMapping(value = "/person", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Person> update(@RequestBody Person person) {

		try {

			this.personRepository.save(person);

			return new ResponseEntity<Person>(person, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<Person>(person, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Person> listAll() {

		return this.personRepository.findAll();
	}

	@ApiOperation(value = "Search for a person by id.", response = Person.class, notes = "This operation searches a person's data for the id.")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Returns a Person with code 200.", response = Person.class),
			@ApiResponse(code = 500, message = "Returns a Person with code 500.", response = Person.class)

	})
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Person> search(@PathVariable("id") Integer id) {

		Optional<Person> person = this.personRepository.findById(id);

		try {

			return new ResponseEntity<Person>(person.get(), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<Person>(person.get(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Delete a person by id.", response = Person.class, notes = "This operation delete a person's data for the id.")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Returns a Person with code 200.", response = Person.class),
			@ApiResponse(code = 500, message = "Returns a Person with code 500.", response = Person.class)

	})
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Person> delete(@PathVariable("id") Integer id) {

		Optional<Person> person = this.personRepository.findById(id);

		try {

			personRepository.delete(person.get());

			return new ResponseEntity<Person>(person.get(), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<Person>(person.get(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
