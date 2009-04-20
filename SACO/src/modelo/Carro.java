package modelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carro implements Veiculo {

	private String tipo;
	private String cor;
	private String modelo;
	private int ano;
	private double precoPorDia;
	private String placa;
	private boolean estaAlugado;
	private boolean estaLiberado;
	private List<Pessoa> ListaDeReserva;

	public Carro(String carro, String modelo, String cor, String placa,
			int ano, double precoPorDia) {

		this.ano = ano;
		this.cor = cor;
		this.precoPorDia = precoPorDia;
		this.tipo = "carro";
		this.modelo = modelo;
		this.placa = placa;

		this.estaAlugado = false;
		this.estaLiberado = false;
		this.ListaDeReserva = new ArrayList<Pessoa>();

	}

	public String getTipo() {
		return tipo;
	}

	public String getCor() {
		return cor;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAno() {
		return ano;
	}

	public double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}

	public String getPlaca() {
		return placa;
	}

	

	public void setEstaAlugado(boolean estaAlugado) {
		this.estaAlugado = estaAlugado;
	}

	

	public void setEstaLiberado(boolean estaLiberado) {
		this.estaLiberado = estaLiberado;
	}

	public void verListaDeReservas(List<Pessoa> ListaDeReserva) {

		System.out.println("Veiculo requisitado pelos clientes abaixo: ");
		for (int i = 0; i < ListaDeReserva.size(); i++) {
			System.out.println(((Pessoa) ListaDeReserva.get(i)).getNome());
		}

	}

	public List<Pessoa> getListaDeReserva() {
		return ListaDeReserva;
	}

	public boolean EstaAlugado() {
		return estaAlugado;
	}


	public boolean EstaLiberado() {
		return estaLiberado;
	}

	public void adicionaClienteNaListaDeReservas(List<Pessoa> ListaDeReserva,
			Pessoa cliente) {
		
	}

	public void removerClienteDaListaDeReservas(List<Pessoa> ListaDeReserva,
			Date dataDaReserva) {
		
		
	}

}
