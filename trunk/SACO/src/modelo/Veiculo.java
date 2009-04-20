package modelo;
import java.util.Date;
import java.util.List;

public interface Veiculo {

	String getTipo();

	String getModelo();

	String getCor();

	String getPlaca();

	int getAno();

	double getPrecoPorDia();
	
	boolean EstaAlugado();
	
	boolean EstaLiberado();
	
	void setEstaLiberado(boolean a);
	
	void setEstaAlugado(boolean a);
	
	void setPrecoPorDia(double valor);
	
	List<Pessoa> getListaDeReserva();
	
	void verListaDeReservas(List<Pessoa> ListaDeReserva);
	
	void adicionaClienteNaListaDeReservas(List<Pessoa> ListaDeReserva,Pessoa cliente);
	
	void removerClienteDaListaDeReservas(List<Pessoa> ListaDeReserva,Date dataDaReserva);
	
	
}
