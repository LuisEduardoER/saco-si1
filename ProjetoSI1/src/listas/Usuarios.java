package listas;

import interfaces.RelatorioIF;

import java.util.ArrayList;

import Pessoas.Usuario;

public class Usuarios extends ArrayList<Usuario> implements RelatorioIF {

	ArrayList<Usuario> usuarios;
	ArrayList<Usuario> InstanciaUnica = null;

	public Usuarios() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getInstance() {
		if (InstanciaUnica == null) {
			InstanciaUnica = this.usuarios;

		}

		return InstanciaUnica;
	}

	public String relatorio() {
		String saida = null;
		System.out
				.println("*******************  USUARIOS DO SISTEMA ***************** ");
		for (int i = 0; i < usuarios.size(); i++) {
			saida += "  NOME: " + usuarios.get(i).getName() + "  TELEFONE:  "
					+ usuarios.get(i).getPhone() + "\n";
		}

		return saida;
	}

}

