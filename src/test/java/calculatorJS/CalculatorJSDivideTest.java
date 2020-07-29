package calculatorJS;

import mentoringProgram.calculators.CalculatorJS;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorJSDivideTest {
    CalculatorJS calculatorJS;

    @BeforeMethod
    public void initialization() {
        calculatorJS = new CalculatorJS();
    }

    @Test(dataProvider = "dataProviderForDivideCalculation")
    public void testDivide(double a, double b, double c) {

        assertEquals((double) calculatorJS.divide(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDivideCalculation() {
        return new Object[][]{
                {3.0, 4.0, 0.75},
                {-3.0, -4.0, 0.75},
        };
    }
}
