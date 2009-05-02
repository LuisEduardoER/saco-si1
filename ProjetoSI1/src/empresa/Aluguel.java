package empresa;


public class Aluguel {
	
	/*Cliente cliente;
	Veiculo veiculo;*/
	
	
	private double preco;
	private String plate, email, init, end;
	private boolean situation = true;
	private String statusDefault = "active";
	
	/*public Aluguel(Cliente cliente, Veiculo veiculo){
		this.cliente = cliente;
		this.veiculo = veiculo;
	}*/
	
	public Aluguel(String placa, String email, String inicio, String fim){
		this.plate = placa;
		this.email = email;
		this.init = inicio;
		this.end = fim;
			
	}
	
	public String getPlate(){
		return this.plate;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getInit(){
		return this.init;
	}
	
	public String getEnd(){
		return this.end;
	}
	
	public String getStatus(){
		if(situation){
			return statusDefault;
		}else{
			return "non active";
		}
	}

}
