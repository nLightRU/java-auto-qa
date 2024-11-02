import me.nlight.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("Calculator add")
    void add() {
        Assertions.assertEquals(Calculator.add(1, 2), 3, "No way");
    }

    @Test
    @DisplayName("Calculator sub")
    void sub() {
        Assertions.assertEquals(Calculator.sub(1, 0), 1, "No way");
    }
}