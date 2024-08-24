package mus.exceptions.gameObjectsExceptions;

public class NoTienesCartaException extends RemoveCartaManoException {
	private static final long serialVersionUID = 1L;
	public NoTienesCartaException() {
		super(); 
	}
    public NoTienesCartaException(String message) {
        super(message);
    }
    public NoTienesCartaException(String message, Throwable cause){
    super(message, cause);
    }
}