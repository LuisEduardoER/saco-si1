package empresa;

import java.util.ArrayList;

import listas.Alugueis;
import listas.Clientes;
import listas.Usuarios;
import listas.Veiculos;

import persistencia.FachadaPersistencia;
import util.ValidateInput;
import Email.EmailGMAIL;
import Pessoas.Cliente;
import Pessoas.Usuario;
import Veiculos.Veiculo;
import exception.AlreadyExistsException;
import exception.EmptyDatabaseException;
import exception.InvalidCharacterException;
import exception.InvalidParameterException;
import exception.NoVehicleException;
import exception.NotFoundException;
import exception.RequiredFieldException;

/**
 * Classe que implementa o funcionamento da empresa
 * 
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public class Empresa {

	Usuarios usuarios;
	Clientes clientes;
	Alugueis alugueis;
	ArrayList<String[]> requisicoesPendentes;
	Veiculos veiculos;
	FachadaPersistencia persistencia;

	/**
	 * Construtor da classe Empresa
	 */
	public Empresa() {
		persistencia = FachadaPersistencia.getInstance();
		usuarios = (Usuarios) persistencia.getUserList();
		clientes = (Clientes) persistencia.getClientList();
		alugueis = (Alugueis) persistencia.getRents();
		requisicoesPendentes = (ArrayList<String[]>) persistencia
				.getPendentsRequests();
		veiculos = (Veiculos) persistencia.getVehicles();
		//
		// usuarios = new ArrayList<Usuario>();
		// clientes = new ArrayList<Cliente>();
		// alugueis = new ArrayList<Aluguel>();
		// requisicoesPendentes = new ArrayList<String[]>();
		// veiculos = new HashMap<String, Veiculo>();

	}

	/**
	 * Metodo que retorna a quantidade de usuarios da empresa
	 * 
	 * @return int quantidade de usuários
	 */
	public int getAllUsers() {
		return usuarios.size();
	}

	/**
	 * Metodo que adiciona um novo usuario (funcionario) na empresa
	 * 
	 * @param String
	 *            login
	 * @param String
	 *            name
	 * @param String
	 *            email
	 * @param String
	 *            phone
	 * @throws AlreadyExistsException
	 * @throws InvalidCharacterException
	 * @throws RequiredFieldException
	 */
	public void addUser(String login, String name, String email, String phone)
			throws AlreadyExistsException, RequiredFieldException,
			InvalidCharacterException {
		ValidateInput.validateUser(login, name, email, phone);

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
	 * @param String
	 *            emailOrLogin
	 * @throws NotFoundException
	 * @throws EmptyDatabaseException
	 * @throws InvalidParameterException
	 * @throws Exception
	 */
	public void removeUser(String emailOrLogin) throws NotFoundException,
			EmptyDatabaseException, InvalidParameterException {
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
	 * @return int quantidade de clientes
	 */
	public int getAllCustomers() {
		return clientes.size();
	}

	/**
	 * Metodo que adiciona um cliente a empresa
	 * 
	 * @param String
	 *            name
	 * @param String
	 *            email
	 * @param String
	 *            phone
	 * @throws InvalidCharacterException
	 * @throws RequiredFieldException
	 * @throws AlreadyExistsException
	 * @throws Exception
	 */
	public void addCustomer(String name, String email, String phone)
			throws RequiredFieldException, InvalidCharacterException,
			AlreadyExistsException {
		ValidateInput.validateCustomer(name, email, phone);

		for (Cliente cliente : clientes) {
			if (cliente.getName().equals(name)
					|| cliente.getEmail().equals(email))
				throw new AlreadyExistsException(
						"error: customer already exists!");
		}

		Cliente newClient = new Cliente(name, email, phone);
		clientes.add(newClient);
	}

	// Procurar um cliente na lista de clientes
	/**
	 * Metodo que verifica se alguém já é cliente
	 * 
	 * @param String
	 *            email
	 * @return boolean
	 */
	public boolean isACostumer(String email) {
		for (Cliente cliente : clientes) {
			if (cliente.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que procura um aluguel
	 * 
	 * @param String
	 *            email
	 * 
	 * @return Aluguel aluguel
	 */
	public Aluguel findRent(String email) {
		for (Aluguel aluguel : alugueis) {
			if (aluguel.getEmail().equals(email)) {
				return aluguel;
			}
		}
		return null;
	}

	/**
	 * Metodo que remove um cliente da empresa
	 * 
	 * @param String
	 *            email
	 * 
	 * @throws InvalidParameterException
	 * @throws EmptyDatabaseException
	 * @throws NotFoundException
	 * @throws Exception
	 */
	public void removeCustomer(String email) throws InvalidParameterException,
			EmptyDatabaseException, NotFoundException {
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

	/**
	 * Metodo que retorna a quantidade de veiculos da empresa
	 * 
	 * @return int quantidade de veiculos
	 * 
	 */
	public int getAllVehicles() {
		return veiculos.size();
	}

	/**
	 * Metodo para adicionar um veiculo a empresa
	 * 
	 * @param String
	 *            tipo
	 * @param String
	 *            modelo
	 * @param String
	 *            cor
	 * @param String
	 *            placa
	 * @param String
	 *            ano
	 * @param String
	 *            preco
	 * @throws InvalidCharacterException
	 * @throws RequiredFieldException
	 * @throws AlreadyExistsException
	 * @throws Exception
	 */
	public void addVehicle(String tipo, String modelo, String cor,
			String placa, String ano, String preco)
			throws RequiredFieldException, InvalidCharacterException,
			AlreadyExistsException {
		ValidateInput.validateVehicle(tipo, modelo, cor, placa, ano, preco);

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

	/**
	 * Metodo que retorna as requisicoes de alugueis pendentes
	 * 
	 * @return int quantidade de requisicoes pendentes
	 */
	public int getAllPendentRentRequests() {
		return requisicoesPendentes.size();
	}

	/**
	 * Metodo que faz a requisicao de um aluguel
	 * 
	 * @param String
	 *            email
	 * @param String
	 *            placa
	 * 
	 */
	public void requestRent(String email, String placa)
			throws RequiredFieldException {
		if (email == null || email.isEmpty() || placa == null
				|| placa.isEmpty())
			throw new RequiredFieldException("error: all fields are mandatory!");
		String[] novaRequisicao = { email, placa };
		requisicoesPendentes.add(novaRequisicao);
	}

	/**
	 * Metodo que retorna a quantidade de alugueis
	 * 
	 * @return int quantidade de alugueis
	 */
	public int getAllRents() {
		return alugueis.size();
	}

	/**
	 * Metodo que adiciona um alguel e altera a situacao do veiculo
	 * 
	 * @param String
	 *            placa
	 * @param String
	 *            email
	 * @param String
	 *            inicio
	 * @param String
	 *            fim
	 * @throws RequiredFieldException
	 * @throws InvalidCharacterException
	 * @throws InvalidParameterException
	 */
	public void addRent(String placa, String email, String inicio, String fim)
			throws RequiredFieldException, InvalidCharacterException,
			InvalidParameterException {

		ValidateInput.validateAddRent(placa, email, inicio, fim);

		Aluguel a = new Aluguel(placa, email, inicio, fim);
		alugueis.add(a);
		veiculos.get(placa.toUpperCase()).setSituacao();

	}

	/**
	 * Metodo que retorna a quantidade de alugueis feitos por cliente
	 * 
	 * @param String
	 *            email
	 * 
	 * @return int quantidade de alugueis por cliente
	 */
	public int getRentsByCustomer(String email) {
		int contador = 0;
		for (int i = 0; i < alugueis.size(); i++) {
			if (alugueis.get(i).getEmail().equals(email)) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Metodo que retorna a quantidade de alugueis por veiculo
	 * 
	 * @param String
	 *            email
	 * 
	 * @return int quantidade de alugueis por veiculo
	 */
	public int getRentsByVehicle(String placa) {
		int contador = 0;
		for (int i = 0; i < alugueis.size(); i++) {
			if (alugueis.get(i).getPlate().toUpperCase().equals(placa)) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Metodo que retorna a quantidade de alugueis ativos
	 * 
	 * @return quantidade de alugueis ativos
	 */
	public int getAllActiveRents() {
		int contador = 0;
		for (int i = 0; i < alugueis.size(); i++) {
			if (alugueis.get(i).getStatus().equals("active")) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Metodo que retorna a situacao do veiculo (se ele esta "unavailable" ou
	 * "available"
	 * 
	 * @param String
	 *            placa
	 * @return situacao do veiculo
	 */
	public String getVehicleSituation(String placa) {
		return veiculos.get(placa.toUpperCase()).situacao();
	}

	/**
	 * Metodo que retorna a situacao do aluguel (se esta "late" ou "ative")
	 * 
	 * @param String
	 *            email
	 * @param String
	 *            placa
	 * @param String
	 *            inicio
	 * @param String
	 *            fim
	 * @return status do aluguel
	 */
	public String getRentSituation(String email, String placa, String inicio,
			String fim) {
		return findRent(email).getStatus();
	}

	/**
	 * Metodo que muda a situacao do veiculo se ele for alugado e remove o
	 * veiculo dos alugueis
	 * 
	 * @param String
	 *            placa
	 * @return boolean
	 */
	public boolean releaseVehicle(String plate) {

		if (veiculos.get(plate.toUpperCase()).situacao() == "unavailable") {
			veiculos.get(plate.toUpperCase()).setSituacao();
			alugueis.remove(veiculos.get(plate.toUpperCase()));
			return true;
		}

		return true;
	}

	/**
	 * Metodo que registra um aluguel atrasado
	 * 
	 * @param String
	 *            placa
	 * @param String
	 *            email
	 * @param String
	 *            inicio
	 * @param String
	 *            fim
	 * @throws Exception
	 */
	public void registerLateRent(String plate, String email, String init,
			String end) throws Exception {

		Aluguel aluguel = findRent(email);
		if (aluguel.getEnd().compareToIgnoreCase(end) == -1) {
			throw new Exception("error: end date is greater than today date!");
		} else
			EmailGMAIL.enviarEmailPeloGmail("sacogrupo6@gmail.com", "ronaldo123", email, "Informacao de Atraso de Aluguel",
					"Informamos que voce esta com um aluguel atrasado em nosso sistema!");
			findRent(email).setStatus();

	}

	/**
	 * Metodo que limpa o banco de dados
	 * 
	 * */
	public void cleanDB() {
		usuarios.clear();
		clientes.clear();
		requisicoesPendentes.clear();
		alugueis.clear();
		veiculos.clear();
		persistencia.persisteTudo();
	}

	/**
	 * Metodo que persiste os dados
	 * */
	public void persiste() {
		persistencia.persisteTudo();

	}
}
