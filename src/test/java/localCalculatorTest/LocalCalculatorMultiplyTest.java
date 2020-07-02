package localCalculatorTest;

import mentoringProgram.calculators.LocalCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LocalCalculatorMultiplyTest {
    LocalCalculator localCalculator;

    @BeforeMethod
    public void initialization(){
        localCalculator = new LocalCalculator();
    }

    @Test(dataProvider = "dataProviderForMultiplyCalculation")
    public void testMultiply(double a, double b, double c) {
        assertEquals((double) localCalculator.multiply(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForMultiplyCalculation() {
        return new Object[][]{
                {4.0, 2.0, 8.0},
                {-4.0, -2.0, 8.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE * Double.MIN_VALUE}
        };
    }
}
