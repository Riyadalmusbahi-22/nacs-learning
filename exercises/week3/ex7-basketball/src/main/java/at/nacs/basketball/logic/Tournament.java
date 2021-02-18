package at.nacs.basketball.logic;

import at.nacs.basketball.domain.Team;
import at.nacs.basketball.ui.Host;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
@RequiredArgsConstructor
public class Tournament {

    private final TeamLoader loader;
    private final Host host;
    private final Court court;

    public void play() {
        Queue<Team> teams = loader.getTeams();
        host.introduce(teams);
        Team winner = play(teams);
        host.announce(winner);
    }

    private Team play(Queue<Team> teams) {
        while (teams.size() > 1) {
            playOneMatch(teams);
        }
        return teams.poll();
    }

    private void playOneMatch(Queue<Team> teams) {
        Team team1 = teams.poll();
        Team team2 = teams.poll();
        Team winner = court.play(team1, team2);
        teams.offer(winner);
    }

}
