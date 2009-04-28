package exception;

public class EmptyDatabaseException extends Exception {
	
	public EmptyDatabaseException(String motivo){
		super(motivo);
	}

}
