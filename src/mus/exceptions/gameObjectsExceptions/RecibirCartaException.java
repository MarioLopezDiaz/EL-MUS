package mus.exceptions.gameObjectsExceptions;

public class RecibirCartaException extends JugadorException {
	private static final long serialVersionUID = 1L;
	public RecibirCartaException() {
		super(); 
	}
    public RecibirCartaException(String message) {
        super(message);
    }
    public RecibirCartaException(String message, Throwable cause){
    super(message, cause);
    }
}