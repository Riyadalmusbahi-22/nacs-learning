package at.nacs.ex10creditcards.logic.util;

import at.nacs.ex10creditcards.domain.IssuerInfo;
import at.nacs.ex10creditcards.logic.issuer.Issuer;
import at.nacs.ex10creditcards.logic.rule.DoesNotStartWith;
import at.nacs.ex10creditcards.logic.rule.Length;
import at.nacs.ex10creditcards.logic.rule.Rule;
import at.nacs.ex10creditcards.logic.rule.StartsWith;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class Issuers {

    public Issuer from(IssuerInfo info) {
        return new Issuer(info.getName(), getRules(info));
    }

    private static Set<Rule> getRules(IssuerInfo info) {
        Set<Rule> rules = new HashSet<>();

        Set<String> beginnings = info.getStartsWith();
        if (beginnings != null && !beginnings.isEmpty()) {
            rules.add(new StartsWith(beginnings));
        }

        Set<String> exclusions = info.getDoesNotStartWith();
        if (exclusions != null && !exclusions.isEmpty()) {
            rules.add(new DoesNotStartWith(exclusions));
        }

        Set<Integer> lengths = info.getLengths();
        if (lengths != null && !lengths.isEmpty()) {
            rules.add(new Length(lengths));
        }
        return rules;
    }

//    private static Set<Rule> getRules(IssuerInfo info) {
//        Set<String> beginnings = info.getStartsWith();
//        Set<String> exclusions = info.getDoesNotStartWith();
//        Set<Integer> lengths = info.getLengths();
//        return Stream.of(
//                addSafely(beginnings, () -> new StartsWith(beginnings)),
//                addSafely(exclusions, () -> new DoesNotStartWith(exclusions)),
//                addSafely(lengths, () -> new Length(lengths))
//        )
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .collect(toSet());
//    }
//
//    private static Optional<Rule> addSafely(Collection<?> elements, Supplier<Rule> rule) {
//        if (elements == null || elements.isEmpty()) {
//            return Optional.empty();
//        }
//        return Optional.of(rule.get());
//    }

}
