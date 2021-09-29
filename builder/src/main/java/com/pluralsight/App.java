package com.pluralsight;

import com.pluralsight.builder.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "LunchOrderBean (without builder)" );
        LunchOrderBean lunchOrderBean = new LunchOrderBean();

		lunchOrderBean.setBread("Wheat");
		lunchOrderBean.setCondiments("Lettuce");
		lunchOrderBean.setDressing("Mustard");
		lunchOrderBean.setMeat("Ham");

        System.out.println(lunchOrderBean.getBread());
        System.out.println(lunchOrderBean.getCondiments());
        System.out.println(lunchOrderBean.getDressing());
        System.out.println(lunchOrderBean.getMeat());


        System.out.println( "LunchOrderBean (telescopic)" );
        LunchOrderTele lunchOrderTele = new LunchOrderTele("Wheat", "Lettuce");

        // lunchOrderTele.setBread("Wheat");
        // lunchOrderTele.setCondiments("Lettuce");
        // lunchOrderTele.setDressing("Mustard");
        // lunchOrderTele.setMeat("Ham");

        System.out.println(lunchOrderTele.getBread());
        System.out.println(lunchOrderTele.getCondiments());
        System.out.println(lunchOrderTele.getDressing());
        System.out.println(lunchOrderTele.getMeat());


        System.out.println( "LunchOrderBean (builder)" );
        LunchOrder.Builder builder = new LunchOrder.Builder();

        builder.bread("Wheat").dressing("Mayo").meat("Turkey");

        LunchOrder lunchOrder = builder.build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());


        System.out.println( "LunchOrderBean (builder with existing class)" );
        UserBuilder userBuilder = new UserBuilder();
        User user = userBuilder.firstName("John").lastName("Jones").age(32).address("Road 24, Houston").build();
        System.out.println(user.toString());

        userBuilder = new UserBuilder();
        user = userBuilder.firstName("John").build();
    }
}
