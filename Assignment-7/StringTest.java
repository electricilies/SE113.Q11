import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;
import java.text.ParseException;
import java.util.InputMismatchException;

public class StringTest {

    // mock function - for testing
    public boolean isValid(String str) {

        if (str.isEmpty()) {
            throw new IllegalArgumentException("String empty");
        }

        if (str.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new IllegalArgumentException("String includes special character(s)");
        }

        if (str.matches("[0-9]+")) {
            throw new IllegalArgumentException("String contains only number(s).");
        }

        if (str.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("String contains only letter(s).");
        }

        return true;
    }

    //unit test
    @Test
    void TC_ST_01() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {isValid("");});
        assertEquals("String empty", exception.getMessage());
    }

    @Test
    void TC_ST_02() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {isValid("123@");});
        assertEquals("String includes special character(s)", exception.getMessage());
    }

    @Test
    void TC_ST_03() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {isValid("1234");});
        assertEquals("String contains only number(s).", exception.getMessage());
    }

    @Test
    void TC_ST_04() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {isValid("AbCd");});
        assertEquals("String contains only letter(s).", exception.getMessage());
    }

    @Test
    void TC_ST_05() {
        assertTrue(isValid("abc12345"));
    }
}
