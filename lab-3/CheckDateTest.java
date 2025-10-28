import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CheckDateTest {

    // Mock function - for testing
    public static String CheckDate(Object dayObj, Object monthObj, Object yearObj) {
        int day, month, year;

        // --- 1. Non-numeric input check ---
        try {
            day = Integer.parseInt(dayObj.toString());
            month = Integer.parseInt(monthObj.toString());
            year = Integer.parseInt(yearObj.toString());
        } catch (Exception e) {
            return "Input is invalid";
        }

        // --- 2. Range check ---
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1000 || year > 3000)
            return "Input is out of range";

        // --- 3. Check valid calendar date ---
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        if (isLeap) daysInMonth[1] = 29;

        if (day > daysInMonth[month - 1])
            return "Incorrect Date";

        // --- 4. Otherwise, correct date ---
        return "Correct Date";
    }
    // Unit test

    @Test
    public void TC_CD_001() {
        assertEquals("Input is invalid", CheckDate("abc", 12, 2023));
    }

    @Test
    public void TC_CD_002() {
        assertEquals("Input is invalid", CheckDate(1, "abc", 2023));
    }

    @Test
    public void TC_CD_003() {
        assertEquals("Input is invalid", CheckDate(1, 12, "abc"));
    }

    @Test
    public void TC_CD_004() {
        assertEquals("Input is out of range", CheckDate(0, 1, 2023));
    }

    @Test
    public void TC_CD_005() {
        assertEquals("Input is out of range", CheckDate(32, 1, 2023));
    }

    @Test
    public void TC_CD_006() {
        assertEquals("Input is out of range", CheckDate(1, 0, 2023));
    }

    @Test
    public void TC_CD_007() {
        assertEquals("Input is out of range", CheckDate(1, 13, 2023));
    }

    @Test
    public void TC_CD_008() {
        assertEquals("Input is out of range", CheckDate(1, 1, 999));
    }

    @Test
    public void TC_CD_009() {
        assertEquals("Input is out of range", CheckDate(1, 1, 3001));
    }

    @Test
    public void TC_CD_010() {
        assertEquals("Incorrect Date", CheckDate(31, 4, 2023));
    }

    @Test
    public void TC_CD_011() {
        assertEquals("Incorrect Date", CheckDate(29, 2, 2023));
    }

    @Test
    public void TC_CD_012() {
        assertEquals("Incorrect Date", CheckDate(30, 2, 2024));
    }


    @Test
    public void TC_CD_013() {
        assertEquals("Correct Date", CheckDate(29, 2, 2024));
    }

    @Test
    public void TC_CD_014() {
        assertEquals("Correct Date", CheckDate(30, 4, 2023));
    }

    @Test
    public void TC_CD_015() {
        assertEquals("Correct Date", CheckDate(31, 1, 2023));
    }

    @Test
    public void TC_CD_016() {
        assertEquals("Correct Date", CheckDate(1, 1, 1000));
    }

    @Test
    public void TC_CD_017() {
        assertEquals("Correct Date", CheckDate(31, 12, 3000));
    }
}