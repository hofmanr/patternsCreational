package com.pluralsight.factory2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class App2 {
    private static Logger LOGGER = LoggerFactory.getLogger(App2.class);

    @Inject
    private WebsiteFactory2 factory2;

    public void run() {
        LOGGER.info("Running...");
        Website blog = factory2.getInstance(WebsiteType.BLOG);
        LOGGER.info(blog.getPages().toString());
        factory2.destroy(blog);

        Website shop = factory2.getInstance(WebsiteType.SHOP);
        LOGGER.info(shop.getPages().toString());
        factory2.destroy(shop);

        factory2.executeLeakFixedCDI11(WebsiteType.BLOG);
        factory2.executeLeakFixedCDI10(WebsiteType.SHOP);
    }


}
