package at.nacs.ex7insurancemessages.logic.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Names {

    public String getTitle(String name) {
        return name.split(" ")[0];
    }

}
