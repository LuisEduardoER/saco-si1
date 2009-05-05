package persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import empresa.Aluguel;

import Pessoas.Cliente;
import Pessoas.Usuario;
import Veiculos.Veiculo;

/**
 * Classe que implementa a fachada da persistencia
 *
 */
public class FachadaPersistencia {

	// private static FachadaPersistencia instanciaUnica;
	private List<Usuario> usuarios;
	private List<Cliente> clientes;
	private List<String[]> requisicoesPendentes;
	private List<Aluguel> alugueis;
	private List<Veiculo> veiculos;

	private Persistencia<Usuario> persistenciaUsuario;
	private Persistencia<Cliente> persistenciaCliente;
	private Persistencia<String[]> persistenciaRequisicoesPendentes;
	private Persistencia<Aluguel> persistenciaAlugueis;
	private Persistencia<Veiculo> persistenciaVeiculos;

	/**
	 * construtor da classe FachadaPersistencia
	 *
	 */
	public FachadaPersistencia() {
		persistenciaUsuario = new Persistencia<Usuario>("./ProjetoSI1/Usuarios");
		persistenciaCliente = new Persistencia<Cliente>("./ProjetoSI1/Clientes");
		persistenciaRequisicoesPendentes = new Persistencia<String[]>(
				"./ProjetoSI1/RequisicoesPendentes");
		persistenciaAlugueis = new Persistencia<Aluguel>(
				"./ProjetoSI1/Alugueis");
		persistenciaVeiculos = new Persistencia<Veiculo>(
				"./ProjetoSI1/Veiculos");

		usuarios = persistenciaUsuario.getListaPersistente();
		clientes = persistenciaCliente.getListaPersistente();
		requisicoesPendentes = persistenciaRequisicoesPendentes
				.getListaPersistente();
		alugueis = (ArrayList<Aluguel>) persistenciaAlugueis
				.getListaPersistente();
		veiculos = (ArrayList<Veiculo>) persistenciaVeiculos
				.getListaPersistente();

	}

	// /**
	// * Singleton da fachada da persistencia
	// *
	// * @return FachadaPersistencia
	// */
	// public synchronized static FachadaPersistencia getInstance() {
	// if (instanciaUnica == null) {
	// instanciaUnica = new FachadaPersistencia();
	// }
	// return instanciaUnica;
	// }

	/**
	 * persiste os dados do sistema
	 */
	public void persisteTudo() {
		persistenciaUsuario.persiste(usuarios);
		persistenciaCliente.persiste(clientes);
		persistenciaRequisicoesPendentes.persiste(requisicoesPendentes);
		persistenciaAlugueis.persiste(alugueis);
		persistenciaVeiculos.persiste(veiculos);
	}


	/**
	 * Retorna uma lista virtual de usuarios
	 *
	 * @return List<Usuario> lista de usuarios
	 */
	public List<Usuario> getUserList() {
		return usuarios;
	}

	/**
	 * Retorna uma lista virtual de Clientes
	 *
	 * @return List<Cliente> lista de clientes
	 */
	public List<Cliente> getClientList() {
		return clientes;
	}

	/**
	 * Retorna uma lista virtual de requisicoes de alugueis pendentes
	 *
	 * @return List<String[]> lista de requisicoes pendentes
	 */
	public List<String[]> getPendentsRequests() {
		return requisicoesPendentes;
	}

	/**
	 * Retorna uma lista virtual de Alugueis
	 *
	 * @return ArrayList<Aluguel> lista de alugueis
	 */
	public List<Aluguel> getRents() {
		return alugueis;
	}

	/**
	 * Retorna uma lista virtual de Veiculos
	 *
	 * @return Map<String, Veiculo> lista de veiculos
	 */
	public Map<String, Veiculo> getVehicles() {
		Map<String, Veiculo> map = new HashMap<String, Veiculo>();
		for (Veiculo veiculo : veiculos) {
			map.put(veiculo.getPlaca(), veiculo);
		}
		return map;
	}

}
