package view;

import facade.Controller;

public class InterfaceWeb {

	private Controller controller;
	
	public InterfaceWeb(){
		this.controller = Controller.getInstance();
	}
	
	public void registrarReservaDoItem(){
		
	}
	
	public void exibirVeiculosDisponiveis(){
		
	}
	
	
	public void cadastrarCliente(){
		try {
			controller.cadastrarCliente("name", "email", "phone");
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
	
	
}
