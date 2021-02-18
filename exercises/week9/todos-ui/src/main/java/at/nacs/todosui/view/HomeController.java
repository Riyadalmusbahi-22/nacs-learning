package at.nacs.todosui.view;

import at.nacs.todosui.communication.dto.ToDo;
import at.nacs.todosui.communication.endpoint.TodosClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

  private final TodosClient todosClient;

  @ModelAttribute("toDos")
  List<ToDo> toDos() {
    return todosClient.findAll();
  }

  @ModelAttribute("toDo")
  ToDo toDo() {
    return new ToDo();
  }

  @GetMapping
  String page() {
    return "home";
  }

  @PostMapping
  String save(@Valid ToDo toDo, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    todosClient.save(toDo);
    return "redirect:/";
  }

  @PostMapping("/done")
  String done(@RequestParam String id) {
    todosClient.markAsDone(id);
    return "redirect:/";
  }
}
