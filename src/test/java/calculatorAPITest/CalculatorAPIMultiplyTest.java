package calculatorAPITest;

import mentoringProgram.calculators.CalculatorApi;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorAPIMultiplyTest {
    CalculatorApi calculatorApi;

    @BeforeMethod
    public void initialization() {
        calculatorApi = new CalculatorApi();
    }

    @Test(dataProvider = "dataProviderForMultiplyCalculation")
    public void testMultiply(double a, double b, double c) {
        assertEquals((double) calculatorApi.multiply(a, b), c);
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
