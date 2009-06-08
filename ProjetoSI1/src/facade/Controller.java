package facade;

import interfaces.Listener;

import java.util.ArrayList;
import java.util.Collection;

import view.InterfaceMovel;
import view.InterfaceTexto;
import view.InterfaceWeb;
import empresa.Empresa;
import exception.AlreadyExistsException;
import exception.EmptyDatabaseException;
import exception.InvalidCharacterException;
import exception.InvalidParameterException;
import exception.NotFoundException;
import exception.RequiredFieldException;

public class Controller {

	private Collection listeners;
	private InterfaceTexto interfaceTexto;
	private InterfaceWeb interfaceWeb;
	private InterfaceMovel interfaceMovel;
	private Empresa empresa;
	private static Controller me = null;
	
	protected Controller(){
		interfaceTexto = new InterfaceTexto();
		interfaceWeb = new InterfaceWeb();
		interfaceMovel = new InterfaceMovel();
		empresa = new Empresa();
		listeners = new ArrayList();
	}
	
	public synchronized static Controller getInstance(){
		if(me == null){
			me = new Controller();
		}
		return me;
	}
	
	public void addListener(Listener e){
		listeners.add(e);
	}
	
	public void atualizarVeiculosDisponiveisNasInterfaces(){
		
	}
	
	public void cadastrarUsuario(String login, String name, String email, String phone)
			throws AlreadyExistsException, RequiredFieldException,
			InvalidCharacterException {
		empresa.addUser(login, name, email, phone);
	}

	public void excluirUsuario(String emailOrLogin) throws Exception {
		empresa.removeUser(emailOrLogin);
	}

	public void cadastrarCliente(String name, String email, String phone)
			throws Exception {
		empresa.addCustomer(name, email, phone);
	}

	public void excluirCliente(String email) throws Exception {
		empresa.removeCustomer(email);
	}

	public void cadastrarItem(String tipo, String modelo, String cor,
			String placa, String ano, String preco) throws Exception {
		empresa.addVehicle(tipo, modelo, cor, placa, ano, preco);
	}

	public void excluirItem(String placa) throws NotFoundException,
			InvalidParameterException, EmptyDatabaseException {
		empresa.removeVehicle(placa);
	}

	public void registrarAluguel(String placa, String email, String inicio,
			String fim) throws Exception {
		empresa.addRent(placa, email, inicio, fim);
	}

	public String ExibirSituacaoDoItem(String placa) {
		return empresa.getVehicleSituation(placa);
	}

	public String ExibirSituacaoDoItem(String email, String placa, String inicio,
			String fim) {
		return empresa.getRentSituation(email, placa, inicio, fim);
	}

	
	public void registrarAluguelAtrasado(String plate, String email, String init,
			String end) throws Exception {
		empresa.registerLateRent(plate, email, init, end);
	}	
	
	public void registrarReservaDoItem(){
		
	}
	
	public void registrarLiberacaoDoItem(){
		
	}
	
	public void registrarInteresseDoClienteNoItemAlugado(String email, String placa) throws RequiredFieldException{
		empresa.requestRent(email, placa);
	}
	
	public void exibirRequisicoesDeAluguel(){
		
	}
	
	public void exibirVeiculosDisponiveis(){
		
	}
	
	public void exibirAlugueisVigentes(){
		
	}
	
	public void exibirAlugueisAtrasados(){
		
	}
	
	

	
	
}
