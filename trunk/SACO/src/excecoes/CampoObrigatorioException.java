package excecoes;

public class CampoObrigatorioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CampoObrigatorioException(String motivo){
		super(motivo);
	}

}
