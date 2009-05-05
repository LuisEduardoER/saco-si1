package Pessoas;

/**
 * Classe que implementa o cliente da empresa
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */

public class Cliente implements Pessoa {

	private String name, email, phone;

	/**
	 * Construtor da classe Cliente
	 *
	 * @param String
	 *            nome
	 * @param String
	 *            email
	 * @param String
	 *            telefone
	 */
	public Cliente(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * Metodo que retorna o email do cliente
	 *
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que retorna o nome do cliente
	 *
	 * @return String nome
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que retorna o telefone do cliente
	 *
	 * @return String telefone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Metodo que altera o email do cliente
	 *
	 * @param String
	 *            email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que altera o nome do cliente
	 *
	 * @param String
	 *            nome
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que altera o telefone do cliente
	 *
	 * @param String
	 *            telefone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
