package com.pluralsight.factory;

import com.pluralsight.factory.page.AboutPage;
import com.pluralsight.factory.page.CommentPage;
import com.pluralsight.factory.page.ContactPage;
import com.pluralsight.factory.page.PostPage;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Blog extends Website {
    @PostConstruct
    public void initialize() {
        System.out.println("Initializing");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Cleaning");
    }

    @Override
    public void createWebsite() {
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }
}
