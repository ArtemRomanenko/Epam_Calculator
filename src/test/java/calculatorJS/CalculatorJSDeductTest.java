package calculatorJS;

import mentoringProgram.calculators.CalculatorJS;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorJSDeductTest {
    CalculatorJS calculatorJS;

    @BeforeMethod
    public void initialization() {
        calculatorJS = new CalculatorJS();
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) calculatorJS.deduct(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDeductCalculation() {
        return new Object[][]{
                {4.0, 2.0, 2.0},
                {-4.0, -2.0, -2.0},
        };
    }
}
