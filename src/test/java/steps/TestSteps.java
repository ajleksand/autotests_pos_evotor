package steps;

import io.cucumber.java.en.Given;

public class TestSteps {
    @Given("install app")
    public void installApp() {
        System.out.println("install complete");
    }
}
