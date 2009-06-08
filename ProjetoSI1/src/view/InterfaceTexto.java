package view;

import exception.AlreadyExistsException;
import exception.EmptyDatabaseException;
import exception.InvalidCharacterException;
import exception.InvalidParameterException;
import exception.NotFoundException;
import exception.RequiredFieldException;
import facade.Controller;

public class InterfaceTexto {
	
	private Controller controller;
	
	public InterfaceTexto(){
		this.controller = Controller.getInstance();
	}
		
	
	public void cadastrarUsuario() {
		try {
			controller.cadastrarUsuario("login", "nome", "email", "phone");
		} catch (AlreadyExistsException e) {
			System.out.println(e.getMessage());
		} catch (RequiredFieldException e) {
			System.out.println(e.getMessage());
		} catch (InvalidCharacterException e) {
			System.out.println(e.getMessage());
		}
	}

	public void cadastrarCliente(){
		try {
			controller.cadastrarCliente("nome" , "email"," phone");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void cadastrarItem() {
		try {
			controller.cadastrarItem("tipo","modelo","cor","placa", "ano", "preco");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void registrarAluguel(){
		try {
			controller.registrarAluguel("placa", "email", "inicio", "fim");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void registrarAluguelAtrasado(){	
		try {
			controller.registrarAluguelAtrasado("plate", "email", "init", "end");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void registrarLiberacaoDoItem(){
		
	}
	
	public void registrarInteresseDoClienteNoItemAlugado(){
		try {
			controller.registrarInteresseDoClienteNoItemAlugado("email", "placa");
		} catch (RequiredFieldException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void registrarReservaDoItem(){
		
	}
	
	public void exibirRequisicoesDeAluguel(){
		
	}
	
	public void exibirSituacaoDoItem(){
		controller.ExibirSituacaoDoItem("placa");
	}
	
	public void exibirAlugueisVigentes(){
		
	}
	
	public void exibirAlugueisAtrasados(){
		
	}
	
	public void exibirVeiculosDisponiveis(){
		
	}
	
	public void excluirUsuario() {
		try {
			controller.excluirUsuario("email");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void excluirCliente(){
		try {
			controller.excluirCliente("email");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void excluirItem() {
		try {
			controller.excluirItem("placa");
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		} catch (InvalidParameterException e) {
			System.out.println(e.getMessage());
		} catch (EmptyDatabaseException e) {
			System.out.println(e.getMessage());
		}
	}

	
	

}
