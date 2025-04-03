package org.example.models;

import com.microsoft.playwright.*;

public class SearchPage {
    private final Page page;
    private final Locator searchTermInput;

    public SearchPage(Page page) {
        this.page = page;
        this.searchTermInput = page.locator(SearchLocators.SEARCH_INPUT_BOX);
    }

    public void navigate() {
        page.navigate("https://bing.com");
    }

    public void search(String text) {
        searchTermInput.fill(text);
        searchTermInput.press("Enter");
    }


}
