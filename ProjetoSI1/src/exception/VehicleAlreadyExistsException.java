package exception;

public class VehicleAlreadyExistsException extends Exception {
	
	public VehicleAlreadyExistsException(String motivo){
		super(motivo);
	}

}