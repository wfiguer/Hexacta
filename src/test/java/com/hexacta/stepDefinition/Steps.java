package com.hexacta.stepDefinition;

import com.hexacta.pages.Base;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Steps {
    Base base = new Base();

    
@Given("^I am in the main page$")
public void i_am_in_the_main_page() throws Throwable {

    base.openDriver();
    base.goPage();    
  
}

@When("^I search the text outsource$")
public void i_search_the_text_outsource() throws Throwable {

    base.search();
    
}
 
@Then("^I need to find the correct title$")
public void i_need_to_find_the_correct_title() throws Throwable {

    base.verifyPageTitle();
    base.closeDriver();
}
   
    
}
