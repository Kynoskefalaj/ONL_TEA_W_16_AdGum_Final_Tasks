package zadania.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/cucumber/features/zadanie_1.feature",
        plugin = {"pretty",
                "html:out/zadanie_1report.html"
        }
)
public class Main01Test {


}