package empresa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import util.ValidateInput;

import Pessoas.Cliente;
import Pessoas.Usuario;
import Veiculos.Veiculo;

import exception.AllParametersAreMandatoryException;
import exception.InvalidCharacterException;
import exception.RequiredFieldException;
import exception.InvalidParameterException;
import exception.EmptyDatabaseException;
import exception.AlreadyExistsException;
import exception.NotFoundException;

/**
 * Classe que implementa o funcionamento da empresa
 *
 * @author Niedja Roberta
 */
public class Empresa extends ValidateInput {

	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
	ArrayList<String[]> requisicoesPendentes = new ArrayList<String[]>();
	Map<String, Veiculo> veiculos = new HashMap<String, Veiculo>();
	//ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	/**
	 * Metodo que retorna a quantidade de usuarios da empresa
	 *
	 * @return usuarios.size()
	 */
	public int getAllUsers() {
		return usuarios.size();
	}

	/**
	 * Metodo que adiciona um novo usuario (funcionario) na empresa
	 *
	 * @param login
	 * @param name
	 * @param email
	 * @param phone
	 * @throws AlreadyExistsException 
	 * @throws InvalidCharacterException 
	 * @throws RequiredFieldException 
	 */
	public void addUser(String login, String name, String email, String phone) throws AlreadyExistsException, RequiredFieldException, InvalidCharacterException{
		ValidateUser(login, name, email, phone);

		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)
					|| usuario.getEmail().equals(email))
				throw new AlreadyExistsException("error: user already exists!");
		}

		Usuario newUser = new Usuario(login, name, email, phone);
		usuarios.add(newUser);
	}

	/**
	 * Metodo que remove um funcionario da empresa
	 *
	 * @param emailOrLogin
	 * @throws NotFoundException 
	 * @throws EmptyDatabaseException 
	 * @throws InvalidParameterException 
	 * @throws Exception
	 */
	public void removeUser(String emailOrLogin) throws NotFoundException, EmptyDatabaseException, InvalidParameterException{
		if (emailOrLogin == null || emailOrLogin.isEmpty())
			throw new InvalidParameterException("error: invalid parameter!");
		Usuario usuario = null;
		if (usuarios.size() == 0)
			throw new EmptyDatabaseException(
					"error: there is no users on database");
		for (Usuario user : usuarios) {
			if (user.getLogin().equals(emailOrLogin)
					|| user.getEmail().equals(emailOrLogin))
				usuario = user;
		}
		if (usuario == null)
			throw new NotFoundException("error: no such user!");
		else
			usuarios.remove(usuario);
	}

	/**
	 * Metodo que retorna a quantidade de clientes da empresa
	 *
	 * @return clientes.size()
	 */
	public int getAllCustomers() {
		return clientes.size();
	}

	/**
	 * Metodo que adiciona um cliente a empresa
	 *
	 * @param name
	 * @param email
	 * @param phone
	 * @throws InvalidCharacterException 
	 * @throws RequiredFieldException 
	 * @throws AlreadyExistsException 
	 * @throws Exception
	 */
	public void addCustomer(String name, String email, String phone) throws RequiredFieldException, InvalidCharacterException, AlreadyExistsException
		{
		ValidateCustomer(name, email, phone);

		for (Cliente cliente : clientes) {
			if (cliente.getName().equals(name)
					|| cliente.getEmail().equals(email))
				throw new AlreadyExistsException(
						"error: customer already exists!");
		}

		Cliente newClient = new Cliente(name, email, phone);
		clientes.add(newClient);
	}

	/**
	 * Metodo que remove um cliente da empresa
	 *
	 * @param email
	 * @throws InvalidParameterException 
	 * @throws EmptyDatabaseException 
	 * @throws NotFoundException 
	 * @throws Exception
	 */
	public void removeCustomer(String email) throws InvalidParameterException, EmptyDatabaseException, NotFoundException  {
		if (email == null || email.isEmpty())
			throw new InvalidParameterException("error: invalid parameter!");
		Cliente client1 = null;
		if (clientes.size() == 0)
			throw new EmptyDatabaseException(
					"error: there is no customers on database");
		for (Cliente client : clientes) {
			if (client.getEmail().equals(email))
				client1 = client;
		}
		if (client1 == null) {
			throw new NotFoundException("error: no such customer!");
		} else {
			clientes.remove(client1);
		}
	}

	public int getAllVehicles() {
		return veiculos.size();
	}

	/**
	 * Metodo para adicionar um veiculo a empresa
	 *
	 * @param tipo
	 * @param modelo
	 * @param cor
	 * @param placa
	 * @param ano
	 * @param preco
	 * @throws InvalidCharacterException 
	 * @throws RequiredFieldException 
	 * @throws AlreadyExistsException 
	 * @throws Exception
	 */
	public void addVehicle(String tipo, String modelo, String cor,
			String placa, String ano, String preco) throws RequiredFieldException, InvalidCharacterException, AlreadyExistsException {
		ValidateVehicle(tipo, modelo, cor, placa, ano, preco);

		double precoDouble = Double.parseDouble(preco);
		int anoInt = Integer.parseInt(ano);

		if (veiculos.containsKey(placa.toUpperCase()))
			throw new AlreadyExistsException(
					"error: this vehicle already exists!");
		Veiculo newVehicle = new Veiculo(tipo, modelo, cor, placa, anoInt,
				precoDouble);
		veiculos.put(placa.toUpperCase(), newVehicle);

	}

	/**
	 * Metodo para remover um veiculo da empresa
	 *
	 * @param placa
	 * @throws NoVehicleException
	 * @throws InvalidParameterException
	 * @throws NotFoundException
	 */
	public void removeVehicle(String placa) throws EmptyDatabaseException,
			InvalidParameterException, NotFoundException {
		if (getAllVehicles() == 0)
			throw new EmptyDatabaseException(
					"error: there is no vehicles on database");
		if ((placa != null && placa.isEmpty()) || placa == null)
			throw new InvalidParameterException("error: invalid parameter!");
		if (!veiculos.containsKey(placa.toUpperCase()))
			throw new NotFoundException("error: no such vehicle!");
		veiculos.remove(placa.toUpperCase());
	}

	public int getAllPendentRentRequests() {
		return requisicoesPendentes.size();
	}

	public void requestRent(String email, String placa)
			throws RequiredFieldException {
		if (email == null || email.isEmpty() || placa == null
				|| placa.isEmpty())
			throw new RequiredFieldException("error: all fields are mandatory!");
		String[] novaRequisicao = { email, placa };
		requisicoesPendentes.add(novaRequisicao);
	}
	
	/*public boolean existCustomer(String email){
		for (Usuario usuario : usuarios) {
			if ( usuario.getEmail().equals(email)){
				return true;
			}				
		}
		return false;		
	}*/
	
	public int getAllRents(){
		return alugueis.size();
	}
	
	public void addRent(String placa, String email, String inicio, String fim) throws Exception{
		if(placa==null||placa==""||email==null||email==""||inicio==null||inicio==""||fim==null||fim==""){
			throw new AllParametersAreMandatoryException("error: all parameters are mandatory!");
		}else{
			Aluguel a = new Aluguel(placa, email, inicio, fim);
			alugueis.add(a);
			veiculos.get(placa.toUpperCase()).setSituacao();
		}
	}
	
	public int getRentsByCustomer(String email){
		int contador = 0;
		for(int i=0; i<alugueis.size(); i++){
			if(alugueis.get(i).getEmail()==email){
				contador++;				
			}
		}
		return contador;
	}
	
	public int getRentsByVehicle(String placa){
		int contador = 0;
		for(int i=0; i<alugueis.size(); i++){
			if(alugueis.get(i).getPlate()==placa){
				contador++;				
			}
		}
		return contador;
	}
	
	public int getAllActiveRents(){
		int contador = 0;
		for(int i=0; i<alugueis.size(); i++){
			if(alugueis.get(i).getStatus()=="active"){
				contador++;			
			}
		}
		return contador;		
	}
	
	public String getVehicleSituation(String placa){
		return veiculos.get(placa.toUpperCase()).situacao();		
	}

}
