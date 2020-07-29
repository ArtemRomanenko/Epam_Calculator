package localCalculatorTest;

import mentoringProgram.calculators.LocalCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LocalCalculatorCombineTest {
    LocalCalculator localCalculator;

    @BeforeMethod
    public void initialization(){
        localCalculator = new LocalCalculator();
    }

    @Test(dataProvider = "dataProviderForCombineCalculation")
    public void testCombine(double a, double b, double c) {
        assertEquals((double) localCalculator.combine(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForCombineCalculation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {-3.0, -4.0, -7.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE + Double.MIN_VALUE}
        };
    }
}
