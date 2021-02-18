package at.nacs.twitterboard.logic;

import at.nacs.twitterboard.persistence.Tweet;
import at.nacs.twitterboard.persistence.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Twitter {

    private final TweetRepository repository;

    public List<Tweet> findAll() {
        return repository.findByOrderByTimestampDesc();
    }

    public List<Tweet> findBy(String user) {
        return repository.findByUserOrderByTimestampDesc(user);
    }

    public Tweet save(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        return repository.save(tweet);
    }

    public void like(String id) {
        Optional<Tweet> byId = repository.findById(id);
        if (byId.isEmpty()) {
            return;
        }
        Tweet tweet = byId.get();
        int likes = tweet.getLikes();
        tweet.setLikes(likes + 1);
        repository.save(tweet);
    }

    public void comment(String id, String comment) {
        Optional<Tweet> byId = repository.findById(id);
        if (byId.isEmpty()) {
            return;
        }
        Tweet tweet = byId.get();
        tweet.getComments().add(comment);
        repository.save(tweet);
    }
}
