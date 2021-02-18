package at.nacs.todos.logic;

import at.nacs.todos.persistence.ToDo;
import at.nacs.todos.persistence.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoManager {

    private final ToDoRepository toDoRepository;

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> findOne(String id) {
        return toDoRepository.findById(id);
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public Optional<ToDo> markAsDone(String id) {
        Optional<ToDo> oToDo = toDoRepository.findById(id);
        if (oToDo.isEmpty()) {
            return Optional.empty();
        }
        ToDo toDo = oToDo.get();
        toDo.setDone(true);
        toDoRepository.save(toDo);
        return Optional.of(toDo);
    }

    public void delete(String id) {
        toDoRepository.deleteById(id);
    }

    public void deleteAll() {
        toDoRepository.deleteAll();
    }
}
