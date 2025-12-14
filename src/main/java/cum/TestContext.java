package cum;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.typesafe.config.Config;
import org.example.ConfigLoader;
import io.cucumber.java.Scenario;
import pages.HomePage;

import java.io.IOException;

public class TestContext {

    Page currentPage;
    Config config;
    Scenario scenario;
    StringBuilder tableBuilder;
    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

//    Scenario scenario;

    public TestContext() throws IOException {
        config = new ConfigLoader().loadFiles();
        currentPage= pageSetup();
    }

    public void createTable() {
        tableBuilder = new StringBuilder();

        tableBuilder.append("" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>Results</title>\n" +
                "    <style>...</style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <table border='1'>\n" +
                "    \n" +
                "      <tr>\n" +
                "        <td>Value1</td>\n" +
                 "       <td>Value2</td>\n" +
                "      </tr>");
    }

    public StringBuilder getTable() {
        tableBuilder.append("</tr>\n" +
                "</table>\n"+
                "\n"+
                "</body>\n"+
                "</html>\n"
        );
        return tableBuilder;
    }

    public void getValues() {
        tableBuilder.append("<tr><td>").append("Sajan1").append("</td>");
        tableBuilder.append("<td>").append("Nirved").append("</td>");
    }

    public Page pageSetup() throws IOException {
        Playwright play = Playwright.create();
        Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        return browser.newPage();
    }
    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    HomePage homePage;

    public void setCurrentPage(Page page){
        currentPage=page;
    }

    public Page getCurrentPage(){
        return currentPage;
    }

}
