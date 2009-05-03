package Veiculos;

public class Veiculo {

	private String modelo, cor, placa, tipo;
	private int ano;
	private double preco;
	private String situacao;
	
	private final String statusDefault = "available";
	private final String statusNonDefault = "unavailable";
	
	public Veiculo(String tipo, String modelo, String cor, String placa, int ano, double preco){
		this.tipo = tipo;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.ano = ano;
		this.preco = preco;
		this.situacao = "available";
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public String getModelo(){
		return modelo;
	}
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	public String getCor(){
		return cor;
	}
	
	public void setCor(String cor){
		this.cor = cor;
	}
	
	public String getPlaca(){
		return placa;
	}
	
	public void setPlaca(String placa){
		this.placa = placa;
	}
	
	public int getAno(){
		return ano;
	}
	
	public void setAno(int ano){
		this.ano = ano;
	}
	
	public double getPreco(){
		return preco;
	}
	
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public String situacao(){
		return situacao;
	}
	
	public void setSituacao(){
		if (this.situacao == "unavailable"){
			this.situacao = "available";
		}else{
			this.situacao = "unavailable";
		}
	}
	
}
