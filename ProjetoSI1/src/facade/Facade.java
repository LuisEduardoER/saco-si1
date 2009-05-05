package facade;

//import exception.AllParametersAreMandatoryException;
import exception.AlreadyExistsException;
import exception.EmptyDatabaseException;
import exception.InvalidCharacterException;
import exception.InvalidParameterException;
import exception.NotFoundException;
import exception.RequiredFieldException;

public class Facade {

	private static Facade instance;

	public static Facade getInstance() {
		if (instance == null) {
			instance = new Facade();
		}
		return instance;
	}

	private empresa.Empresa empresa = new empresa.Empresa();

	public int getAllUsers() {
		return empresa.getAllUsers();
	}

	public void addUser(String login, String name, String email, String phone)
			throws AlreadyExistsException, RequiredFieldException,
			InvalidCharacterException {
		empresa.addUser(login, name, email, phone);
	}

	public void removeUser(String emailOrLogin) throws Exception {
		empresa.removeUser(emailOrLogin);
	}

	public int getAllCustomers() {
		return empresa.getAllCustomers();
	}

	public void addCustomer(String name, String email, String phone)
			throws Exception {
		empresa.addCustomer(name, email, phone);
	}

	public void removeCustomer(String email) throws Exception {
		empresa.removeCustomer(email);
	}

	public int getAllVehicles() {
		return empresa.getAllVehicles();
	}

	public void addVehicle(String tipo, String modelo, String cor,
			String placa, String ano, String preco) throws Exception {
		empresa.addVehicle(tipo, modelo, cor, placa, ano, preco);
	}

	public void removeVehicle(String placa) throws NotFoundException,
			InvalidParameterException, EmptyDatabaseException {
		empresa.removeVehicle(placa);
	}

	public int getAllPendentRentRequests() {
		return empresa.getAllPendentRentRequests();
	}

	public void requestRent(String email, String placa)
			throws RequiredFieldException {
		empresa.requestRent(email, placa);
	}

	public int getAllRents() {
		return empresa.getAllRents();
	}

	public void registerRent(String placa, String email, String inicio,
			String fim) throws Exception {
		empresa.addRent(placa, email, inicio, fim);
	}

	public int getRentsByCustomer(String email) {
		return empresa.getRentsByCustomer(email);
	}

	public int getRentsByVehicle(String placa) {
		return empresa.getRentsByVehicle(placa);
	}

	public int getAllActiveRents() {
		return empresa.getAllActiveRents();
	}

	public String getVehicleSituation(String placa) {
		return empresa.getVehicleSituation(placa);
	}

	public String getRentSituation(String email, String placa, String inicio,
			String fim) {
		return empresa.getRentSituation(email, placa, inicio, fim);
	}

	public boolean releaseVehicle(String plate) {
		return empresa.releaseVehicle(plate);
	}

	public void registerLateRent(String plate, String email, String init,
			String end) throws Exception {
		empresa.registerLateRent(plate, email, init, end);
	}
}
