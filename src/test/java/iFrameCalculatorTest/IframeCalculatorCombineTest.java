package iFrameCalculatorTest;

import mentoringProgram.calculators.IframeCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IframeCalculatorCombineTest {
    IframeCalculator iframeCalculator;

    @BeforeMethod
    public void initialization() {
        iframeCalculator = new IframeCalculator();
    }

    @Test(dataProvider = "dataProviderForCombineCalculation")
    public void testCombine(double a, double b, double c) {
        assertEquals((double) iframeCalculator.combine(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForCombineCalculation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {-3.0, -4.0, -7.0}
        };
    }
}
