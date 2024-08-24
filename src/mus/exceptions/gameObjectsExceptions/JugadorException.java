package mus.exceptions.gameObjectsExceptions;

public class JugadorException extends GameObjectException {
	private static final long serialVersionUID = 1L;
	public JugadorException() {
		super(); 
	}
    public JugadorException(String message) {
        super(message);
    }
    public JugadorException(String message, Throwable cause){
    super(message, cause);
    }
}