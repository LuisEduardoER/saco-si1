package util;

import exception.InvalidCharacterException;
import exception.InvalidParameterException;
import exception.RequiredFieldException;
import java.util.GregorianCalendar;

/**
 * Classe responsavel por validar os inputs
 * 
 * @author Niedja Roberta
 * 
 */
public class ValidateInput {
	private static final int indexDia = 0;
	private static final int indexMes = 1;
	private static final int indexAno = 2;
	private static final int JANEIRO = 1;
	private static final int FEVEREIRO = 2;
	private static final int MARCO = 3;
	private static final int ABRIL = 4;
	private static final int MAIO = 5;
	private static final int JUNHO = 6;
	private static final int JULHO = 7;
	private static final int AGOSTO = 8;
	private static final int SETEMBRO = 9;
	private static final int OUTUBRO = 10;
	private static final int NOVEMBRO = 11;
	private static final int DEZEMBRO = 12;
	
	

	/**
	 * Valida os inputs do usuario
	 * 
	 * @param login
	 * @param name
	 * @param email
	 * @param phone
	 * @throws RequiredFieldException
	 * @throws InvalidCharacterException
	 */
	public static void validateUser(String login, String name, String email,
			String phone) throws RequiredFieldException,
			InvalidCharacterException {
		if ((login == null && phone == null && email == null && name == null)
				|| ((login != null && login.isEmpty()) && phone.isEmpty()
						&& email.isEmpty() && name.isEmpty()))
			throw new RequiredFieldException("error: all fields are mandatory!");
		if (login == null || login.isEmpty())
			throw new RequiredFieldException(
					"error: login is a mandatory field!");
		if (name == null || name.isEmpty())
			throw new RequiredFieldException(
					"error: name is a mandatory field!");
		if (email == null || email.isEmpty())
			throw new RequiredFieldException(
					"error: e-mail is a mandatory field!");
		if (phone == null || phone.isEmpty())
			throw new RequiredFieldException(
					"error: phone number is a mandatory field!");

		String[] dados = { name, login, email };

		for (String palavra : dados) {
			if (palavra.endsWith(".") || palavra.endsWith("_")
					|| palavra.endsWith("-") || palavra.endsWith("@")
					|| palavra.startsWith(".") || palavra.startsWith("_")
					|| palavra.startsWith("-") || palavra.startsWith("@"))
				throw new InvalidCharacterException("error: invalid field!");
		}

		if (phone.length() != 10)
			throw new InvalidCharacterException("error: invalid field!");

		for (int i = 0; i < phone.length(); i++) {
			if (!Character.isDigit(phone.charAt(i)))
				throw new InvalidCharacterException("error: invalid field!");
		}
	}

	/**
	 * Valida os inputs do cliente
	 * 
	 * @param name
	 * @param email
	 * @param phone
	 * @throws RequiredFieldException
	 * @throws InvalidCharacterException
	 */
	public static void validateCustomer(String name, String email, String phone)
			throws RequiredFieldException, InvalidCharacterException {
		if ((phone == null && email == null && name == null)
				|| ((phone != null && phone.isEmpty()) && email.isEmpty() && name
						.isEmpty()))
			throw new RequiredFieldException("error: all fields are mandatory!");
		if (name == null || name.isEmpty())
			throw new RequiredFieldException(
					"error: name is a mandatory field!");
		if (email == null || email.isEmpty())
			throw new RequiredFieldException(
					"error: e-mail is a mandatory field!");
		if (phone == null || phone.isEmpty())
			throw new RequiredFieldException(
					"error: phone number is a mandatory field!");

		String[] dados = { name, email };

		for (String palavra : dados) {
			if (palavra.endsWith(".") || palavra.endsWith("_")
					|| palavra.endsWith("-") || palavra.endsWith("@")
					|| palavra.startsWith(".") || palavra.startsWith("_")
					|| palavra.startsWith("-") || palavra.startsWith("@"))
				throw new InvalidCharacterException("error: invalid field!");
		}

		if (phone.length() != 10)
			throw new InvalidCharacterException("error: invalid field!");

		for (int i = 0; i < phone.length(); i++) {
			if (!Character.isDigit(phone.charAt(i)))
				throw new InvalidCharacterException("error: invalid field!");
		}
	}

	/**
	 * Valida os inputs do veiculo
	 * 
	 * @param tipo
	 * @param modelo
	 * @param cor
	 * @param placa
	 * @param ano
	 * @param preco
	 * @throws RequiredFieldException
	 * @throws InvalidCharacterException
	 */
	public static void validateVehicle(String tipo, String modelo, String cor,
			String placa, String ano, String preco)
			throws RequiredFieldException, InvalidCharacterException {
		if (tipo == null || tipo.isEmpty() || modelo == null
				|| modelo.isEmpty() || cor == null || cor.isEmpty()
				|| placa == null || placa.isEmpty() || ano == null
				|| ano.isEmpty() || preco == null || preco.isEmpty())
			throw new RequiredFieldException("error: all fields are mandatory!");

		double precoDouble = Double.parseDouble(preco);
		int anoInt = Integer.parseInt(ano);

		if (precoDouble <= 0 || anoInt <= 0 || placa.length() != 7)
			throw new InvalidCharacterException("error: invalid field!");

		String[] dados = { modelo, placa, tipo, cor };

		for (String dado : dados) {
			for (int i = 0; i < dado.length(); i++) {
				if (!Character.isLetterOrDigit(dado.charAt(i)))
					throw new InvalidCharacterException("error: invalid field!");
			}
		}

	}
	
	public static void validateAddRent(String placa, String email,
			String inicio, String fim) throws RequiredFieldException, InvalidCharacterException {
		if (placa == null || placa.isEmpty() || email == null
				|| email.isEmpty() || inicio == null || inicio.isEmpty()
				|| fim == null || fim.isEmpty()) {
			throw new RequiredFieldException("error: all parameters are mandatory!");
		}
		
		if (email.endsWith(".") || email.endsWith("_")
				|| email.endsWith("-") || email.endsWith("@")
				|| email.startsWith(".") || email.startsWith("_")
				|| email.startsWith("-") || email.startsWith("@"))
			throw new InvalidCharacterException("error: invalid parameter(s)");		

	}
	
	public static void validateDate(String stringData)throws InvalidParameterException{
		String[] arrayData = stringData.split("/");
		GregorianCalendar data = new GregorianCalendar(Integer.parseInt(arrayData[2]),Integer.parseInt(arrayData[1]),
				Integer.parseInt(arrayData[0]));
		if(!data.isLenient()){
			throw new InvalidParameterException("error: invalid parameter(s)");
		}		
	}
	
	public static void validateIntervalOfDates(String inicio, String fim) throws InvalidParameterException{
		String[] arrayDataInicio = inicio.split("/");
		String[] arrayDataFim = inicio.split("/");
		
		GregorianCalendar dataInicio = new GregorianCalendar(Integer.parseInt(arrayDataInicio[2]),
				Integer.parseInt(arrayDataInicio[1]),Integer.parseInt(arrayDataInicio[0]));
		GregorianCalendar dataFim = new GregorianCalendar(Integer.parseInt(arrayDataFim[2]),
				Integer.parseInt(arrayDataFim[1]),Integer.parseInt(arrayDataFim[0]));
		
		if(!dataInicio.before(dataFim)){
			throw new InvalidParameterException("error: invalid parameter(s)");
		}
		
	}
	
	
}
