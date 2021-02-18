package at.nacs.magic8ball.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MessagesProvider {

  private final List<String> messages;

  private Random random = new Random();

  public String getOneRandom() {
    int index = random.nextInt(messages.size());
    return messages.get(index);
  }

}
