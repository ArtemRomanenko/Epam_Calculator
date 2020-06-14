package calculatorPiTest;

import mentoringProgram.calculators.CalculatorPi;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPiMultiplyTest {
    CalculatorPi calculatorPi;

    @BeforeMethod
    public void initialization(){
        calculatorPi = new CalculatorPi();
    }

    @Test(dataProvider = "dataProviderForMultiplyCalculation")
    public void testMultiply(double a, double b, double c) {
        assertEquals((double) calculatorPi.multiply(a, b), c);
    }

    @DataProvider
    public Object[][] dataProviderForMultiplyCalculation() {
        return new Object[][]{
                {4.0, 2.0, 8.0},
                {-4.0, -2.0, 8.0}
        };
    }
}
