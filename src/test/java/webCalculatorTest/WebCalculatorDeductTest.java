package webCalculatorTest;

import mentoringProgram.calculators.WebCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WebCalculatorDeductTest {
    WebCalculator webCalculator;

    @BeforeMethod
    public void initialization(){
        webCalculator = new WebCalculator();
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) webCalculator.deduct(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDeductCalculation() {
        return new Object[][]{
                {4.0, 2.0, 2.0},
                {-4.0, -2.0, -2.0},
        };
    }
}
