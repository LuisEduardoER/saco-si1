package listas;

import interfaces.RelatorioIF;

import java.util.ArrayList;

import Pessoas.Cliente;

public class Clientes extends ArrayList<Cliente> implements RelatorioIF {

	ArrayList<Cliente> clientes;
	ArrayList<Cliente> InstanciaUnica = null;

	public Clientes() {
		this.clientes = new ArrayList<Cliente>();
	}

	public ArrayList<Cliente> getInstance() {
		if (InstanciaUnica == null) {
			InstanciaUnica = this.clientes;

		}

		return InstanciaUnica;
	}

	public String Relatorio() {
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
