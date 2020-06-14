package localCalculatorTest;

import mentoringProgram.calculators.LocalCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LocalCalculatorDivideTest {
    LocalCalculator localCalculator;

    @BeforeMethod
    public void initialization(){
        localCalculator = new LocalCalculator();
    }

    @Test(dataProvider = "dataProviderForDivideCalculation")
    public void testDivide(double a, double b, double c) {

        assertEquals((double) localCalculator.divide(a, b), c);

    }

    @DataProvider
    public Object[][] dataProviderForDivideCalculation() {
        return new Object[][]{
                {3.0, 4.0, 0.75},
                {-3.0, -4.0, 0.75},
                {Double.MAX_VALUE, 2.0, 8.988465674311579E307}
        };
    }
}
