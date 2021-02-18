package at.nacs.ex10creditcards.domain;

import lombok.Data;

import java.util.Set;

@Data
public class IssuerInfo {

    private String name;
    private Set<String> startsWith;
    private Set<String> doesNotStartWith;
    private Set<Integer> lengths;

}
