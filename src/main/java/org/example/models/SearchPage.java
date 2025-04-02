package org.example.models;

import com.microsoft.playwright.*;

public class SearchPage {
    private final Page page;
    private final Locator searchTermInput;

    public SearchPage(Page page) {
        this.page = page;
        this.searchTermInput = page.locator("[aria-label='0 characters out of 2000']");
    }

    public void navigate() {
        page.navigate("https://bing.com");
    }

    public void search(String text) {
        searchTermInput.fill(text);
        searchTermInput.press("Enter");
    }
}
