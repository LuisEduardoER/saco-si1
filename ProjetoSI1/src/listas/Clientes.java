package listas;

import interfaces.RelatorioIF;

import java.util.ArrayList;

import Pessoas.Cliente;

/**
 * Classe que implementa um ArrayList de Cliente e faz um relatorio
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public class Clientes extends ArrayList<Cliente> implements RelatorioIF {

	ArrayList<Cliente> clientes;
	ArrayList<Cliente> InstanciaUnica = null;

	/**
	 * construtor da classe Clientes
	 *
	 */
	public Clientes() {
		this.clientes = new ArrayList<Cliente>();
	}

	/**
	 * Singleton da instância do ArrayList de Cliente
	 *
	 * @return FachadaPersistencia
	 */
	public ArrayList<Cliente> getInstance() {
		if (InstanciaUnica == null) {
			InstanciaUnica = this.clientes;

		}

		return InstanciaUnica;
	}

	/**
	 * Metodo que imprime o relatorio dos clientes
	 *
	 * @return String saida
	 */
	public String relatorio() {
		String saida = null;
		System.out
				.println("*******************  CLIENTES DO SISTEMA ***************** ");
		for (int i = 0; i < clientes.size(); i++) {
			saida += "  NOME: " + clientes.get(i).getName() + "  TELEFONE:  "
					+ clientes.get(i).getPhone() + "\n";
		}

		return saida;
	}
}
