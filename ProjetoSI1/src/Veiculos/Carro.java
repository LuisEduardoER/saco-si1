package Veiculos;

import interfaces.Alugavel;

/**
 * Classe que implementa carro
 * 
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */

public class Carro extends Veiculo implements Alugavel {

	/**
	 * Construtor da classe Carro
	 * 
	 * @param String
	 *            modelo
	 * @param String
	 *            cor
	 * @param String
	 *            placa
	 * @param int ano
	 * @param double preco
	 */
	public Carro(String tipo, String modelo, String cor, String placa, int ano,
			double preco) {
		super("carro", modelo, cor, placa, ano, preco);

	}

}
