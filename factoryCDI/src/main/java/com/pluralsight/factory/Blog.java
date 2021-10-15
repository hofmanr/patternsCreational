package com.pluralsight.factory;

import com.pluralsight.factory.page.AboutPage;
import com.pluralsight.factory.page.CommentPage;
import com.pluralsight.factory.page.ContactPage;
import com.pluralsight.factory.page.PostPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Site(WebsiteType.BLOG)
public class Blog extends Website {
    private static Logger LOGGER = LoggerFactory.getLogger(Blog.class);

    /**
     * PostConstruct does not wok when using de WebsiteFactory
     */
    @PostConstruct
    public void initialize() {
        LOGGER.debug("Initializing");
    }

    /**
     * PreDestroy does not wok when using de WebsiteFactory
     */
    @PreDestroy
    public void cleanup() {
        LOGGER.debug("Cleaning");
    }

    @Override
    public void createWebsite() {
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }
}
