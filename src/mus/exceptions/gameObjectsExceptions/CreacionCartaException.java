package mus.exceptions.gameObjectsExceptions;

public class CreacionCartaException extends GameObjectException {
	private static final long serialVersionUID = 1L;
	public CreacionCartaException() {
		super(); 
	}
    public CreacionCartaException(String message) {
        super(message);
    }
    public CreacionCartaException(String message, Throwable cause){
    super(message, cause);
    }
}