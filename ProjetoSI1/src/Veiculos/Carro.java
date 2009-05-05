package Veiculos;

/**
 * Classe que implementa carro
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */

public class Carro {

	private String modelo, cor, placa;
	private int ano;
	private double preco;

	/**
	 * Construtor da classe Carro
	 *
	 * @param String
	 *            modelo
	 * @param String
	 *            cor
	 * @param String
	 *            placa
	 * @param int
	 *            ano
	 * @param double
	 *            preco
	 */
	public Carro(String modelo, String cor, String placa, int ano, double preco) {
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.ano = ano;
		this.preco = preco;
	}

	/**
	 * Metodo que retorna o modelo do carro
	 *
	 * @return String modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Metodo que altera o modelo do carro
	 *
	 * @param String
	 *            modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Metodo que retorna a cor do carro
	 *
	 * @return String cor
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * Metodo que altera a cor do carro
	 *
	 * @param String
	 *            cor
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * Metodo que retorna placa do carro
	 *
	 * @return String modelo
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Metodo que altera a placa do carro
	 *
	 * @param String
	 *            placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * Metodo que retorna o ano do carro
	 *
	 * @return int ano
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * Metodo que altera o ano do carro
	 *
	 * @param int
	 *            ano
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * Metodo que retorna o preco do carro
	 *
	 * @return double preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Metodo que altera o preco do carro
	 *
	 * @param double
	 *            preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
