package at.nacs.phonebook.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
    List<Contact> findByAddressNameLike(String addressName);
    
}
