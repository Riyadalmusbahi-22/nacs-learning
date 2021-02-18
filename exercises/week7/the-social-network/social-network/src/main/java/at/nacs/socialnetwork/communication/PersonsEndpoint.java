package at.nacs.socialnetwork.communication;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persistence.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonsEndpoint {

    private final PersonManager manager;

    @GetMapping
    List<Person> get() {
        return manager.findAll();
    }

    @GetMapping("/friends/with")
    List<Person> getWithFriends() {
        return manager.findWithFriends();
    }

    @GetMapping("/friends/without")
    List<Person> getWithoutFriends() {
        return manager.findWithoutFriends();
    }

    @PostMapping
    Person post(@RequestBody Person person) {
        return manager.save(person);
    }

    @PutMapping("/{id1}/friend/{id2}")
    void friend(@PathVariable Long id1, @PathVariable Long id2) {
        manager.friend(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void unfriend(@PathVariable Long id1, @PathVariable Long id2) {
        manager.unfriend(id1, id2);
    }

}
