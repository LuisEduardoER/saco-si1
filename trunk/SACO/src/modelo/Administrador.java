package modelo;

public class Administrador implements Pessoa {

	private String nome;
	private String email;
	private String telefone;

	public Administrador(String nome, String email, String telefone) {

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