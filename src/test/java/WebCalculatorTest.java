import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WebCalculatorTest {
    WebCalculator webCalculator = new WebCalculator();

    @Test(dataProvider = "dataProviderForCombineCalculation")
    public void testCombine(double a, double b, double c) {
        assertEquals((double) webCalculator.combine(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForCombineCalculation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {-3.0, -4.0, -7.0},
        };
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

    @Test(dataProvider = "dataProviderForMultiplyCalculation")
    public void testMultiply(double a, double b, double c) {
        assertEquals((double) webCalculator.multiply(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForMultiplyCalculation() {
        return new Object[][]{
                {4.0, 2.0, 8.0},
                {-4.0, -2.0, 8.0},
        };
    }

    @Test(dataProvider = "dataProviderForDivideCalculation")
    public void testDivide(double a, double b, double c) {

        assertEquals((double) webCalculator.divide(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForDivideCalculation() {
        return new Object[][]{
                {3.0, 4.0, 0.75},
                {-3.0, -4.0, 0.75},
        };
    }
}