package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.persistence.Person;
import at.nacs.socialnetwork.persistence.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PersonManagerTest {

    @Autowired
    PersonManager manager;

    @Autowired
    PersonRepository repository;

    @Autowired
    List<Person> persons;

    @BeforeEach
    void before() {
        repository.deleteAll();
        repository.saveAll(persons);
    }

    @Test
    void findAll() {
        List<Person> actual = manager.findAll();

        assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void save() {
        Person person = persons.get(0);
        String name = "Somebody";
        person.setName(name);

        Person actual = manager.save(person);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getName()).isEqualTo(name);
        assertThat(repository.count()).isEqualTo(3);
    }

    @Test
    void findWithFriends() {
        List<Person> actual = manager.findWithFriends();

        assertThat(actual.size()).isEqualTo(0);

        List<Person> all = repository.findAll();
        manager.friend(all.get(0).getId(), all.get(1).getId());

        actual = manager.findWithFriends();

        assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void findWithoutFriends() {
        List<Person> actual = manager.findWithoutFriends();

        assertThat(actual.size()).isEqualTo(2);

        List<Person> all = repository.findAll();
        manager.friend(all.get(0).getId(), all.get(1).getId());

        actual = manager.findWithoutFriends();

        assertThat(actual.size()).isEqualTo(0);
    }

    @Test
    void friend() {
        List<Person> all = repository.findAll();
        Person person1 = all.get(0);
        Person person2 = all.get(1);

        assertThat(person1.getFriends()).isEmpty();
        assertThat(person2.getFriends()).isEmpty();

        manager.friend(person1.getId(), person2.getId());

        all = repository.findAll();
        person1 = all.get(0);
        person2 = all.get(1);

        assertThat(person1.getFriends()).isNotEmpty();
        assertThat(person2.getFriends()).isNotEmpty();
        assertThat(person1.getFriends().get(0)).isEqualTo(person2);
        assertThat(person2.getFriends().get(0)).isEqualTo(person1);
    }

    @Test
    void unfriend() {
        List<Person> all = repository.findAll();
        manager.friend(all.get(0).getId(), all.get(1).getId());

        all = repository.findAll();
        Person person1 = all.get(0);
        Person person2 = all.get(1);

        assertThat(person1.getFriends()).isNotEmpty();
        assertThat(person2.getFriends()).isNotEmpty();

        manager.unfriend(person1.getId(), person2.getId());

        all = repository.findAll();
        person1 = all.get(0);
        person2 = all.get(1);

        assertThat(person1.getFriends()).isEmpty();
        assertThat(person2.getFriends()).isEmpty();
    }
}