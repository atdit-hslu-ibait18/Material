
public class OperationUnknownException extends Exception{
	public OperationUnknownException(String message) {
        super(message);
    }

    public OperationUnknownException(Throwable throwable) {
        super(throwable);
    }

    public OperationUnknownException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
