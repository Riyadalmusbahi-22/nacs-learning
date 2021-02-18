package at.nacs.fengshuiapi.communication.endpoint;

import at.nacs.fengshuiapi.logic.Signs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignEndpoint {

    private final Signs signs;

    @GetMapping("/{birthday}")
    String sign(@PathVariable LocalDate birthday) {
        return signs.getSign(birthday);
    }

}
