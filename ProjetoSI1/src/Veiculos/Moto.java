package Veiculos;

/**
 * Classe que implementa moto
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public class Moto {

	private String modelo, cor, placa;
	private int ano;
	private double preco;

	/**
	 * Construtor da classe Moto
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
	public Moto(String modelo, String cor, String placa, int ano, double preco) {
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.ano = ano;
		this.preco = preco;
	}

	/**
	 * Metodo que retorna o modelo da moto
	 *
	 * @return String modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Metodo que altera o modelo da moto
	 *
	 * @param String
	 *            modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Metodo que retorna a cor da moto
	 *
	 * @return String cor
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * Metodo que altera a cor da moto
	 *
	 * @param String
	 *            cor
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * Metodo que retorna placa da moto
	 *
	 * @return String modelo
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Metodo que altera a placa da moto
	 *
	 * @param String
	 *            placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * Metodo que retorna o ano da moto
	 *
	 * @return int ano
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * Metodo que altera o ano da moto
	 *
	 * @param int
	 *            ano
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * Metodo que retorna o preco da moto
	 *
	 * @return double preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Metodo que altera o preco da moto
	 *
	 * @param double
	 *            preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
