package listas;

import interfaces.RelatorioIF;

import java.util.ArrayList;

import Pessoas.Usuario;

/**
 * Classe que implementa um ArrayList de Usuario e faz um relatorio
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public class Usuarios extends ArrayList<Usuario> implements RelatorioIF {

	ArrayList<Usuario> usuarios;
	ArrayList<Usuario> InstanciaUnica = null;

	/**
	 * construtor da classe Usuarios
	 *
	 */
	public Usuarios() {
		this.usuarios = new ArrayList<Usuario>();
	}

	/**
	 * Singleton da instância do ArrayList de Usuario
	 *
	 * @return FachadaPersistencia
	 */
	public ArrayList<Usuario> getInstance() {
		if (InstanciaUnica == null) {
			InstanciaUnica = this.usuarios;

		}

		return InstanciaUnica;
	}

	/**
	 * Metodo que imprime o relatorio dos usuarios
	 *
	 * @return String saida
	 */
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

