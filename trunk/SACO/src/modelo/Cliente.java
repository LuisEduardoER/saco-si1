package modelo;
public class Cliente implements Pessoa {

	private String nome;
	private String email;
	private String telefone;
	private String endereco;


	public Cliente(String nome, String email, String telefone) {

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;

	}

	public Cliente(String nome, String email, String endereco, String telefone) {

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setEmail(String email) {
		this.email = email;
		
		
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
		
	}

	

	
	
}
