package empresa;

import Pessoas.Cliente;
import Veiculos.Veiculo;

public class Aluguel {
	
	Cliente cliente;
	Veiculo veiculo;
	
	public Aluguel(Cliente cliente, Veiculo veiculo){
		this.cliente = cliente;
		this.veiculo = veiculo;
	}

}
