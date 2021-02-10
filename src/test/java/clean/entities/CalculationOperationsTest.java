package clean.entities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

public class CalculationOperationsTest {

    @Test
    public void returnsSum_whenAdditionSelected() {
        BigDecimal result = CalculationOperations.ADDITION.calculate(new BigDecimal("10"), new BigDecimal("15"));

        assertEquals(result, new BigDecimal("25"));
    }

    @Test
    public void returnsMinus_whenSubstractionSelected() {
        BigDecimal result = CalculationOperations.SUBTRACTION.calculate(new BigDecimal("10"), new BigDecimal("5"));

        assertEquals(result, new BigDecimal("5"));
    }

    @Test
    public void returnsmultiplication_whenMultiplicationSelected() {
        BigDecimal result = CalculationOperations.MULTIPLICATION.calculate(new BigDecimal("10"), new BigDecimal("5"));

        assertEquals(result, new BigDecimal("50"));
    }

    @Test
    public void returnsDIVISION_whenDivisionSelected() {
        BigDecimal result = CalculationOperations.DIVISION.calculate(new BigDecimal("10"), new BigDecimal("5"));

        assertEquals(result, new BigDecimal("2"));
    }

}
