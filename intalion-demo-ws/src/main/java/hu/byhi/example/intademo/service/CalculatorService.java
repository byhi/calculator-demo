package hu.byhi.example.intademo.service;

import demo_gen.CalculationResult;
import demo_gen.GetCalculationRequest;

public interface CalculatorService {

	CalculationResult calculateByRequest(GetCalculationRequest request);

}
