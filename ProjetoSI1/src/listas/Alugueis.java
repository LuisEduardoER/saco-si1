package listas;

import interfaces.RelatorioIF;

import java.util.ArrayList;

import empresa.Aluguel;

/**
 * Classe que implementa um ArrayList de Aluguel e faz um relatorio
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public class Alugueis extends ArrayList<Aluguel> implements RelatorioIF {

	ArrayList<Aluguel> alugueis;
	ArrayList<Aluguel> InstanciaUnica = null;

	/**
	 * construtor da classe Alugueis
	 *
	 */
	public Alugueis() {
		this.alugueis = new ArrayList<Aluguel>();
	}

	/**
	 * Singleton da instância do ArrayList de Aluguel
	 *
	 * @return FachadaPersistencia
	 */
	public ArrayList<Aluguel> getInstance() {
		if (InstanciaUnica == null) {
			InstanciaUnica = this.alugueis;

		}

		return InstanciaUnica;
	}

	/**
	 * Metodo que imprime o relatorio dos aluguéis
	 *
	 * @return String saida
	 */
	public String relatorio() {
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