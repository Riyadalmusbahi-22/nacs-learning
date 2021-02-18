package at.nacs.magic8ball.view;

import at.nacs.magic8ball.logic.MessagesProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

  private final MessagesProvider messagesProvider;

  @ModelAttribute("message")
  String message() {
    return messagesProvider.getOneRandom();
  }

  @GetMapping
  String page() {
    return "home";
  }

}
