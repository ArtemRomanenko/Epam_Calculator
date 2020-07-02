package calculatorPiTest;

import mentoringProgram.calculators.CalculatorPi;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPiDeductTest {
    CalculatorPi calculatorPi;

    @BeforeMethod
    public void initialization() {
        calculatorPi = new CalculatorPi();
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) calculatorPi.deduct(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDeductCalculation() {
        return new Object[][]{
                {4.0, 2.0, 2.0},
                {-4.0, -2.0, -2.0},
        };
    }
}
