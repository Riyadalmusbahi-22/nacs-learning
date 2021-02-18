package pairprogramming.controller;

import lombok.experimental.UtilityClass;
import pairprogramming.model.Participant;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class ParticipantReader {

    public List<Participant> asList(String filePath) {
        return FileReader.lines(filePath)
                .map(toParticipant())
                .collect(toList());
    }

    private Function<String, Participant> toParticipant() {
        return line -> Participant.builder()
                .name(line)
                .build();
    }

}
