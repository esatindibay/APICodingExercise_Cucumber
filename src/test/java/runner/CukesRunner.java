package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


// i execute my test here
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "step_definitions", // this indicates that step definition package
        monochrome = true,         // this is for more readable console output
        features = "src/test/resources/features/",  // this indicates feature file
        dryRun = false              // i used dryRun=true for checking the implementation is correct or not
       )

public class CukesRunner {

}