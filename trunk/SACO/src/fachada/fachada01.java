package fachada;

import excecoes.CampoObrigatorioException;
import modelo.Funcionario;
import modelo.Pessoa;
import modelo.Sistema;

public class fachada01 {
	
	private static Sistema s = null;
	
	/*
addUser login="foo" name="foo bar" email="foo@bar.com" phone="6666666666"
addUser login="romulo" name="paulo romulo" email="paulo@embedded.ufcg.edu.br" phone="8388242424"
addUser login="xpto" name="moo" email="moo@xpto.com.br" phone="8388888888"
addUser login="user" name="user" email="user@company.com" phone="1234567890"
	 */
	
//	expect 0 getAllUsers
	
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
	
	
	public void addUser(String login, String name, String email, String phone) throws CampoObrigatorioException {		
		Sistema s = getSistema();
		Pessoa f = new Funcionario(login, name, email, phone);
		s.cadastrarUsuario(f);
	}
	

}
