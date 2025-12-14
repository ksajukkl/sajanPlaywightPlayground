package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    public Locator homePageTextBox;

    public HomePage(Page currentPage){
        homePageTextBox = currentPage.locator("//textarea[@aria-label='Search']");
    }
}
