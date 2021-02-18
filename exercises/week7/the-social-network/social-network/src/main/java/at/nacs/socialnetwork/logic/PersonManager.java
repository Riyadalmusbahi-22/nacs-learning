package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.persistence.Person;
import at.nacs.socialnetwork.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public List<Person> findWithFriends() {
        return repository.findByFriendsNotEmpty();
    }

    public List<Person> findWithoutFriends() {
        return repository.findByFriendsEmpty();
    }

    public void friend(Long id1, Long id2) {
        BiConsumer<Person, Person> friend = (person1, person2) -> {
            person1.getFriends().add(person2);
            person2.getFriends().add(person1);
        };
        operate(id1, id2, friend);
    }

    public void unfriend(Long id1, Long id2) {
        BiConsumer<Person, Person> unfriend = (person1, person2) -> {
            person1.getFriends().remove(person2);
            person2.getFriends().remove(person1);
        };
        operate(id1, id2, unfriend);
    }

    private void operate(Long id1, Long id2, BiConsumer<Person, Person> operation) {
        Optional<Person> byId1 = repository.findById(id1);
        Optional<Person> byId2 = repository.findById(id2);
        if (byId1.isEmpty() || byId2.isEmpty()) {
            return;
        }
        Person person1 = byId1.get();
        Person person2 = byId2.get();

        operation.accept(person1, person2);

        repository.save(person1);
        repository.save(person2);
    }

}
