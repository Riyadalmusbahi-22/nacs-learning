package at.nacs.basketball.logic;

import at.nacs.basketball.domain.Team;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
@ConfigurationProperties("tournament")
public class TeamLoader {

    @Setter
    @Getter
    private LinkedList<Team> teams;
}
