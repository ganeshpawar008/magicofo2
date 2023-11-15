package com.Definitions;

import com.TestBase.Keywords;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/Features",glue = "com.TestBasse.Hooks1")
public class FeatureRunner extends AbstractTestNGCucumberTests  {
	
}
