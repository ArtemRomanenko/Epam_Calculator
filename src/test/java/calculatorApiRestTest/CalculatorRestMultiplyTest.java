package calculatorApiRestTest;

import mentoringProgram.calculators.CalculatorApiRest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorRestMultiplyTest {
    CalculatorApiRest calculatorApiRest;

    @BeforeMethod
    public void initialization() {
        calculatorApiRest = new CalculatorApiRest();
    }

    @Test(dataProvider = "dataProviderForMultiplyCalculation")
    public void testMultiply(double a, double b, double c) {
        assertEquals((double) calculatorApiRest.multiply(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForMultiplyCalculation() {
        return new Object[][]{
                {4.0, 2.0, 8.0},
                {-4.0, -2.0, 8.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, 8.881784197001251E-16}
        };
    }
}
