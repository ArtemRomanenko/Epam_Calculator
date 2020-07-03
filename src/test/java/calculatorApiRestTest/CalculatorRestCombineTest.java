package calculatorApiRestTest;

import mentoringProgram.calculators.CalculatorApiRest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorRestCombineTest {
    CalculatorApiRest calculatorApiRest;

    @BeforeMethod
    public void initialization() {
        calculatorApiRest = new CalculatorApiRest();
    }

    @Test(dataProvider = "dataProviderForCombineCalculation")
    public void testCombine(double a, double b, double c) {
        assertEquals((double) calculatorApiRest.combine(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForCombineCalculation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {-3.0, -4.0, -7.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, 1.7976931348623157E308}
        };
    }
}
