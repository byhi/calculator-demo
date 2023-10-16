package hu.byhi.example.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseCalculator implements Calculator{

	@Override
	public BigDecimal addition(BigDecimal x, BigDecimal y) {
		return x.add(y);
	}

	@Override
	public BigDecimal subtraction(BigDecimal x, BigDecimal y) {
		return x.subtract(y);
	}

	@Override
	public BigDecimal multiplication(BigDecimal x, BigDecimal y) {
		return x.multiply(y);
	}

	@Override
	public BigDecimal division(BigDecimal x, BigDecimal y) {
		return x.divide(y, 2, RoundingMode.HALF_EVEN);
	}

	
}
