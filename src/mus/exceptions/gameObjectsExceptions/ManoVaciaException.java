package mus.exceptions.gameObjectsExceptions;

public class ManoVaciaException extends RemoveCartaManoException {
	private static final long serialVersionUID = 1L;
	public ManoVaciaException() {
		super(); 
	}
    public ManoVaciaException(String message) {
        super(message);
    }
    public ManoVaciaException(String message, Throwable cause){
    super(message, cause);
    }
}