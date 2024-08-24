package mus.exceptions.gameObjectsExceptions;

public class ManoException extends GameObjectException {
	private static final long serialVersionUID = 1L;
	public ManoException() {
		super(); 
	}
    public ManoException(String message) {
        super(message);
    }
    public ManoException(String message, Throwable cause){
    super(message, cause);
    }
}