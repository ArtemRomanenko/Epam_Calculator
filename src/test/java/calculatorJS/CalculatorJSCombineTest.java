package calculatorJS;

import mentoringProgram.calculators.CalculatorJS;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorJSCombineTest {
    CalculatorJS calculatorJS;

    @BeforeMethod
    public void initialization() {
        calculatorJS = new CalculatorJS();
    }

    @Test(dataProvider = "dataProviderForCombineCalculation")
    public void testCombine(double a, double b, double c) {
        assertEquals((double) calculatorJS.combine(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForCombineCalculation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {-3.0, -4.0, -7.0},
        };
    }
}
