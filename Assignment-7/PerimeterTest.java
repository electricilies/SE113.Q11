import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerimeterTest {

    //mock function - for testing

    public int perimeter(int length, int width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Negative length or width");
        }
        return 2*(length+width);
    }

    //Unit test

    @Test
    void TC_PE_01() {
        assertEquals(20, perimeter(0,10));
    }

    @Test
    void TC_PE_02() {
        assertEquals(20, perimeter(10, 0));
    }

    @Test
    void TC_PE_03() {
        assertEquals(0, perimeter(0,0));
    }
    @Test
    void TC_PE_04() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {perimeter(-1,5);});
        assertEquals("Negative length or width", exception.getMessage());
    }

    @Test
    void TC_PE_05() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {perimeter(1,-5);});
        assertEquals("Negative length or width", exception.getMessage());
    }

    @Test
    void TC_PE_06() {
        assertEquals(2147483646, perimeter(1073741822,1));
    }
}
