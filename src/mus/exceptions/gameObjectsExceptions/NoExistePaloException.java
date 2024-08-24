package mus.exceptions.gameObjectsExceptions;

public class NoExistePaloException extends CreacionCartaException{
	private static final long serialVersionUID = 1L;
	public NoExistePaloException() {
		super(); 
	}
    public NoExistePaloException(String message) {
        super(message);
    }
    public NoExistePaloException(String message, Throwable cause){
    super(message, cause);
    }
}