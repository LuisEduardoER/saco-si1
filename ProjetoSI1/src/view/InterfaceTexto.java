package view;

public class InterfaceTexto {
		
	
	public String cadastrarUsuario() {
		return " login, nome, email e telefone do funcionario.";
	}

	public String cadastrarCliente(){
		return " Nome, email e telefone.";
	}
	
	public String cadastrarItem() {
		return "tipo,modelo,cor,placa,ano e preco.";
	}
	
	public String registrarAluguel(){
		return " email do cliente, placa do veiculo, data de inicio e fim.";
	}
	
	public void registrarAluguelAtrasado(){	
		
	}
	
	public void registrarLiberacaoDoItem(){
		
	}
	
	public void registrarInteresseDoClienteNoItemAlugado(){
		
	}
	
	public void registrarReservaDoItem(){
		
	}
	
	public void exibirRequisicoesDeAluguel(){
		
	}
	
	public void exibirSituacaoDoItem(){
		
	}
	
	public void exibirAlugueisVigentes(){
		
	}
	
	public void exibirAlugueisAtrasados(){
		
	}
	
	public void exibirVeiculosDisponiveis(){
		
	}
	
	public String excluirUsuario() {
		return " Email do funcionario.";
	}

	public String excluirCliente(){
		return "Email do cliente.";
	}
	
	public String excluirItem() {
		return " placa do veiculo.";
	}

	
	public void interfaceComUsuario() {
	}

	public static void main(String[] args) {
		InterfaceTexto ig = new InterfaceTexto();
		ig.interfaceComUsuario();
	}

}
