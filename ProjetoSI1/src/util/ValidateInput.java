package util;

import exception.InvalidCharacterException;
import exception.RequiredFieldException;

/**
 * Classe responsavel por validar os inputs
 * @author Niedja Roberta
 *
 */
public class ValidateInput {

	/**
	 * Valida os inputs do usuario
	 * @param login
	 * @param name
	 * @param email
	 * @param phone
	 * @throws RequiredFieldException
	 * @throws InvalidCharacterException
	 */
	public void ValidateUser(String login, String name, String email, String phone) throws RequiredFieldException, InvalidCharacterException{
		if ((login == null && phone == null && email == null && name == null) ||
			     ((login != null && login.isEmpty()) && phone.isEmpty() && email.isEmpty() && name.isEmpty()))
			     throw new RequiredFieldException("error: all fields are mandatory!");
		if (login == null || login.isEmpty()) throw new RequiredFieldException("error: login is a mandatory field!");
		if (name == null || name.isEmpty()) throw new RequiredFieldException("error: name is a mandatory field!");
		if (email == null || email.isEmpty()) throw new RequiredFieldException("error: e-mail is a mandatory field!");
		if (phone == null || phone.isEmpty()) throw new RequiredFieldException("error: phone number is a mandatory field!");

		String[] dados = {name, login, email};

		for (String palavra : dados){
			if (palavra.endsWith(".") || palavra.endsWith("_") || palavra.endsWith("-") || palavra.endsWith("@") ||
				palavra.startsWith(".") || palavra.startsWith("_") || palavra.startsWith("-") || palavra.startsWith("@"))
				throw new InvalidCharacterException("error: invalid field!");
		}

		if(phone.length() != 10) throw new InvalidCharacterException("error: invalid field!");

		for (int i=0; i < phone.length() ; i++){
			if(!Character.isDigit(phone.charAt(i))) throw new InvalidCharacterException("error: invalid field!");
		}
	}

	/**
	 * Valida os inputs do cliente
	 * @param name
	 * @param email
	 * @param phone
	 * @throws RequiredFieldException
	 * @throws InvalidCharacterException
	 */
	public void ValidateCustomer(String name, String email, String phone) throws RequiredFieldException, InvalidCharacterException{
		if ((phone == null && email == null && name == null) ||
				((phone != null && phone.isEmpty()) && email.isEmpty() && name.isEmpty()))
				 throw new RequiredFieldException("error: all fields are mandatory!");
		if (name == null || name.isEmpty()) throw new RequiredFieldException("error: name is a mandatory field!");
		if (email == null || email.isEmpty()) throw new RequiredFieldException("error: e-mail is a mandatory field!");
		if (phone == null || phone.isEmpty()) throw new RequiredFieldException("error: phone number is a mandatory field!");

		String[] dados = {name, email};

		for (String palavra : dados){
			if (palavra.endsWith(".") || palavra.endsWith("_") || palavra.endsWith("-") || palavra.endsWith("@") ||
				palavra.startsWith(".") || palavra.startsWith("_") || palavra.startsWith("-") || palavra.startsWith("@"))
				throw new InvalidCharacterException("error: invalid field!");
		}

		if(phone.length() != 10) throw new InvalidCharacterException("error: invalid field!");

		for (int i=0; i < phone.length() ; i++){
			if(!Character.isDigit(phone.charAt(i))) throw new InvalidCharacterException("error: invalid field!");
		}
	}

	/**
	 * Valida os inputs do veiculo
	 * @param tipo
	 * @param modelo
	 * @param cor
	 * @param placa
	 * @param ano
	 * @param preco
	 * @throws RequiredFieldException
	 * @throws InvalidCharacterException
	 */
	public void ValidateVehicle(String tipo, String modelo, String cor, String placa, String ano, String preco) throws RequiredFieldException, InvalidCharacterException{
		if (tipo == null || tipo.isEmpty() || modelo == null || modelo.isEmpty() || cor == null || cor.isEmpty() || placa == null || placa.isEmpty() ||
			ano == null || ano.isEmpty() || preco == null || preco.isEmpty()) throw new RequiredFieldException("error: all fields are mandatory!");

		double precoDouble = Double.parseDouble(preco);
		int anoInt = Integer.parseInt(ano);

		if(precoDouble <= 0 || anoInt <= 0 || placa.length() != 7) throw new InvalidCharacterException("error: invalid field!");

		String[] dados = {modelo, placa, tipo, cor};

		for (String dado : dados){
			for(int i=0; i < dado.length() ; i++){
				if(!Character.isLetterOrDigit(dado.charAt(i))) throw new InvalidCharacterException("error: invalid field!");
		}
	}
	}
}
