package at.nacs.basketball.logic;

import at.nacs.basketball.domain.Team;
import at.nacs.basketball.ui.Host;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class Court {

    private final Host host;
    private Random random = new Random();

    public Team play(Team team1, Team team2) {
        host.announce(team1, team2);
        Team winner = getWinner(team1, team2);
        host.announceMatch(winner);
        return winner;
    }

    private Team getWinner(Team team1, Team team2) {
        boolean isTeam1TheWinner = random.nextBoolean();
        return isTeam1TheWinner ? team1 : team2;
    }
}
