package translationadapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {
    private DataBase db;

    @BeforeEach
    void setUp() {
        db = new DataBase();
    }

    @Test
    void getUserData() {
        assertEquals("hello", db.getUserData());
    }

    @Test
    void getStatisticData() {
        assertEquals("hello2", db.getStatisticData());
    }
}