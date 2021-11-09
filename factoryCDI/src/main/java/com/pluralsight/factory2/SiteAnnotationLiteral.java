package com.pluralsight.factory2;

import javax.enterprise.util.AnnotationLiteral;

public class SiteAnnotationLiteral extends AnnotationLiteral<Site> implements Site {
    private WebsiteType websiteType;

    public SiteAnnotationLiteral(WebsiteType websiteType) {
        this.websiteType = websiteType;
    }

    @Override
    public WebsiteType value() {
        return websiteType;
    }
}
