package exception;

public class UserAlreadyExistsException extends Exception {
	
	public UserAlreadyExistsException(String motivo){
		super(motivo);
	}

}
