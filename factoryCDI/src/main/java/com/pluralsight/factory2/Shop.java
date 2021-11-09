package com.pluralsight.factory2;

import com.pluralsight.factory.page.CartPage;
import com.pluralsight.factory.page.ItemPage;
import com.pluralsight.factory.page.SearchPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Site(WebsiteType.SHOP)
public class Shop extends Website {
    private static Logger LOGGER = LoggerFactory.getLogger(Shop.class);

    /**
     * PostConstruct does not wok when using the WebsiteFactory
     */
    @PostConstruct
    public void initialize() {
        LOGGER.debug("Initializing");
    }

    /**
     * PreDestroy does not wok when using the WebsiteFactory
     */
    @PreDestroy
    public void cleanup() {
        LOGGER.debug("Cleaning");
    }

    @Override
    public void createWebsite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }
}
