package at.nacs.phonebook.communication;

import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.persistence.ContactRepository;
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
class ContactsEndpointTest {

    final String url = "/contacts";
    
    @Autowired
    TestRestTemplate restTemplate;

    @SpyBean
    ContactManager manager;

    @MockBean
    ContactRepository repository;

    @Autowired
    List<Contact> contacts;

    @Test
    void get() {
        restTemplate.getForObject(url, Contact[].class);

        verify(manager).findAll();
    }

    @Test
    void post() {
        Contact contact = contacts.get(0);
        restTemplate.postForObject(url, contact, Contact.class);

        verify(manager).save(contact);
    }

    @Test
    void getByAddress() {
        String address = "some-address";
        String getByAddressURL = url + "/address/" + address;

        restTemplate.getForObject(getByAddressURL, Contact[].class);

        verify(manager).findBy(address);
    }
}