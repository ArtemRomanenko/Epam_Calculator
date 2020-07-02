package derivativeCalculatorTest;

import mentoringProgram.calculators.DerivativeCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DerivativeDeductTest {
    DerivativeCalculator derivativeCalculator;

    @BeforeMethod
    public void initialization() {
        derivativeCalculator = new DerivativeCalculator();
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) derivativeCalculator.deduct(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDeductCalculation() {
        return new Object[][]{
                {4.0, 2.0, 2.0},
                {-4.0, -2.0, -2.0},
        };
    }
}
