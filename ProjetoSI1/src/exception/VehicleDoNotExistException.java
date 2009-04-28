package exception;

public class VehicleDoNotExistException extends Exception {
	
	public VehicleDoNotExistException(String motivo){
		super(motivo);
	}

}
