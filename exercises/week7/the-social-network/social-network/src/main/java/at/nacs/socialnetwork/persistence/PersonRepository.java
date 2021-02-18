package at.nacs.socialnetwork.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
    List<Person> findByFriendsNotEmpty();

    List<Person> findByFriendsEmpty();
}
