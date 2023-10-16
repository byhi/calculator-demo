package hu.byhi.example.calculator;

import java.math.BigDecimal;

public interface Calculator {
	BigDecimal addition(BigDecimal x, BigDecimal y);
	BigDecimal subtraction(BigDecimal x, BigDecimal y);
	BigDecimal multiplication(BigDecimal x, BigDecimal y);
	BigDecimal division(BigDecimal x, BigDecimal y);
}
