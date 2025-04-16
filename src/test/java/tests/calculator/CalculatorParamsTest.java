package tests.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import me.nlight.math.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParamsTest {
    @ParameterizedTest
    @Tag("Calculator")
    @DisplayName("Add")
    @CsvSource({
        "1, 1, 2",
        "3, 4, 7",
        "-2, 5, 3"
    })
    public void TestAddPParams(int a, int b, int res) {
        assertEquals(Calculator.add(a, b), res);
    }
}
