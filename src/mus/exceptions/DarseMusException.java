package mus.exceptions;

public class DarseMusException extends CommandExecuteException {
	private static final long serialVersionUID = 1L;
	public DarseMusException() {
		super(); 
	}
    public DarseMusException(String message) {
        super(message);
    }
    public DarseMusException(String message, Throwable cause){
    super(message, cause);
    }
}