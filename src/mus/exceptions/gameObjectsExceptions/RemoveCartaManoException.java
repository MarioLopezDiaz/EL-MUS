package mus.exceptions.gameObjectsExceptions;

public abstract class RemoveCartaManoException extends ManoException {
	private static final long serialVersionUID = 1L;
	public RemoveCartaManoException() {
		super(); 
	}
    public RemoveCartaManoException(String message) {
        super(message);
    }
    public RemoveCartaManoException(String message, Throwable cause){
    super(message, cause);
    }
}