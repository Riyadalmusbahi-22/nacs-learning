package at.nacs.ex6propertiespart2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LibraryTest {

    @Autowired
    Library library;

    @Test
    void getBooks() {
        Map<String, Integer> books = library.getBooks();

        assertEquals(3, books.size());
    }

    @ParameterizedTest
    @CsvSource({
            "3, Harry_Potter",
            "2, The_Foundation",
            "4, The_Lord_of_the_Rings"
    })
    void testIndividualBooks(Integer amount, String title) {
        Map<String, Integer> books = library.getBooks();

        assertEquals(amount, books.get(title));
    }
}