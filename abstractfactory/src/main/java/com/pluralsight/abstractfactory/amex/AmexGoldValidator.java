package com.pluralsight.abstractfactory.amex;

import com.pluralsight.abstractfactory.CreditCard;
import com.pluralsight.abstractfactory.Validator;

public class AmexGoldValidator implements Validator {

	@Override
	public boolean isValid(CreditCard creditCard) {
		
		return false;
	}

}
