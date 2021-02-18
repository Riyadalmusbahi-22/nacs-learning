package at.nacs.todosui.communication.endpoint;

import at.nacs.todosui.communication.dto.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class TodosClient {

  private final RestTemplate restTemplate;

  @Value("${todos.endpoint.todos}")
  private String todosUrl;

  @Value("${todos.endpoint.done}")
  private String doneUrl;

  public List<ToDo> findAll() {
    ToDo[] toDos = restTemplate.getForObject(todosUrl, ToDo[].class);
    return Stream.of(toDos)
                 .collect(toList());
  }

  public void save(ToDo toDo) {
    restTemplate.postForObject(todosUrl, toDo, Void.class);
  }

  public void markAsDone(String id) {
    Map<String, String> uriVariables = Map.of("id", id);
    restTemplate.put(doneUrl, id, uriVariables);
  }

}
