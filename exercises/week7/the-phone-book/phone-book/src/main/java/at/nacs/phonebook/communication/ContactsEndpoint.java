package at.nacs.phonebook.communication;

import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactsEndpoint {

    private final ContactManager manager;

    @GetMapping
    List<Contact> get() {
        return manager.findAll();
    }

    @PostMapping
    Contact post(@RequestBody Contact contact) {
        return manager.save(contact);
    }

    @GetMapping("/address/{address}")
    List<Contact> get(@PathVariable String address) {
        return manager.findBy(address);
    }

}
