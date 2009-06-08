package view;

import facade.Controller;

public class InterfaceWeb {

	private Controller controller;
	
	public InterfaceWeb(){
		this.controller = Controller.getInstance();
	}
	
	public void registrarReservaDoItem(){
		//fazer no controller
	}
	
	public void exibirVeiculosDisponiveis(){
		
	}
	
	public void notificarClienteDoItemLiberado(){
		
	}
	
	public void notificarClienteComAluguelAtrasado(){
		
	}
	
	public void notificarClienteComReservaDescartada(){
		
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
