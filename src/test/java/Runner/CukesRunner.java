package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "step_definitions",
        monochrome = true,
        features = "src/test/resources/features/",
        dryRun = false
       )

public class CukesRunner {

}