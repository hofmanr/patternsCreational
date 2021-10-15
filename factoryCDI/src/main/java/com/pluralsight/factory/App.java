package com.pluralsight.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class App {
    private static Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Inject
    @Site(WebsiteType.BLOG)
    private Website blog;

    @Inject
    @Site(WebsiteType.SHOP)
    private Website shop;

    public void run() {
        LOGGER.info("Running...");
        LOGGER.info(blog.getPages().toString());
        LOGGER.info(shop.getPages().toString());
    }


}
