package mus.exceptions.gameObjectsExceptions;

public class AddCartaManoException extends ManoException {
	private static final long serialVersionUID = 1L;
	public AddCartaManoException() {
		super(); 
	}
    public AddCartaManoException(String message) {
        super(message);
    }
    public AddCartaManoException(String message, Throwable cause){
    super(message, cause);
    }
}