package at.nacs.dutchman;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DeadMansChestEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Value("${deadmanschest.item}")
    String item;

    String url = "/deadmanschest";

    @Test
    void get() {
        DeadMansChest deadMansChest = restTemplate.getForObject(url, DeadMansChest.class);

        assertThat(deadMansChest).isNotNull();
        assertThat(deadMansChest.getItem()).isEqualTo(item);
    }
}