package Hooks;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Baseclass.Base_class;
import Baseclass.ProfileActivationBaseClass;
import Stepdefinitions.ProfileActivationStepDefinition;
import io.cucumber.java.After;

//import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
//import io.cucumber.plugin.event.Node.Scenario;
//import io.cucumber.messages.Messages.GherkinDocument.Feature.Scenario;
//import tech.grasshopper.pdf.pojo.cucumber.Scenario;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@AfterStep
	public void reportScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot=((TakesScreenshot)ProfileActivationBaseClass.driver).getScreenshotAs(OutputType.BYTES); 
			scenario.attach(screenshot, "image/png", "error_screen");
			ProfileActivationBaseClass.driver.close();
		}
		else {
			byte[] screenshot=((TakesScreenshot)ProfileActivationBaseClass.driver).getScreenshotAs(OutputType.BYTES); 
			scenario.attach(screenshot, "image/png", "success_screen");
			ProfileActivationBaseClass.driver.close();
		}
		
	}

}
