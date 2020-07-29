package calculatorAPITest;

import mentoringProgram.calculators.CalculatorApi;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorAPIDeductTest {
    CalculatorApi calculatorApi;

    @BeforeMethod
    public void initialization() {
        calculatorApi = new CalculatorApi();
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) calculatorApi.deduct(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDeductCalculation() {
        return new Object[][]{
                {4.0, 2.0, 2.0},
                {-4.0, -2.0, -2.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, 1.7976931348623157E308}
        };
    }
}
