package at.nacs.basketball.ui;

import at.nacs.basketball.domain.Team;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Component
public class Host {

    public void introduce(Queue<Team> teams) {
        System.out.println("-------------------------------------");
        System.out.println("Welcome to the street basketball tournament!");
        System.out.println("These are the teams who signed up:");
        teams.stream()
                .map(e -> "Team: " + e.getName() + " | Players: " + getPlayers(e))
                .forEach(System.out::println);
        System.out.println("-------------------------------------");
    }

    private String getPlayers(Team e) {
        return e.getPlayers().stream()
                .collect(joining(", "));
    }

    public void announce(Team winner) {
        System.out.println("The tournament's winning team is " + winner.getName() + " !!");
    }

    public void announce(Team team1, Team team2) {
        System.out.println(team1.getName() + " plays vs " + team2.getName());
    }

    public void announceMatch(Team winner) {
        System.out.println("And " + winner.getName() + " wins this match!");
    }
}
