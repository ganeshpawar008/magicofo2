package testRunner;

import org.junit.runner.RunWith;

import com.intuit.karate.junit4.Karate;

import cucumber.api.CucumberOptions;

@RunWith(Karate.class) 
@io.cucumber.junit.CucumberOptions(glue="testRunner")
public class KarateRunner {
	

}
 