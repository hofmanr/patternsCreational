package com.pluralsight.abstractfactory.amex;

import com.pluralsight.abstractfactory.CardType;
import com.pluralsight.abstractfactory.CreditCard;
import com.pluralsight.abstractfactory.CreditCardFactory;
import com.pluralsight.abstractfactory.Validator;

public class AmexFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		
		switch (cardType) {
			case GOLD:
				return new AmexGoldCreditCard();
	
			case PLATINUM:
				return new AmexPlatinumCreditCard();	
				
			default:
				break;
		}
		
		return null;
	}

	@Override
	public Validator getValidator(CardType cardType) {
		
		switch (cardType) {
			case GOLD:
				
				return new AmexGoldValidator();
	
			case PLATINUM:
				
				return new AmexPlatinumValidator();	
		
		}
		
		return null;
	}
}
