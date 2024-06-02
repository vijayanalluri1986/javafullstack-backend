package com.example.hexagonal_architecture_example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/User.feature",
        glue = "com.example.hexagonal_architecture_example.stepdefs",
        tags = "@User",
        plugin = {"pretty", "html:target/cucumber-reports"},
        publish = true
)
public class UserRunner {
}
