package at.nacs.phonebook.logic;

import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.persistence.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactManager {

    private final ContactRepository repository;

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> findBy(String address) {
        String addressName = "%" + address + "%";
        return repository.findByAddressNameLike(addressName);
    }
}
