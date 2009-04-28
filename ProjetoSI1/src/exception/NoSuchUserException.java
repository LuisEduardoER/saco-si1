package exception;

public class NoSuchUserException extends Exception {
	
	public NoSuchUserException(String motivo){
		super(motivo);
	}

}
