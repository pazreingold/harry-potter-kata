package harry.potter.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class HarryBookStoreTest {

    private HarryBookStore harryBookStore;

    @BeforeEach
    void setUp() {
        harryBookStore = new HarryBookStore();
    }

    @Test
    void buyOneBook() {
        Map<Integer, Integer> books = Map.of(1, 1);


        assertEquals(8, harryBookStore.buy(books), "Should cost 8 Euros");
    }

    @Test
    void buyTwoCopiesOfTheSameBook() {
        Map<Integer, Integer> books = Map.of(1, 2);

        assertEquals(16, harryBookStore.buy(books), "Should cost 16 Euros");
    }

    @Test
    void buyTwoDifferentBooks() {
        Map<Integer, Integer> books = Map.of(
                1, 1,
                2, 1);

        assertEquals(0.95 * 16, harryBookStore.buy(books));
    }

    @Test
    void buyFiveDifferentCopies() {
        Map<Integer, Integer> books = Map.of(
                1, 1,
                2, 1,
                3, 1,
                4, 1,
                5, 1);

        assertEquals(0.75 * 8 * 5, harryBookStore.buy(books));
    }

    @Test
    void buyTwoCopiesFromOneBookAndOneCopyFromDifferentBook() {
        Map<Integer, Integer> books = Map.of(
                1, 2,
                2, 1);

        assertEquals(0.95 * 8 * 2 + 8, harryBookStore.buy(books));

    }
}