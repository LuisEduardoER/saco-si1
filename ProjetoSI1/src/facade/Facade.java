package facade;

import exception.EmptyDatabaseException;
import exception.InvalidParameterException;
import exception.NotFoundException;
import exception.RequiredFieldException;

public class Facade {

	private static Facade instance;

	public static Facade getInstance(){
		if(instance == null){
			instance = new Facade();
		}
		return instance;
	}


	private empresa.Empresa empresa = new empresa.Empresa();


	public int getAllUsers(){
		return empresa.getAllUsers();
	}

	public void addUser(String login, String name, String email, String phone) throws Exception{
			empresa.addUser(login, name, email, phone);
	}

	public void removeUser(String emailOrLogin) throws Exception{
		empresa.removeUser(emailOrLogin);
	}

	public int getAllCustomers(){
		return empresa.getAllCustomers();
	}

	public void addCustomer(String name, String email, String phone) throws Exception{
		empresa.addCustomer(name, email, phone);
	}

	public void removeCustomer(String email) throws Exception{
		empresa.removeCustomer(email);
	}

	public int getAllVehicles(){
		return empresa.getAllVehicles();
	}

	public void addVehicle(String tipo, String modelo, String cor, String placa, String ano, String preco) throws Exception{
		empresa.addVehicle(tipo, modelo, cor, placa, ano, preco);
	}

	public void removeVehicle(String placa) throws NotFoundException, InvalidParameterException, EmptyDatabaseException{
		empresa.removeVehicle(placa);
	}

	public int getAllPendentRentRequests(){
		return empresa.getAllPendentRentRequests();
	}

	public void requestRent(String email, String placa) throws RequiredFieldException{
		empresa.requestRent(email, placa);
	}
}
