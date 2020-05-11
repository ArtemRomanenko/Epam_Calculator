import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.*;
public class LocalCalculatorTest {
    LocalCalculator localCalculator = new LocalCalculator();

    @Test(dataProvider = "dataProviderForCombineCalculation")
    public void testCombine(double a, double b, double c) {
        assertEquals((double) localCalculator.combine(a, b), c);
    }

    @Test(dataProvider = "dataProviderForDeductCalculation")
    public void testDeduct(double a, double b, double c) {
        assertEquals((double) localCalculator.deduct(a, b), c);
    }

    @Test(dataProvider = "dataProviderForMultiplyCalculation")
    public void testMultiply(double a, double b, double c) {
        assertEquals((double) localCalculator.multiply(a, b), c);
    }

    @Test(dataProvider = "dataProviderForDivideCalculation")
    public void testDivide(double a, double b, double c) {

        assertEquals((double) localCalculator.divide(a, b), c);

    }

    @DataProvider
    public Object[][] dataProviderForCombineCalculation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {-3.0, -4.0, -7.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE + Double.MIN_VALUE}
        };
    }

    @DataProvider
    public Object[][] dataProviderForDeductCalculation() {
        return new Object[][]{
                {4.0, 2.0, 2.0},
                {-4.0, -2.0, -2.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE - Double.MIN_VALUE}
        };
    }

    @DataProvider
    public Object[][] dataProviderForMultiplyCalculation() {
        return new Object[][]{
                {4.0, 2.0, 8.0},
                {-4.0, -2.0, 8.0},
                {Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE * Double.MIN_VALUE}
        };
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
