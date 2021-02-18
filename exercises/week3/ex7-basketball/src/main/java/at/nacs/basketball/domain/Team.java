package at.nacs.basketball.domain;

import lombok.Data;

import java.util.List;

@Data
public class Team {

    private String name;
    private List<String> players;

}
