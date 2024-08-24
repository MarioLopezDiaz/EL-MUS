package mus.exceptions.gameObjectsExceptions;

public class NoExisteNumeroException extends CreacionCartaException {
	private static final long serialVersionUID = 1L;
	public NoExisteNumeroException() {
		super(); 
	}
    public NoExisteNumeroException(String message) {
        super(message);
    }
    public NoExisteNumeroException(String message, Throwable cause){
    super(message, cause);
    }
}