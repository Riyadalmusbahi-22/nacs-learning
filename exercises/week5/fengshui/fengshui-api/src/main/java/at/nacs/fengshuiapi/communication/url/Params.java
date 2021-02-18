package at.nacs.fengshuiapi.communication.url;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Map;

@UtilityClass
public class Params {

    public Map<String, ?> from(LocalDate birthday) {
        return Map.of(
                "year", birthday.getYear(),
                "month", birthday.getMonthValue(),
                "day", birthday.getDayOfMonth()
        );
    }

    public Map<String, ?> from(LocalDate birthday1, LocalDate birthday2) {
        return Map.of(
                "year", birthday1.getYear(),
                "month", birthday1.getMonthValue(),
                "day", birthday1.getDayOfMonth(),
                "year2", birthday2.getYear(),
                "month2", birthday2.getMonthValue(),
                "day2", birthday2.getDayOfMonth()
        );
    }

    public Map<String, ?> from(String sign1, String sign2) {
        return Map.of(
                "sign", sign1,
                "sign2", sign2
        );
    }
}
