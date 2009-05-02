package Veiculos;

public class Veiculo {

	private String modelo, cor, placa, tipo;
	private int ano;
	private double preco;
	private boolean situacao;
	
	public Veiculo(String tipo, String modelo, String cor, String placa, int ano, double preco){
		this.tipo = tipo;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.ano = ano;
		this.preco = preco;
		this.situacao = true;
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
		if(this.situacao){
			return "available";
		}else{
			return "unavailable";
		}
	}
}
