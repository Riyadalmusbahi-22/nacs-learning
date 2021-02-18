package at.nacs.propertiespart1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FacilitiesTest {

    @Autowired
    Facilities facilities;

    @Test
    void getSauna() {
        Sauna sauna = facilities.getSauna();
        assertNotNull(sauna);
        assertEquals(Integer.valueOf(8), sauna.getAvailableSeats());
        assertEquals(Integer.valueOf(80), sauna.getTemperature());
    }
}