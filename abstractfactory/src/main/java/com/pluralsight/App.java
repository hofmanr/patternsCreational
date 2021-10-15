package com.pluralsight;

import com.pluralsight.abstractfactory.CardType;
import com.pluralsight.abstractfactory.CreditCard;
import com.pluralsight.abstractfactory.CreditCardFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);

        CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);

        System.out.println(card.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(600);

        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);

        System.out.println(card2.getClass());
    }
}
