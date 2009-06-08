package listas;

import interfaces.RelatorioIF;
import java.util.HashMap;
import java.util.Map;



import Veiculos.Veiculo;

public class Veiculos extends HashMap<String, Veiculo> implements RelatorioIF {

	Map<String, Veiculo> veiculos;
	Map<String, Veiculo> InstanciaUnica = null;

	public Veiculos() {
		this.veiculos = new HashMap<String, Veiculo>();
	}

	public Map<String, Veiculo> getInstance() {
		if (InstanciaUnica == null) {
			InstanciaUnica = this.veiculos;

		}

		return InstanciaUnica;
	}

	public String Relatorio() {
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