package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.models.SearchPage;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class App {


    @Test
    void mySearch() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            SearchPage searchPage = new SearchPage(page);
            searchPage.navigate();
            searchPage.search("owls");
            assertThat(page.locator("[aria-label='0 characters out of 2000']")).hasText("owls");
        }
    }


    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://qaplayground.dev/apps/verify-account/");
            System.out.println(page.title());

// In the test
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//
//            Page page = browser.newPage();
//            SearchPage searchPage = new SearchPage(page);
//            searchPage.navigate();
//            searchPage.search("owls");
//            await assertThat(page.locator("[aria-label='0 characters out of 2000']")).hasText("owls");
        }
    }
}