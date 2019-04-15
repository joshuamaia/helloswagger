package joshua.maia.helloswagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import joshua.maia.helloswagger.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
