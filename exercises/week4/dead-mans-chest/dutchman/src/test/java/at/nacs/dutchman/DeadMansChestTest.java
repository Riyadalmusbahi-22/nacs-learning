package at.nacs.dutchman;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DeadMansChestTest {

    @Autowired
    DeadMansChest deadMansChest;

    @Value("${deadmanschest.item}")
    String item;

    @Test
    void testItem() {
        assertThat(deadMansChest).isNotNull();
        assertThat(deadMansChest.getItem()).isEqualTo(item);
    }
}