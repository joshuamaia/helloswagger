package joshua.maia.helloswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import joshua.maia.helloswagger.domain.Person;
import joshua.maia.helloswagger.repository.PersonRepository;

@SpringBootApplication
public class HelloswaggerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HelloswaggerApplication.class, args);

		PersonRepository personRepository = context.getBean(PersonRepository.class);

		if (!personRepository.existsById(1)) {
			Person person = new Person();
			person.setId(1);
			person.setName("Pessoa 1");
			person.setAge(34);

			personRepository.save(person);
		}

		if (!personRepository.existsById(2)) {
			Person person = new Person();
			person.setId(2);
			person.setName("Pessoa 2");
			person.setAge(27);

			personRepository.save(person);
		}

		if (!personRepository.existsById(3)) {
			Person person = new Person();
			person.setId(3);
			person.setName("Pessoa 3");
			person.setAge(56);

			personRepository.save(person);
		}
	}

}
