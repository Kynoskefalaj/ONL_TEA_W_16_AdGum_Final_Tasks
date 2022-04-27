package zadania.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/cucumber/features/zadanie_2.feature",
        plugin = {"pretty",
                "html:out/zadanie_2report.html"
        }
)
public class Main02Test {


}