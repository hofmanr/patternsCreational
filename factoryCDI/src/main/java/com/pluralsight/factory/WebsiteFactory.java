package com.pluralsight.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;

/* see: https://dzone.com/articles/cdi-part-2-qualifiers-in-java-polymorphism-in-di */
/* and https://blog.creekorful.org/2019/08/using-cdi-2-0-in-a-java-se-application/ */
public class WebsiteFactory {
    private static Logger LOGGER = LoggerFactory.getLogger(WebsiteFactory.class);

    @Produces
    @Site(WebsiteType.BLOG)
    public Blog blogSite() {
        LOGGER.info("BLOG created");
        return new Blog();
    }

    @Produces
    @Site(WebsiteType.SHOP)
    public Shop shopSite() {
        LOGGER.info("SHOP created");
        return new Shop();
    }

}
