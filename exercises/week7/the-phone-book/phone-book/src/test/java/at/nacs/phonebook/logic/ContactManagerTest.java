package at.nacs.phonebook.logic;

import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.persistence.ContactRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ContactManagerTest {

    @Autowired
    ContactManager manager;

    @Autowired
    ContactRepository repository;

    @Autowired
    List<Contact> contacts;

    @BeforeEach
    void before() {
        repository.saveAll(contacts);
    }
    
    @AfterEach
    void after(){
        repository.deleteAll();
    }

    @Test
    void findAll() {
        List<Contact> actual = manager.findAll();

        assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void save() {
        Contact contact = contacts.get(0);
        String name = "Test guy";
        contact.setName(name);

        Contact actual = manager.save(contact);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getName()).isEqualTo(name);
        assertThat(repository.count()).isEqualTo(3);
    }

    @Test
    void findBy() {
        List<Contact> byAddress = manager.findBy("Test");

        assertThat(byAddress.size()).isEqualTo(1);
    }
}