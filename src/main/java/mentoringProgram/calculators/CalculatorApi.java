package mentoringProgram.calculators;

import mentoringProgram.interfacePackage.CalculatorInterface;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class CalculatorApi implements CalculatorInterface {
    private final String API_ENDPOINT = "http://api.mathjs.org/v4/?expr=";

    @Override
    public Double combine(Double x, Double y) {
        return calculationResult(createRequest(x, y, "+"));
    }

    @Override
    public Double deduct(Double x, Double y) {
        return calculationResult(createRequest(x, y, "-"));
    }

    @Override
    public Double multiply(Double x, Double y) {
        return calculationResult(createRequest(x, y, "*"));
    }

    @Override
    public Double divide(Double x, Double y) {
        return calculationResult(createRequest(x, y, "/"));
    }

    private String createRequest(double firstDigit, double secondDigit, String userSign) {
        String encodeUserInput = URLEncoder.encode(firstDigit
                + userSign + secondDigit, StandardCharsets.UTF_8);
        return API_ENDPOINT + encodeUserInput;
    }

    private double calculationResult(String requestToApi) {
        double result = 0.0;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestToApi))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            result = Double.parseDouble(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
