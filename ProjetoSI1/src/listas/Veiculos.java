package listas;

import interfaces.RelatorioIF;
import java.util.HashMap;
import java.util.Map;

import Veiculos.Veiculo;

/**
 * Classe que implementa um HashMap de Veiculo e faz um relatorio
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public class Veiculos extends HashMap<String, Veiculo> implements RelatorioIF {

	Map<String, Veiculo> veiculos;
	Map<String, Veiculo> InstanciaUnica = null;

	/**
	 * construtor da classe Veiculos
	 *
	 */
	public Veiculos() {
		this.veiculos = new HashMap<String, Veiculo>();
	}

	/**
	 * Singleton da instância do Map de Veiculo
	 *
	 * @return FachadaPersistencia
	 */
	public Map<String, Veiculo> getInstance() {
		if (InstanciaUnica == null) {
			InstanciaUnica = this.veiculos;

		}

		return InstanciaUnica;
	}

	/**
	 * Metodo que imprime o relatorio dos veículos
	 *
	 * @return String saida
	 */
	public String relatorio() {
		String saida = null;
		System.out
				.println("*******************  VEICULOS DO SISTEMA ***************** ");
		for (int i = 0; i < veiculos.size(); i++) {
			saida += "  TIPO: " + veiculos.get(i).getTipo() + "  MODELO:  "
					+ veiculos.get(i).getModelo() + "  COR:  "
					+ veiculos.get(i).getCor() + "  ANO:  "
					+ veiculos.get(i).getAno() + "  PLACA:  "
					+ veiculos.get(i).getPlaca() + "  PRECO: "
					+ veiculos.get(i).getPreco() + "\n";
		}

		return saida;
	}
}