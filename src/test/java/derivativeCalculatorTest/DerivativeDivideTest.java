package derivativeCalculatorTest;

import mentoringProgram.calculators.DerivativeCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DerivativeDivideTest {
    DerivativeCalculator derivativeCalculator;

    @BeforeMethod
    public void initialization() {
        derivativeCalculator = new DerivativeCalculator();
    }

    @Test(dataProvider = "dataProviderForDivideCalculation")
    public void testDivide(double a, double b, double c) {

        assertEquals((double) derivativeCalculator.divide(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDivideCalculation() {
        return new Object[][]{
                {3.0, 4.0, 0.75},
                {-3.0, -4.0, 0.75},
        };
    }
}
