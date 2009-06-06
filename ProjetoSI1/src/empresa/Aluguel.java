package empresa;

import interfaces.Alugavel;
import interfaces.Locatario;

/**
 * Classe que implementa o funcionamento de aluguel da empresa
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public class Aluguel {

	private String plate, email, init, end;
	private boolean situation = true;
	private String status = "active";
	private Alugavel alugavel;
	private Locatario locatario;

	/**
	 * Contrutor da classe Aluguel
	 *
	 * @param String
	 *            placa
	 * @param String
	 *            email
	 * @param String
	 *            inicio
	 * @param String
	 *            fim
	 */
	public Aluguel(String placa, String email, String inicio, String fim) {
		this.plate = placa;
		this.email = email;
		this.init = inicio;
		this.end = fim;

	}
	
	public Aluguel (Alugavel alugavel, Locatario locatario, String inicio, String fim){
		this.alugavel = alugavel;
		this.locatario = locatario;
		this.init = inicio;
		this.end = fim;
	}

	/**
	 * Metodo que retorna a placa do veiculo do aluguel
	 *
	 * @return String placa
	 */
	public String getPlate() {
		return this.plate;
	}

	/**
	 * Metodo que retorna o email do cliente do aluguel
	 *
	 * @return String email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Metodo que retorna a data de inicio do aluguel
	 *
	 * @return String data de inicio
	 */
	public String getInit() {
		return this.init;
	}

	/**
	 * Metodo que retorna a data do final do aluguel
	 *
	 * @return String data de termino
	 */
	public String getEnd() {
		return this.end;
	}

	/**
	 * Metodo que retorna o status do aluguel (se esta "active" ou "late")
	 *
	 * @return status do aluguel
	 */
	public String getStatus() {
		if (situation) {
			return status;
		} else {
			return "late";
		}
	}

	/**
	 * Metodo que altera o status do aluguel
	 */
	public void setStatus() {
		if (this.status == "active") {
			this.status = "late";
		} else
			this.status = "active";
	}

}
