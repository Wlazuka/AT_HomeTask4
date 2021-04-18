package com.automationpractice;

import com.automationpractice.pageObject.SearchResultsPage;
import com.automationpractice.utils.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    private static final String SEARCH_PHRASE = PropertyManager.getProperty("search.phrase");
    private static final String EXPECTED_TEXT = PropertyManager.getProperty("expected.search.result.text");
    private static final String EXPECTED_QUANTITY = PropertyManager.getProperty("expected.search.quantity");

    @Test()
    public void productSearch() {
        homePage.open()
                .searchProduct(SEARCH_PHRASE);
        Assert.assertEquals(SearchResultsPage.searchCounter.getText(), EXPECTED_TEXT);
        Assert.assertEquals(SearchResultsPage.resultList.size(), Integer.parseInt(EXPECTED_QUANTITY));
    }
}
