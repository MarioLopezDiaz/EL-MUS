package mus.exceptions;

public class CommandParseException extends MusGameException {
	private static final long serialVersionUID = -3237252888699341466L;
	public CommandParseException() {
		super(); 
	}
	public CommandParseException(String message) {
        super(message);
    }
    public CommandParseException(String message, Throwable cause){
    super(message, cause);
    }
}