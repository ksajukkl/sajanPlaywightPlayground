package com.stepdefinitions;

import cum.TestContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.ConfigLoader;
import pages.HomePage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.testng.log4testng.Logger;

public class Stepdefinition {

    TestContext testContext;
    HomePage homePage;
    private static final Logger logger = Logger.getLogger(Stepdefinition.class);
    public Stepdefinition(){
        logger.info("Sajan");
    }
    public Stepdefinition(TestContext testContext){
        this.testContext = testContext;
    }
    @Given("Load the files")
    public void loadFiles() throws IOException {
        new ConfigLoader().loadFiles();
    }

    @Then("Navigate to URL")
    public void navigateToUrl() throws IOException {
        testContext.setCurrentPage(testContext.getCurrentPage());
        Page page= testContext.getCurrentPage();
        testContext.setHomePage(new HomePage(page));
        logger.info("Execution started");
        page.navigate("https://www.google.com");
        homePage =testContext.getHomePage();
        private static final Logger logger = Logger.getLogger(Stepdefinition.class);
        homePage.homePageTextBox.fill("Sajan");
        testContext.getValues();
        testContext.getValues();
        testContext.getScenario().attach(testContext.getTable().toString(),"text/html; charset=utf-8","NOName.html");
        logger.info("Execution Completed");
//        play.close();
    }

    @Before
    public void setup(Scenario scenario) {
        testContext.setScenario(scenario);
        testContext.createTable();
    }

    @After
    public void closeAll() throws IOException {
        String image= "screenshots\\"+ "sa"+".png";

        testContext.getCurrentPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get( "screenshots\\"+ "Sc"+".png")));
        testContext.getScenario().attach(testContext.getCurrentPage().screenshot(),"image/png","scName");
//        testContext.getScenario().attach(Files.readAllBytes(Paths.get(image).toAbsolutePath()),"image/png",image);
    }
}
