package modelo;

import excecoes.CampoObrigatorioException;

public class Funcionario implements Pessoa {

	private String login;
	private String nome;
	private String email;
	private String telefone;

	public Funcionario(String login, String nome, String email, String telefone) throws CampoObrigatorioException {
		if(login == null || login.equals("")){
			throw new CampoObrigatorioException("error: login is a mandatory field!");
		}
		if(nome == null || nome.equals("")){
			throw new CampoObrigatorioException("error: name is a mandatory field!");
		}
		if(email == null || email.equals("")){
			throw new CampoObrigatorioException("error: e-mail is a mandatory field!");
		}
		if(telefone == null || telefone.equals("")){
			throw new CampoObrigatorioException("error: phone number is a mandatory field!");
		}
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;

	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}


	public void setEmail(String email) {
		this.email = email;
		
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
		
	}

	

}