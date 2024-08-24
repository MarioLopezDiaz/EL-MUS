package mus.exceptions;

public abstract class CommandExecuteException extends MusGameException {
	private static final long serialVersionUID = 1L;
	public CommandExecuteException() {
		super(); 
	}
    public CommandExecuteException(String message) {
        super(message);
    }
    public CommandExecuteException(String message, Throwable cause){
    super(message, cause);
    }
}