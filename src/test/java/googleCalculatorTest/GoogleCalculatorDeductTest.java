package googleCalculatorTest;

import mentoringProgram.calculators.GoogleCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleCalculatorDeductTest {
    GoogleCalculator googleCalculator;

    @BeforeMethod
    public void initialization(){
        googleCalculator = new GoogleCalculator();
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) googleCalculator.deduct(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDeductCalculation() {
        return new Object[][]{
                {4.0, 2.0, 2.0},
                {-4.0, -2.0, -2.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, 1.797693E308}
        };
    }
}
