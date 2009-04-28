package Pessoas;

/**
 *
 * @author Niedja Roberta
 *
 */
public class Cliente implements Pessoa{

	private String name, email, phone;

	public Cliente (String name, String email, String phone){
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
