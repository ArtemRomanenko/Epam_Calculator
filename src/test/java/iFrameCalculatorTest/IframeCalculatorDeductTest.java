package iFrameCalculatorTest;

import mentoringProgram.calculators.IframeCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IframeCalculatorDeductTest {
    IframeCalculator iframeCalculator;

    @BeforeMethod
    public void initialization(){
        iframeCalculator = new IframeCalculator();
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) iframeCalculator.deduct(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDeductCalculation() {
        return new Object[][]{
                {4.0, 2.0, 2.0},
                {-4.0, -2.0, -2.0},
        };
    }
}
