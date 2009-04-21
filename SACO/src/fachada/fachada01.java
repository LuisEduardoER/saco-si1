package fachada;

import excecoes.CampoInvalidoException;
import excecoes.CampoObrigatorioException;
import modelo.Funcionario;
import modelo.Pessoa;
import modelo.Sistema;

public class fachada01 {
	
	private static Sistema s = null;
	

	private Sistema getSistema(){
		if(s == null){
			s = new Sistema();
		}
		return s;
	}
	
	public int getAllUsers(){
		Sistema s = getSistema();
		return s.qteUsers();
		
	}
	
	
	public void addUser(String login, String name, String email, String phone) throws CampoObrigatorioException,CampoInvalidoException {		
		Sistema s = getSistema();
		Pessoa f = new Funcionario(login, name, email, phone);
		s.cadastrarUsuario(f);
	}
	

}
