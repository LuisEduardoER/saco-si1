package Pessoas;

import interfaces.Locatario;

/**
 * Classe que implementa o usuario do sistema da empresa
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */

public class Usuario implements Pessoa, Locatario {

	private String name, email, phone, login;

	/**
	 * Construtor da classe Usuario
	 *
	 * @param String
	 *            login
	 * @param String
	 *            nome
	 * @param String
	 *            email
	 * @param String
	 *            telefone
	 */
	public Usuario(String login, String name, String email, String phone) {
		this.login = login;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * Metodo que retorna o nome do usuario
	 *
	 * @return String nome
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo que retorna o login do usuario
	 *
	 * @return String login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Metodo que retorna o telefone do usuario
	 *
	 * @return String telefone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Metodo que retorna o email do usuario
	 *
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que altera o nome do usuario
	 *
	 * @param String
	 *            nome
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo que altera o email do usuario
	 *
	 * @param String
	 *            email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que altera o telefone do usuario
	 *
	 * @param String
	 *            telefone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Metodo que altera o login do usuario
	 *
	 * @param String
	 *            login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

}
