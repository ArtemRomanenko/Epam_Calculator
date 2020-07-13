package mentoringProgram.calculators;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import mentoringProgram.calculatorLogic.ErrorHandler;
import mentoringProgram.interfacePackage.CalculatorInterface;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CalculatorApiRest extends ErrorHandler implements CalculatorInterface {
    private final String EXPRESSION = "expr";
    private final Map<String, Object> requestBody = new HashMap<>();
    private final RequestSpecification requestSpecification = given()
            .contentType(ContentType.JSON)
            .baseUri("http://api.mathjs.org/v4/");

    @Override
    public Double combine(Double x, Double y) {
        return calculationRequest(createUserRequest(x, y, "+"));
    }

    @Override
    public Double deduct(Double x, Double y) {
        return calculationRequest(createUserRequest(x, y, "-"));
    }

    @Override
    public Double multiply(Double x, Double y) {
        return calculationRequest(createUserRequest(x, y, "*"));
    }

    @Override
    public Double divide(Double x, Double y) {
        divisionByZeroCheck(y);
        return calculationRequest(createUserRequest(x, y, "/"));
    }

    private Map<String, Object> createUserRequest(double firstDigit, double secondDigit, String userSign) {
        String userRequest = firstDigit + userSign + secondDigit;
        requestBody.put(EXPRESSION, userRequest);
        return requestBody;
    }

    private double calculationRequest(Map<String, Object> userRequest) {
        String response = requestSpecification
                .body(userRequest)
                .post()
                .jsonPath()
                .get("result");
        return Double.parseDouble(response);
    }
}
