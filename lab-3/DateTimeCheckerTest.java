import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTimeCheckerTest {

    // Mock function - for testing
    public int DayInMonth(int month, int year) {
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Input is out of range");
        if (year < 1000 || year > 3000)
            throw new IllegalArgumentException("Input is out of range");

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> { return 31; }
            case 4, 6, 9, 11 -> { return 30; }
            case 2 -> {
                boolean isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
                return isLeap ? 29 : 28;
            }
            default -> throw new IllegalArgumentException("Input is out of range");
        }
    }

    // Unit test

    @Test
    void TC_DIM_01() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> DayInMonth(0, 2023));
        assertEquals("Input is out of range", ex.getMessage());
    }

    @Test
    void TC_DIM_02() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> DayInMonth(13, 2023));
        assertEquals("Input is out of range", ex.getMessage());
    }

    @Test
    void TC_DIM_03() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> DayInMonth(1, 999));
        assertEquals("Input is out of range", ex.getMessage());
    }

    @Test
    void TC_DIM_04() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> DayInMonth(1, 3001));
        assertEquals("Input is out of range", ex.getMessage());
    }

    @Test
    void TC_DIM_05() {
        assertThrows(NumberFormatException.class, () -> {
            int m = Integer.parseInt("abc");
            DayInMonth(m, 2023);
        });
    }

    @Test
    void TC_DIM_06() {
        assertThrows(NumberFormatException.class, () -> {
            int y = Integer.parseInt("abc");
            DayInMonth(2, y);
        });
    }

    @Test
    void TC_DIM_07() {
        assertEquals(31, DayInMonth(1, 2023));
    }

    @Test
    void TC_DIM_08() {
        assertEquals(30, DayInMonth(4, 2023));
    }

    @Test
    void TC_DIM_09() {
        assertEquals(29, DayInMonth(2, 2024));
    }

    @Test
    void TC_DIM_10() {
        assertEquals(28, DayInMonth(2, 2023));
    }

    @Test
    void TC_DIM_11() {
        assertEquals(31, DayInMonth(1, 1000));
    }

    @Test
    void TC_DIM_12() {
        assertEquals(31, DayInMonth(12, 3000));
    }
}
