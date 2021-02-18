package at.nacs.helloworld;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    public String getMessage() {
        return "Hello World";
    }

}
