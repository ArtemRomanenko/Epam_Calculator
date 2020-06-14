package googleCalculatorTest;

import mentoringProgram.calculators.GoogleCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleCalculatorDivideTest {
    GoogleCalculator googleCalculator;

    @BeforeMethod
    public void initialization(){
        googleCalculator = new GoogleCalculator();
    }

    @Test(dataProvider = "dataProviderForDivideCalculation")
    public void testDivide(double a, double b, double c) {

        assertEquals((double) googleCalculator.divide(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDivideCalculation() {
        return new Object[][]{
                {3.0, 4.0, 0.75},
                {-3.0, -4.0, 0.75},
                {Double.MAX_VALUE, 2.0, 8.988466E307}
        };
    }
}
