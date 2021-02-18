package at.nacs.todosui.communication.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class ToDo {

  private String id;

  @NotEmpty
  private String title;

  private boolean done;

}
