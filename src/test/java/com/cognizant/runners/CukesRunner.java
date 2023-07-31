package com.cognizant.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html"
        },
        features = "src/test/resources/features",
        glue = "com/cognizant/step_definitions",
        dryRun = false,
        tags = ""
        //publish = true// generating a report with public link
)
public class CukesRunner {
}
