package calculatorApiRestTest;

import mentoringProgram.calculators.CalculatorApiRest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorRestDeductTest {
    CalculatorApiRest calculatorApiRest;

    @BeforeMethod
    public void initialization() {
        calculatorApiRest = new CalculatorApiRest();
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) calculatorApiRest.deduct(a, b), c);
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
