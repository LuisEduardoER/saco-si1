package listas;

import interfaces.RelatorioIF;

import java.util.ArrayList;

import empresa.Aluguel;

public class Alugueis extends ArrayList<Aluguel> implements RelatorioIF {

	ArrayList<Aluguel> alugueis;
	ArrayList<Aluguel> InstanciaUnica = null;

	public Alugueis() {
		this.alugueis = new ArrayList<Aluguel>();
	}

	public ArrayList<Aluguel> getInstance() {
		if (InstanciaUnica == null) {
			InstanciaUnica = this.alugueis;

		}

		return InstanciaUnica;
	}

	public String Relatorio() {
		String saida = null;
		System.out.println("*******************  ALUGUEIS ***************** ");
		for (int i = 0; i < alugueis.size(); i++) {
			saida += "  EMAIL DO LOCATARIO: " + alugueis.get(i).getEmail()
					+ "  PLACA DO VEICULO:  " + alugueis.get(i).getPlate()
					+ "  DATA DE INICIO: " + alugueis.get(i).getInit()
					+ "  DATA DE TERMINO: " + alugueis.get(i).getEnd() + "\n";
		}

		return saida;
	}
}