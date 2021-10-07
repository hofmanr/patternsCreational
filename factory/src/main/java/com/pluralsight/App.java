package com.pluralsight;

import com.pluralsight.factory.Website;
import com.pluralsight.factory.WebsiteFactory;
import com.pluralsight.factory.WebsiteType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);

        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsite(WebsiteType.SHOP);

        System.out.println(site.getPages());
    }
}
