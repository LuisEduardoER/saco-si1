package modelo;
import java.util.ArrayList;
import java.util.Date;

public class Sistema {

	private ArrayList<Aluguel> listaAlugueis = new ArrayList<Aluguel>();
	private ArrayList<Aluguel> listaAlugueisAtrasados = new ArrayList<Aluguel>();
	private ArrayList<Pessoa> listaUsuariosDoSistema = new ArrayList<Pessoa>();
	private ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

	/**
	 * Retorna a lista dos alugueis
	 */
	public ArrayList<Aluguel> getListaAlugueis() {
		return listaAlugueis;
	}

	/**
	 * Retorna a lista dos alugueis atrasados
	 */
	public ArrayList<Aluguel> getListaAlugueisAtrasados() {
		return listaAlugueisAtrasados;
	}

	/**
	 * Retorna a lista dos usuarios do sistema
	 */
	public ArrayList<Pessoa> getListaUsuariosDoSistema() {
		return listaUsuariosDoSistema;
	}

	/**
	 * Retorna a lista dos veiculos
	 */
	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	/**
	 * Cadastra um usuario no sistema e diz se o cadastro foi efetuado.
	 */
	public int cadastrarUsuario(Pessoa pessoa) {
		int pessoaJaExistente = -1;
		int cadastroBemSucedido = 0;
		for (int i = 0; i < listaUsuariosDoSistema.size(); i++) {
			if (pessoa.getEmail() == listaUsuariosDoSistema.get(i).getEmail()) {
				return pessoaJaExistente;
			}

		}

		listaUsuariosDoSistema.add(pessoa);
		return cadastroBemSucedido;
	}

	/**
	 * Pega um usuario do sistema.
	 */
	public Pessoa getUsuario(String email) {
		for (int i = 0; i < listaUsuariosDoSistema.size(); i++) {
			if (listaUsuariosDoSistema.get(i).getEmail().equals(email)) {
				return listaUsuariosDoSistema.get(i);
			}
		}
		return null;
	}

	/**
	 * Cadastra um veiculo ao sistema
	 * 
	 * @return boolean dizendo se o cadastro foi bem sucedido.
	 */
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		for (int i = 0; i < listaVeiculos.size(); i++) {
			if (veiculo.getPlaca().equals(listaVeiculos.get(i).getPlaca())) {
				return false;
			}
		}
		listaVeiculos.add(veiculo);
		return true;
	}

	/**
	 * O adm pode excluir um funcionario do sistema informando seu email ou
	 * telefone.
	 * 
	 * @return boolean dizendo se a exclusão foi bem sucedida.
	 */
	public boolean excluirFuncionario(String chave) {
		Pessoa funcionario;
		for (int i = 0; i < listaUsuariosDoSistema.size(); i++) {
			if (listaUsuariosDoSistema.get(i).getEmail().equals(chave)
					|| listaUsuariosDoSistema.get(i).getTelefone()
							.equals(chave)) {
				funcionario = listaUsuariosDoSistema.get(i);
				listaUsuariosDoSistema.remove(funcionario);
				return true;
			}
		}
		return false;
	}

	/**
	 * O cliente pode se excluir do sistema informando seu email
	 * 
	 * @return boolean dizendo se a exclusão foi bem sucedida.
	 */
	public boolean excluirCliente(String email) {
		Pessoa cliente;
		for (int i = 0; i < listaUsuariosDoSistema.size(); i++) {
			if (listaUsuariosDoSistema.get(i).getEmail().equals(email)) {
				cliente = listaUsuariosDoSistema.get(i);
				listaUsuariosDoSistema.remove(cliente);
				return true;
			}
		}
		return false;
	}

	/**
	 * O adm pode excluir um veiculo do sistema.
	 * 
	 * @return boolean dizendo se a transacao foi bem sucedida.
	 */
	public boolean excluirVeiculo(String placa) {
		Veiculo veiculo;
		for (int i = 0; i < listaVeiculos.size(); i++) {
			if (listaVeiculos.get(i).getPlaca().equals(placa)) {
				veiculo = listaVeiculos.get(i);
				listaVeiculos.remove(veiculo);
				return true;
			}
		}
		return false;
	}

	/**
	 * Faz o emprestimo de um item a um usuario.
	 * 
	 * @param numero
	 *            de identificacao do usuario.
	 * @param numero
	 *            de identificacao do item.
	 *@return boolean dizendo se a transacao foi bem sucedida.
	 */
	public boolean fazerAluguel(String nome, String email, String endereco,
			String telefone, Date dataDeInicio, Date dataFinal, String placa) {

		Veiculo veiculo = null;
		Pessoa pessoa = null;
		for (int i = 0; i < listaAlugueis.size(); i++) {
			if (listaAlugueis.get(i).getVeiculo().getPlaca().equals(placa)) {
				return false;
			}
		}
		for (int i = 0; i < listaVeiculos.size(); i++) {
			if (listaVeiculos.get(i).getPlaca().equals(placa)) {
				veiculo = listaVeiculos.get(i);
				for (int j = 0; j < listaUsuariosDoSistema.size(); j++) {
					if (listaUsuariosDoSistema.get(j).getEmail().equals(email)) {
						pessoa = listaUsuariosDoSistema.get(j);
						veiculo.setEstaAlugado(true);
						veiculo.setEstaLiberado(false);
						Aluguel aluguel = new Aluguel(pessoa, veiculo,
								dataDeInicio, dataFinal);
						listaAlugueis.add(aluguel);
						return true;
					}
				}

				pessoa = new Cliente(nome, email, telefone);
				veiculo.setEstaAlugado(true);
				veiculo.setEstaLiberado(false);
				Aluguel aluguel = new Aluguel(pessoa, veiculo, dataDeInicio,
						dataFinal);
				listaAlugueis.add(aluguel);
				return true;

			}
		}
		return false;
	}

	/**
	 * Retorna a multa de um aluguel.
	 * 
	 */
	public double getMulta(String email, String placa) {
		double multa = 0.0;
		for (int i = 0; i < listaAlugueis.size(); i++) {
			if (listaAlugueis.get(i).getCliente().getEmail().equals(email)
					&& listaAlugueis.get(i).getVeiculo().getPlaca().equals(
							placa)) {
				multa = listaAlugueis.get(i).multa();
			}
		}
		return multa;
	}

	/**
	 * Devolve um veiculo ao sistema.
	 * 
	 * @return boolean dizendo se a transacao foi bem sucedida.
	 */
	public boolean fazerDevolucao(String email, String placa) {
		for (int i = 0; i < listaAlugueis.size(); i++) {
			if (listaAlugueis.get(i).getCliente().getEmail().equals(email)
					&& listaAlugueis.get(i).getVeiculo().getPlaca().equals(
							placa)) {
				listaAlugueis.get(i).getVeiculo().setEstaAlugado(false);
				listaAlugueis.get(i).getVeiculo().setEstaLiberado(true);

				for (int k = 0; i < listaAlugueis.get(k).getVeiculo()
						.getListaDeReserva().size(); k++) {
					/*
					 * enviar email p
					 * listaAlugueis.get(k).getVeiculo().getListaDeReserva
					 * ().get(k).getEmail(); avisando q o carro foi liberado
					 */
				}
				listaAlugueis.remove(i);
				return true;
			}
		}
		return false;
	}

	public void registrarAlugueisAtrasados(Date hoje) {

		for (int i = 0; i < listaAlugueis.size(); i++) {
			if (hoje.before(listaAlugueis.get(i).dataDeDevolucao)) {
				listaAlugueisAtrasados.add(listaAlugueis.get(i));
				listaAlugueis.remove(listaAlugueis.get(i));
			}
		}

		// avisar a quem ta com o aluguel atrasado

		for (int k = 0; k < listaAlugueisAtrasados.size(); k++) {
			// enviar email falando do atras p/
			// listaAlugueisAtrasados.get(k).getPessoa().getEmail();

		}
	}

	/**
	 * Lista os usuarios do sistema. (Imprime em forma de Strings.)
	 */
	public void listarUsuarios() {
		for (int i = 0; i < listaUsuariosDoSistema.size(); i++) {
			Pessoa usuarioAtual = listaUsuariosDoSistema.get(i);
			System.out.print("Nome: " + usuarioAtual.getNome() + "   Email: "
					+ usuarioAtual.getEmail() + "   Telefone: "
					+ usuarioAtual.getTelefone() + "   Tipo: "
					+ usuarioAtual.getTipo());

		}
	}

	/**
	 * Lista os veiculos do sistema. (Imprime em forma de Strings.)
	 * 
	 */
	public void listarVeiculos() {
		String estado;
		for (int i = 0; i < listaVeiculos.size(); i++) {
			if (listaVeiculos.get(i).getEstaAlugado()) {
				estado = "Alugado";
			} else {
				estado = "Disponivel";
			}
			System.out.println("  Tipo: " + listaVeiculos.get(i).getTipo()
					+ "  Modelo: " + listaVeiculos.get(i).getModelo()
					+ "  Cor: " + listaVeiculos.get(i).getCor() + "  Placa: "
					+ listaVeiculos.get(i).getPlaca() + "  Ano: "
					+ listaVeiculos.get(i).getAno() + "    Estado: " + estado);
		}
	}

	/**
	 * Um cliente pode registrar interesse em um veículo
	 */

	public void RegistrarInteresseEmVeiculo(Pessoa pessoa, Veiculo veiculo) {

		veiculo.getListaDeReserva().add(pessoa);
	}
	
	public int qteUsers(){
		return this.listaUsuariosDoSistema.size();
	}
}
