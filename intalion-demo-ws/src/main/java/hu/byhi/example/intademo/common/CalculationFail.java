package hu.byhi.example.intademo.common;

public enum CalculationFail {
	E0001("Unknow operation type"), 
	E0002("Unexpected state"),
	E0003("Value is null"), 
	E0004("Division with null");

	public final String message;

	private CalculationFail(String message) {
		this.message = message;
	}
}
