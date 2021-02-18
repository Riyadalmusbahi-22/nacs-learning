package pairprogramming.view;

import lombok.experimental.UtilityClass;
import pairprogramming.model.Pair;
import pairprogramming.model.Participant;

import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

@UtilityClass
public class Screen {

    public void display(List<Pair> pairs) {
        System.out.println("\n------- PAIRS -------\n");
        pairs.forEach(display());
        System.out.println("\n------- PAIRS -------");
    }

    private Consumer<Pair> display() {
        return pair -> {
            String names = pair.getParticipants().stream()
                    .map(Participant::getName)
                    .collect(joining(", "));
            System.out.println(names);
        };
    }


}
