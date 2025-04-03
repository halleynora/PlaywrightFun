package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.models.search.SearchLocators;
import org.example.models.search.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class TestBingSearch {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeEach
    void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    void mySearch() {
            page = browser.newPage();
            SearchPage searchPage = new SearchPage(page);
            searchPage.navigate();
            searchPage.search("owls");
            assertThat(page.locator(SearchLocators.SEARCH_INPUT_BOX)).hasText("owls");
            
        }

    @Test
    void assertCoPilotButton() {
        //new BrowserType.LaunchOptions().setHeadless(false)
        try (Playwright playwright = Playwright.create()) {
            page = browser.newPage();
            SearchPage searchPage = new SearchPage(page);
            searchPage.navigate();
            assertThat(page.locator(SearchLocators.COPILOT_BUTTON)).isVisible();

        }
    }

    @Test
    void clickCoPilotButton() {
        try (Playwright playwright = Playwright.create()) {
            page = browser.newPage();
            SearchPage searchPage = new SearchPage(page);
            searchPage.navigate();
            assertThat(page.locator(SearchLocators.COPILOT_BUTTON)).isVisible();
            page.locator(SearchLocators.COPILOT_BUTTON).click();
            assertThat(page).hasTitle("Microsoft Copilot: Your AI companion");
        }
    }

    @AfterEach
    void teardown() {
        browser.close();
        playwright.close();
    }
//    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//            Page page = browser.newPage();
//            page.navigate("https://qaplayground.dev/apps/verify-account/");
//            System.out.println(page.title());
//
//// In the test
////            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
////
////            Page page = browser.newPage();
////            SearchPage searchPage = new SearchPage(page);
////            searchPage.navigate();
////            searchPage.search("owls");
////            await assertThat(page.locator("[aria-label='0 characters out of 2000']")).hasText("owls");
//        }
//    }
}