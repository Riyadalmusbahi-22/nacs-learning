package at.nacs.twitterboard.persistence;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Tweet {

    private String id;
    private String user;
    private String text;
    private int likes;
    private List<String> comments = new ArrayList<>();
    private LocalDateTime timestamp;

}
