package mus.exceptions;

public abstract class MusGameException extends Exception {
	private static final long serialVersionUID = -3237252888699341466L;
	public MusGameException() {
		super(); 
	}
	public MusGameException(String message) {
        super(message);
    }
    public MusGameException(String message, Throwable cause){
    super(message, cause);
    }
    
    public String toString() {
    	StringBuilder exception = new StringBuilder();
    	Throwable causa = this;
    	while(causa != null) {
    		exception.append(causa.getMessage()).append("\n");
    		causa = causa.getCause();
    	}
    	return exception.toString();
    }
}
