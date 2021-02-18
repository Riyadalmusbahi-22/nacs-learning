package at.nacs.todos.endpoint;

import at.nacs.todos.logic.ToDoManager;
import at.nacs.todos.persistence.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDosEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @SpyBean
    ToDoManager toDoManager;

    String url = "/todos";

    ToDo todo;

    @BeforeEach
    void before() {
        toDoManager.deleteAll();
        todo = ToDo.builder().title("Test").build();
    }

    @Test
    void get() {
        ToDo[] response = restTemplate.getForObject(url, ToDo[].class);

        assertThat(response).isEmpty();
        verify(toDoManager).findAll();
    }

    @Test
    void getOne() {
        toDoManager.save(todo);
        String id = todo.getId();
        String todoUrl = this.url + "/" + id;

        ToDo actual = restTemplate.getForObject(todoUrl, ToDo.class);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotBlank();
        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(todo.getTitle());
        assertThat(actual.isDone()).isFalse();
        verify(toDoManager).findOne(id);
    }

    @Test
    void post() {
        ToDo saved = restTemplate.postForObject(url, todo, ToDo.class);
        String id = saved.getId();

        Optional<ToDo> oToDo = toDoManager.findOne(id);
        assertThat(oToDo.isPresent()).isTrue();
        ToDo actual = oToDo.get();

        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(saved.getTitle());
        assertThat(actual.isDone()).isFalse();
        verify(toDoManager).save(actual);
    }

    @Test
    void put() {
        toDoManager.save(todo);
        String id = todo.getId();
        String todoUrl = this.url + "/" + id + "/done";

        assertThat(todo.isDone()).isFalse();

        restTemplate.put(todoUrl, null);

        Optional<ToDo> oToDo = toDoManager.findOne(id);
        assertThat(oToDo.isPresent()).isTrue();
        ToDo actual = oToDo.get();

        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(todo.getTitle());
        assertThat(actual.isDone()).isTrue();
        verify(toDoManager).save(todo);
    }

    @Test
    void delete() {
        toDoManager.save(todo);
        String id = todo.getId();
        String todoUrl = this.url + "/" + id;

        restTemplate.delete(todoUrl);

        Optional<ToDo> oToDo = toDoManager.findOne(id);
        assertThat(oToDo.isPresent()).isFalse();
    }
}