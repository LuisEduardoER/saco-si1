package Veiculos;

/**
 * Classe que implementa os veiculos da empresa
 *
 * @author Andressa Bezerra 20721005
 * @author Lenin da Nobrega 20711433
 * @author Niedja Roberta 20621165
 * @author Renata Braga 20721334
 * @author Tatyanne Lapa 20621176
 */
public class Veiculo {

	private String modelo, cor, placa, tipo;
	private int ano;
	private double preco;
	private String situacao;

	/**
	 * Construtor da classe Carro
	 *
	 * @param String
	 *            tipo
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
	public Veiculo(String tipo, String modelo, String cor, String placa,
			int ano, double preco) {
		this.tipo = tipo;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.ano = ano;
		this.preco = preco;
		this.situacao = "available";
	}

	/**
	 * Metodo que retorna o tipo do veiculo
	 *
	 * @return String tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Metodo que altera o tipo do veiculo
	 *
	 * @param String
	 *            tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo que retorna o modelo do veiculo
	 *
	 * @return String modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Metodo que altera o modelo do veiculo
	 *
	 * @param String
	 *            modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Metodo que retorna a cor do veiculo
	 *
	 * @return String cor
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * Metodo que altera a cor do veiculo
	 *
	 * @param String
	 *            cor
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * Metodo que retorna a placa do veiculo
	 *
	 * @return String placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Metodo que altera a placa do veiculo
	 *
	 * @param String
	 *            placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * Metodo que retorna o ano do veiculo
	 *
	 * @return int ano
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * Metodo que altera o ano do veiculo
	 *
	 * @param int
	 *            ano
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * Metodo que retorna o preco do veiculo
	 *
	 * @return double preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Metodo que altera o preco do veiculo
	 *
	 * @param double
	 *            preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Metodo que retorna a situacao do veiculo
	 *
	 * @return String situacao
	 */
	public String situacao() {
		return situacao;
	}

	/**
	 * Metodo que altera a situacao do veiculo
	 *
	 */
	public void setSituacao() {
		if (this.situacao == "unavailable") {
			this.situacao = "available";
		} else {
			this.situacao = "unavailable";
		}
	}

}
