package mus.exceptions.gameObjectsExceptions;

public class GameObjectException extends Exception {
	private static final long serialVersionUID = 1L;
	public GameObjectException() {
		super(); 
	}
    public GameObjectException(String message) {
        super(message);
    }
    public GameObjectException(String message, Throwable cause){
    super(message, cause);
    }
}