package com.pluralsight.abstractfactory;

import com.pluralsight.abstractfactory.amex.AmexFactory;
import com.pluralsight.abstractfactory.visa.VisaFactory;

//AbstractFactory
public abstract class CreditCardFactory {

	public static CreditCardFactory getCreditCardFactory(int creditScore) {
	
		if(creditScore > 650) {
			return new AmexFactory();
		}
		else {
			return new VisaFactory();
		}
	}
	
	public abstract CreditCard getCreditCard(CardType cardType);
		
	public abstract Validator getValidator(CardType cardType);
}
