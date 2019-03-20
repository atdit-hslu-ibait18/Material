
public class CalculationException extends Exception{
	public CalculationException(String message) {
        super(message);
    }

    public CalculationException(Throwable throwable) {
        super(throwable);
    }

    public CalculationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
