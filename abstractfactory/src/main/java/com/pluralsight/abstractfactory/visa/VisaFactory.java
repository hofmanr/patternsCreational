package com.pluralsight.abstractfactory.visa;

import com.pluralsight.abstractfactory.CardType;
import com.pluralsight.abstractfactory.CreditCard;
import com.pluralsight.abstractfactory.CreditCardFactory;
import com.pluralsight.abstractfactory.Validator;

public class VisaFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
			case GOLD:
				
				return new VisaGoldCreditCard();
	
			case PLATINUM:
				
				return new VisaBlackCreditCard();	
			
		}
		
		return null;
	}

	@Override
	public Validator getValidator(CardType cardType) {
		return new VisaValidator();
	}

}
