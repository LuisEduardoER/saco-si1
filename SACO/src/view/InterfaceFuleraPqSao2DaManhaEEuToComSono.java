package view;
import java.util.Scanner;

import modelo.Administrador;
import modelo.Carro;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Moto;
import modelo.Pessoa;
import modelo.Sistema;
import modelo.Veiculo;

// Isso eh soh um teste....ainda tem mta, mta, mta coisa p fazer...
//e nesse aih todo mundo tah fazendo todas as funcoes....mas eh soh p testar...
//depois a gnt delimita qm pode fazer oq.
public class InterfaceFuleraPqSao2DaManhaEEuToComSono {
	private Sistema sistema = new Sistema();
	private final int ADICIONAR_USUARIO = 1;
	private final int ADICIONAR_VEICULO = 2;
	private final int LISTAR_USUARIOS = 3;
	private final int LISTAR_VEICULOS = 4;
	private final int EXCLUIR_USUARIO = 5;
	private final int EXLCUIR_VEICULO = 6;
	private final int FAZER_ALUGUEL = 7;
	private final int FAZER_DEVOLUCAO = 8;
	private final int SAIR = 0;
	Scanner sc1 = new Scanner(System.in);

	/**
	 * Cadastra um novo usuario de forma interativa.
	 */
	public void cadastrarUsuario() {

		Pessoa pessoa = null;
		System.out.println("Classificacao?");
		System.out.println("1.administrador;");
		System.out.println("2.cliente;");
		System.out.println("3.funcionario;");
		int classificacao = 0;
		boolean control = true;
		while (control) {
			try {
				System.out.print("opcao: ");
				classificacao = (int) Integer.valueOf(sc1.nextLine());
				control = false;
			} catch (Exception e) {
				System.out.println("A opcao tem que ser um numero.=/");
			}
		}
		if (classificacao == 1) {

			System.out.print("Digite seu nome: ");
			String nome = sc1.nextLine();
			System.out.print("Digite seu email: ");
			String email = sc1.nextLine();
			System.out.print("Digite seu telefone: ");
			String telefone = sc1.nextLine();
			pessoa = new Administrador(nome, email, telefone);
		} else if (classificacao == 2) {
			System.out.print("Digite seu nome: ");
			String nome = sc1.nextLine();
			System.out.print("Digite seu email: ");
			String email = sc1.nextLine();
			System.out.print("Digite seu telefone: ");
			String telefone = sc1.nextLine();
			pessoa = new Cliente(nome, email, telefone);

		} else if (classificacao == 3) {

			System.out.print("Digite seu nome: ");
			String nome = sc1.nextLine();
			System.out.print("Digite seu email: ");
			String email = sc1.nextLine();
			System.out.print("Digite seu telefone: ");
			String telefone = sc1.nextLine();
			pessoa = new Funcionario(nome, email, telefone);
		} else {
			System.out.println("Opcao invalida.");
		}
		if (sistema.cadastrarUsuario(pessoa) == 0) {
			System.out.println("Usuario adicionado com sucesso. =)");
		} else if (sistema.cadastrarUsuario(pessoa) == -1) {
			System.out
					.println("Cadastro mal sucedido.\nUsuario ja existente.=/");
		} else {
			System.out
					.println("Cadastro mal sucedido.\nResgitro ja existente.=/");
		}
	}

	/**
	 * Cadastra um novo Item de forma interativa.
	 */
	public void cadastrarItem() {

		Veiculo veiculo = null;
		System.out.println("Classificacao:");
		System.out.println("1.carro;");
		System.out.println("2.moto;");
		System.out.print("opcao: ");
		int opcao = (int) Integer.valueOf(sc1.nextLine());
		if (opcao == 1) {
			System.out.print("Digite seu modelo: ");
			String modelo = sc1.nextLine();
			System.out.print("Digite sua cor: ");
			String cor = sc1.nextLine();
			System.out.print("Digite a placa: ");
			String placa = sc1.nextLine();
			System.out.print("Digite o ano de fabricacao: ");
			int ano = sc1.nextInt();
			System.out.print("Digite o preco de aluguel por dia: ");
			double precoPorDia = sc1.nextDouble();
			veiculo = new Carro("carro", modelo, cor, placa, ano, precoPorDia);
		} else if (opcao == 2) {
			System.out.print("Digite seu modelo: ");
			String modelo = sc1.nextLine();
			System.out.print("Digite sua cor: ");
			String cor = sc1.nextLine();
			System.out.print("Digite a placa: ");
			String placa = sc1.nextLine();
			System.out.print("Digite o ano de fabricacao: ");
			int ano = sc1.nextInt();
			System.out.print("Digite o preco de aluguel por dia: ");
			double precoPorDia = sc1.nextDouble();
			veiculo = new Moto("moto", modelo, cor, placa, ano, precoPorDia);
		} else {
			System.out.println("Opcao invalida.");
		}
		sistema.cadastrarVeiculo(veiculo);
	}

	/**
	 * Exclui um usuario de forma interativa.
	 */
	public void excluirUsuario() {

		// implementar
	}

	/**
	 * Exclui um item de forma interativa.
	 */
	public void excluirVeiculo() {

		System.out.print("Placa do veiculo: ");
		String placa = sc1.nextLine();
		if (sistema.excluirVeiculo(placa)) {
			System.out.println("Operacao realizada com sucesso. =)");
		} else {
			System.out
					.println("Operacao mal-sucedida. Item nao cadastrado. =/");
		}
	}

	/**
	 * Promove a interface grafica inicial( menu ).
	 */
	public void interfaceComUsuario() {
		Scanner sc = new Scanner(System.in);
		int entrada = 0;
		while (true) {
			System.out.println();
			System.out.println("Menu:" + "\n 1.ADICIONAR USUARIO"
					+ "\n 2.ADICIONAR VEICULO" + "\n 3.LISTAR USUARIOS"
					+ "\n 4.LISTAR VEICULOS" + "\n 5.EXCLUIR USUARIO"
					+ "\n 6.EXLCUIR ITEM" + "\n 7.FAZER EMPRESTIMO"
					+ "\n 8.FAZER DEVOLUCAO" + "\n 0.SAIR");
			boolean control = true;
			while (control) {
				try {
					System.out.print("opcao: ");
					entrada = (int) Integer.valueOf(sc.nextLine());
					control = false;
				} catch (Exception e) {
					System.out.println("A opcao tem que ser um numero.=/");
				}
			}

			System.out.println();
			switch (entrada) {
			case ADICIONAR_USUARIO:
				cadastrarUsuario();
				break;
			case ADICIONAR_VEICULO:
				cadastrarItem();
				break;
			case LISTAR_USUARIOS:
				System.out.println("Lista de usuarios:");
				sistema.listarUsuarios();
				break;
			case LISTAR_VEICULOS:
				System.out.println("Lista de veiculos:");
				sistema.listarVeiculos();
				break;
			case EXCLUIR_USUARIO:
				excluirUsuario();
				break;
			case EXLCUIR_VEICULO:
				excluirVeiculo();
				break;
			case FAZER_ALUGUEL:

				// implementar
			case FAZER_DEVOLUCAO:
				System.out.print("Digite email: ");
				String email = sc1.nextLine();
				System.out.print("Digite placa: ");
				String placa = sc1.nextLine();

				double multa = sistema.getMulta(email, placa);
				if (sistema.fazerDevolucao(email, placa)) {
					System.out.println("Devolucao concluida com sucesso. =)");
					System.out.println("Valor da multa: R$" + multa);
				} else {
					System.out.println("Operacao mal-sucedida. =/");
				}
				break;
			case SAIR:
				System.exit(0);
			default:
				System.out.println("Opcao invalida");
				break;
			}
		}
	}

	public static void main(String[] args) {
		InterfaceFuleraPqSao2DaManhaEEuToComSono ig = new InterfaceFuleraPqSao2DaManhaEEuToComSono();
		ig.interfaceComUsuario();
	}

}
