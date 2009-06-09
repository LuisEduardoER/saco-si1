package view;

import interfaces.Listener;
import eventos.Evento;
import facade.Controller;

public class InterfaceMovel implements Listener {

	private Controller controller;
	
	
	public InterfaceMovel(){
		this.controller = Controller.getInstance();
	}
	
	public void registrarReservaDoItem(){
		
	}
	
	public void receberEvento(Evento e){
		System.out.println("Atualizando interface movel.");
	}
	
	
	
	
	
	
	
}
