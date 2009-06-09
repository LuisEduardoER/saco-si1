package view;

import interfaces.Listener;
import eventos.Evento;
import facade.Controller;

public class InterfaceWeb implements Listener{

	private Controller controller;
	
	public InterfaceWeb(){
		this.controller = Controller.getInstance();
	}
	
	public void registrarReservaDoItem(){
		
	}
	
	public void receberEvento(Evento e){
		System.out.println("Atualizando interface web");
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
