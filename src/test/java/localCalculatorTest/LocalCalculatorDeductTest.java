package localCalculatorTest;

import mentoringProgram.calculators.LocalCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LocalCalculatorDeductTest {
    LocalCalculator localCalculator;

    @BeforeMethod
    public void initialization(){
        localCalculator = new LocalCalculator();
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) localCalculator.deduct(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDeductCalculation() {
        return new Object[][]{
                {4.0, 2.0, 2.0},
                {-4.0, -2.0, -2.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE - Double.MIN_VALUE}
        };
    }
}
