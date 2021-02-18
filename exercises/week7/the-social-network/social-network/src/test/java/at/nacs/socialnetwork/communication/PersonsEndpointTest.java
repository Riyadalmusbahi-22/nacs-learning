package at.nacs.socialnetwork.communication;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persistence.Person;
import at.nacs.socialnetwork.persistence.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PersonsEndpointTest {

    final String url = "/persons";

    @Autowired
    TestRestTemplate restTemplate;
    @SpyBean
    PersonManager manager;
    @MockBean
    PersonRepository repository;
    @Autowired
    List<Person> persons;

    @Test
    void get() {
        restTemplate.getForObject(url, Person[].class);

        verify(manager).findAll();
    }

    @Test
    void getWithFriends() {
        String withURL = url + "/friends/with";

        restTemplate.getForObject(withURL, Person[].class);

        verify(manager).findWithFriends();
    }

    @Test
    void getWithoutFriends() {
        String withoutURL = url + "/friends/without";

        restTemplate.getForObject(withoutURL, Person[].class);

        verify(manager).findWithoutFriends();
    }

    @Test
    void post() {
        Person person = persons.get(0);

        restTemplate.postForObject(url, person, Person[].class);

        verify(manager).save(person);
    }

    @Test
    void friend() {
        Person person1 = persons.get(0);
        person1.setId(1L);
        Person person2 = persons.get(1);
        person2.setId(2L);
        String friendURL = url + "/" + person1.getId() + "/friend/" + person2.getId();

        restTemplate.put(friendURL, Person[].class);

        verify(manager).friend(person1.getId(), person2.getId());
    }

    @Test
    void unfriend() {
        Person person1 = persons.get(0);
        person1.setId(1L);
        Person person2 = persons.get(1);
        person2.setId(2L);
        String unfriendURL = url + "/" + person1.getId() + "/unfriend/" + person2.getId();

        restTemplate.put(unfriendURL, Person[].class);

        verify(manager).unfriend(person1.getId(), person2.getId());
    }
}