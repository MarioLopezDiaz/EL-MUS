package mus.exceptions;

public class RepartirCartaException extends CommandExecuteException {
	private static final long serialVersionUID = 1L;
	public RepartirCartaException() {
		super(); 
	}
    public RepartirCartaException(String message) {
        super(message);
    }
    public RepartirCartaException(String message, Throwable cause){
    super(message, cause);
    }
}