package Pessoas;

/**
 * 
 * @author Niedja Roberta
 */
public class Usuario implements Pessoa{
	
	private String name, email, phone, login;

	public Usuario(String login, String name, String email, String phone) {
		this.login = login;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLogin(){
		return login;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public void setLogin(String login){
		this.login = login;
	}

}
