package at.nacs.thethievesden;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TreasureController {

  @GetMapping
  String page() {
    return "treasure";
  }

}
