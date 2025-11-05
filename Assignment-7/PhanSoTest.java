import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.InputMismatchException;

public class PhanSoTest {

    //Mock function for testing
    public class PhanSo {
        private int tuSo, mauSo;

        public PhanSo(int tu, int mau) {
            if (mau == 0) throw new InputMismatchException("Error!");
            this.tuSo = tu; this.mauSo = mau;
        }
        public PhanSo cong(PhanSo p) {
            int t = this.tuSo * p.mauSo + this.mauSo * p.tuSo;
            int m = this.mauSo * p.mauSo;
            return new PhanSo(t, m);
        }
        public int getTuSo() {
            return this.tuSo;
        }

        public int getMauSo() {
            return this.mauSo;
        }

    }

    //Unit test

    @Test
    void TC_PS_01(){
        InputMismatchException exception = assertThrows(
                InputMismatchException.class,
                () -> new PhanSo(1, 0)
        );
        assertEquals("Error!", exception.getMessage());
    }

    @Test
    void TC_PS_02() {
        PhanSo a = new PhanSo(1,2);
        PhanSo b = new PhanSo(2,3);
        assertEquals(7, a.cong(b).getTuSo());
        assertEquals(6, a.cong(b).getMauSo());
    }
}