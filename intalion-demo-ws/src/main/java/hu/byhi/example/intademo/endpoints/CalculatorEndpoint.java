package hu.byhi.example.intademo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import demo_gen.CalculationResult;
import demo_gen.GetCalculationRequest;
import demo_gen.GetCalculationResponse;
import hu.byhi.example.calculator.BaseCalculator;
import hu.byhi.example.intademo.service.CalculatorService;

@Endpoint
public class CalculatorEndpoint {

	private static final String NAMESPACE_URI = "demo-gen";
	
	CalculatorService calculatorService;
	
   

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCalculationRequest")
    @ResponsePayload
    public GetCalculationResponse getCalculation(@RequestPayload GetCalculationRequest request) {
    	GetCalculationResponse response = new GetCalculationResponse();
    	CalculationResult calculationResult = new CalculationResult();
    	
    	calculationResult = calculatorService.calculateByRequest(request);
        response.setCalculation(calculationResult);

        return response;
    }
    
    @Autowired
    private void setCalculatorService(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
}
