package excecoes;

public class CampoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CampoInvalidoException(String motivo) {
		super(motivo);
	}

}
