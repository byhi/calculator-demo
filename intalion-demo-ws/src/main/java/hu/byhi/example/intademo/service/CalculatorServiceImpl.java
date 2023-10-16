package hu.byhi.example.intademo.service;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import demo_gen.CalculationResult;
import demo_gen.GetCalculationRequest;
import demo_gen.Operation;
import hu.byhi.example.calculator.BaseCalculator;
import hu.byhi.example.intademo.common.CalculationFail;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public CalculationResult calculateByRequest(GetCalculationRequest request) {
		CalculationResult calculationResult = new CalculationResult();
		BaseCalculator calculator = new BaseCalculator();
		Operation operta = request.getOperationType();
		
		try {
			checkArgs(request);
			
			switch (operta) {
			case ADDITION: 
				calculationResult.setResult(calculator.addition(request.getXParapm(), request.getYParapm()));
				break;			
			case SUBTRACTION: 
				calculationResult.setResult(calculator.subtraction(request.getXParapm(), request.getYParapm()));
				break;
			case MULTIPLICATION: 
				calculationResult.setResult(calculator.multiplication(request.getXParapm(), request.getYParapm()));
				break;
			case DIVISION: 
				calculationResult.setResult(calculator.division(request.getXParapm(), request.getYParapm()));
				break;
			}
		} catch (ArithmeticException e) {
			e.printStackTrace();
			calculationResult.setErrorCode(CalculationFail.E0004.toString());
			calculationResult.setErrorMessage(CalculationFail.E0004.message);
		} catch (NullPointerException e) {
			e.printStackTrace();
			calculationResult.setErrorCode(CalculationFail.E0003.toString());
			calculationResult.setErrorMessage(CalculationFail.E0003.message);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			calculationResult.setErrorCode(CalculationFail.E0001.toString());
			calculationResult.setErrorMessage(CalculationFail.E0001.message);
		} catch (Exception e) {
			e.printStackTrace();
			calculationResult.setErrorCode(CalculationFail.E0002.toString());
			calculationResult.setErrorMessage(CalculationFail.E0002.message);
		}

		return calculationResult;
	}

	private void checkArgs(GetCalculationRequest request) {
		
		
		if (Objects.isNull(request.getXParapm())) {
			throw new NullPointerException("X Param is null");
		}
		
		if (Objects.isNull(request.getYParapm())) {
			throw new NullPointerException("Y Param is null");
		}
		
		if (Objects.isNull(request.getYParapm())) {
			throw new NullPointerException("Y Param is null");
		}
		
		if (Objects.isNull(request.getOperationType())) {
			throw new IllegalStateException("OperationType is null");
		}	
	}

}
