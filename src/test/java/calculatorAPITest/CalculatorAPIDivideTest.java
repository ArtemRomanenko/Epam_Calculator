package calculatorAPITest;

import mentoringProgram.calculators.CalculatorApi;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorAPIDivideTest {
    CalculatorApi calculatorApi;

    @BeforeMethod
    public void initialization() {
        calculatorApi = new CalculatorApi();
    }

    @Test(dataProvider = "dataProviderForDivideCalculation")
    public void testDivide(double a, double b, double c) {

        assertEquals((double) calculatorApi.divide(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDivideCalculation() {
        return new Object[][]{
                {3.0, 4.0, 0.75},
                {-3.0, -4.0, 0.75},
                {Double.MAX_VALUE, 2.0, 8.988465674311579E307}
        };
    }
}
