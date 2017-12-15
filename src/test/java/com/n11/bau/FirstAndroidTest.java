package com.n11.bau;

import com.n11.bau.pages.AndroidHomePage;
import com.n11.bau.pages.HomePage;
import org.junit.Test;

import static com.n11.bau.BuyerPool.getBauBuyer;

public class FirstAndroidTest extends BaseTest {

    @Test
    public void searchTest() {
        String keyword = "samsung";

        Buyer buyer = getBauBuyer();
        buyer.searchAndroid(driver, keyword);


    }
}
