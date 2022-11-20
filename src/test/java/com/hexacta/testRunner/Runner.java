package com.hexacta.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/java/com/hexacta/features",glue={""})	
public class Runner {
    
}
