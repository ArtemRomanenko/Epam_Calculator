package googleCalculatorTest;

import mentoringProgram.calculators.GoogleCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleCalculatorCombineTest {
    GoogleCalculator googleCalculator;

    @BeforeMethod
    public void initialization(){
        googleCalculator = new GoogleCalculator();
    }

    @Test(dataProvider = "dataProviderForCombineCalculation")
    public void testCombine(double a, double b, double c) {
        assertEquals((double) googleCalculator.combine(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForCombineCalculation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {-3.0, -4.0, -7.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, 1.797693E308}
        };
    }
}
