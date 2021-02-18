package at.nacs.todos.endpoint;

import at.nacs.todos.logic.ToDoManager;
import at.nacs.todos.persistence.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDosEndpoint {

    private final ToDoManager toDoManager;

    @GetMapping
    List<ToDo> get() {
        return toDoManager.findAll();
    }

    @GetMapping("/{id}")
    ToDo get(@PathVariable String id) {
        return toDoManager.findOne(id).orElse(null);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo) {
        return toDoManager.save(toDo);
    }

    @PutMapping("/{id}/done")
    ToDo put(@PathVariable String id) {
        return toDoManager.markAsDone(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        toDoManager.delete(id);
    }

}
