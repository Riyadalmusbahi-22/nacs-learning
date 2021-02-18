package at.nacs.todos.logic;

import at.nacs.todos.persistence.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager toDoManager;

    ToDo todo;

    @BeforeEach
    void before() {
        toDoManager.deleteAll();
        todo = ToDo.builder().title("Test").build();
    }

    @Test
    void findAll() {
        List<ToDo> todos = toDoManager.findAll();

        assertThat(todos).isEmpty();
    }

    @Test
    void findOne() {
        toDoManager.save(todo);

        Optional<ToDo> actual = toDoManager.findOne(todo.getId());
        actual.ifPresent(e -> assertThat(e).isEqualTo(todo));
    }

    @Test
    void save() {
        toDoManager.save(todo);

        Optional<ToDo> actual = toDoManager.findOne(todo.getId());
        actual.ifPresent(e -> assertThat(e).isEqualTo(todo));
    }

    @Test
    void markAsDone() {
        toDoManager.save(todo);
        String id = todo.getId();

        toDoManager.markAsDone(id);

        Optional<ToDo> actual = toDoManager.findOne(id);
        actual.ifPresent(e -> assertThat(e.isDone()).isTrue());
    }

    @Test
    void delete() {
        toDoManager.save(todo);
        String id = todo.getId();
        assertThat(todo.getId()).isNotBlank();
        
        toDoManager.delete(id);

        Optional<ToDo> actual = toDoManager.findOne(id);
        assertThat(actual.isPresent()).isFalse();
    }

    @Test
    void deleteAll() {
    }
}