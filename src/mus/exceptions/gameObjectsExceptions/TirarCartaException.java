package mus.exceptions.gameObjectsExceptions;

public class TirarCartaException extends JugadorException {
	private static final long serialVersionUID = 1L;
	public TirarCartaException() {
		super(); 
	}
    public TirarCartaException(String message) {
        super(message);
    }
    public TirarCartaException(String message, Throwable cause){
    super(message, cause);
    }
}