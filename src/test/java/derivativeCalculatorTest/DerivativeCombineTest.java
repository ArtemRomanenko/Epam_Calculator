package derivativeCalculatorTest;

import mentoringProgram.calculators.DerivativeCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DerivativeCombineTest {
    DerivativeCalculator derivativeCalculator;

    @BeforeMethod
    public void initialization() {
        derivativeCalculator = new DerivativeCalculator();
    }

    @Test(dataProvider = "dataProviderForCombineCalculation")
    public void testCombine(double a, double b, double c) {
        assertEquals((double) derivativeCalculator.combine(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForCombineCalculation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {-3.0, -4.0, -7.0}
        };
    }
}
