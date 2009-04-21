package modelo;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.Name;

import excecoes.CampoInvalidoException;
import excecoes.CampoObrigatorioException;

public class Funcionario implements Pessoa {

	private String login;
	private String nome;
	private String email;
	private String telefone;
	private int NUM_DIGITOS_FONE = 10;

	public Funcionario(String login, String nome, String email, String telefone) throws CampoObrigatorioException, CampoInvalidoException {
		
		//tratando argumentos nulos
		
		if (login == null && nome == null && email == null && telefone == null){
			throw new CampoObrigatorioException("error: all fields are mandatory!");
		}
		
		if (login == null){
			throw new CampoObrigatorioException("error: login is a mandatory field!");
		}
		
		
		if(nome == null){
			throw new CampoObrigatorioException("error: name is a mandatory field!");
		}
		
		if(email == null){
			throw new CampoObrigatorioException("error: e-mail is a mandatory field!");
		}
		
		if(telefone == null){
			throw new CampoObrigatorioException("error: phone number is a mandatory field!");
		}
		
		//tratando argumentos vazios
		
		if (login.equals("") & nome.equals("") & email.equals("") & telefone.equals("")){
			throw new CampoObrigatorioException("error: all fields are mandatory!"); 
		}
		
		if(login.equals("")){
			throw new CampoObrigatorioException("error: login is a mandatory field!");
		}
		if(nome.equals("")){
			throw new CampoObrigatorioException("error: name is a mandatory field!");
		}
		if(email.equals("")){
			throw new CampoObrigatorioException("error: e-mail is a mandatory field!");
		}
		if(telefone.equals("")){
			throw new CampoObrigatorioException("error: phone number is a mandatory field!");
		}
		
		//tratando login invalido
		
		if ( login.charAt(0)== '-' || login.charAt(0)== '_' || login.charAt(0)== '.'){
			throw new CampoInvalidoException("error: invalid field!");
		}
		
		if ( login.charAt(login.length()-1) == '-' || login.charAt(login.length()-1) == '_' || login.charAt(login.length()-1) == '.'){
			throw new CampoInvalidoException("error: invalid field!");
		}
		
		if (login.contains("@")){
			throw new CampoInvalidoException("error: invalid field!");
		}
		
		//tratando nome invalido
		
		if ( nome.charAt(0)== '-' || nome.charAt(0)== '_' || nome.charAt(0)== '.'){
			throw new CampoInvalidoException("error: invalid field!");
		}
		
		if ( nome.charAt(nome.length()-1) == '-' || nome.charAt(nome.length()-1) == '_' || nome.charAt(nome.length()-1) == '.'){
			throw new CampoInvalidoException("error: invalid field!");
		}
		
		if (nome.contains("@")){
			throw new CampoInvalidoException("error: invalid field!");
		}
		
		//tratando email invalido
		
		if ( email.charAt(0)== '-' || email.charAt(0)== '_' || email.charAt(0)== '.'){
			throw new CampoInvalidoException("error: invalid field!");
		}
		
		if ( email.charAt(email.length()-1) == '-' || email.charAt(email.length()-1) == '_' || email.charAt(email.length()-1) == '.'){
			throw new CampoInvalidoException("error: invalid field!");
		}
		
		//tratando telefone invalido
		
		
		if (!telefone.matches("[0-9]{10}")){
			throw new CampoInvalidoException("error: invalid field!");
		}
		
		
		
		this.login = login;		
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