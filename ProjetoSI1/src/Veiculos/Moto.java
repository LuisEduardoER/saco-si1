package Veiculos;

import interfaces.Alugavel;

/**
 * Classe que implementa moto
 * 
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public class Moto extends Veiculo implements Alugavel {

	/**
	 * Construtor da classe Moto
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
	public Moto(String tipo, String modelo, String cor, String placa, int ano,
			double preco) {
		super("moto", modelo, cor, placa, ano, preco);
	}

}
