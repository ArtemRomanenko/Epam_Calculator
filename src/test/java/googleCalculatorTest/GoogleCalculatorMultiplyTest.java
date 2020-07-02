package googleCalculatorTest;

import mentoringProgram.calculators.GoogleCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleCalculatorMultiplyTest {
    GoogleCalculator googleCalculator;

    @BeforeMethod
    public void initialization(){
        googleCalculator = new GoogleCalculator();
    }

    @Test(dataProvider = "dataProviderForMultiplyCalculation")
    public void testMultiply(double a, double b, double c) {
        assertEquals((double) googleCalculator.multiply(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForMultiplyCalculation() {
        return new Object[][]{
                {4.0, 2.0, 8.0},
                {-4.0, -2.0, 8.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, 8.8817842E-16}
        };
    }
}
