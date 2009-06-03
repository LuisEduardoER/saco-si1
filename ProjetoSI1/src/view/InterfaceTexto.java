package view;
import java.util.Scanner;

import Pessoas.Cliente;
import Pessoas.Pessoa;
import Pessoas.Usuario;
import Veiculos.Carro;
import Veiculos.Moto;
import Veiculos.Veiculo;

import empresa.Empresa;
import exception.AlreadyExistsException;
import exception.EmptyDatabaseException;
import exception.InvalidCharacterException;
import exception.InvalidParameterException;
import exception.NotFoundException;
import exception.RequiredFieldException;


public class InterfaceTexto {
	private Empresa empresa = new Empresa();
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
		System.out.println("1.cliente;");
		System.out.println("2.usuario;");
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
			pessoa = new Cliente(nome, email, telefone);
		} else if (classificacao == 2) {

			System.out.print("Digite seu login: ");
			String login = sc1.nextLine();
			System.out.print("Digite seu nome: ");
			String nome = sc1.nextLine();
			System.out.print("Digite seu email: ");
			String email = sc1.nextLine();
			System.out.print("Digite seu telefone: ");
			String telefone = sc1.nextLine();
			pessoa = new Usuario(login, nome, email, telefone);

		} else {
			System.out.println("Opcao invalida.");
		}
		
	}

	/**
	 * Cadastra um novo Item de forma interativa.
	 * @throws AlreadyExistsException 
	 * @throws InvalidCharacterException 
	 * @throws RequiredFieldException 
	 */
	public void cadastrarItem() throws RequiredFieldException, InvalidCharacterException, AlreadyExistsException {

		
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
			String ano = sc1.nextLine();
			System.out.print("Digite o preco de aluguel por dia: ");
			String precoPorDia = sc1.nextLine();
			Carro carro = new Carro( modelo, cor, placa, Integer.parseInt(ano), Double.parseDouble(precoPorDia));
			empresa.addVehicle("carro", modelo, cor, placa, ano, precoPorDia);
		} else if (opcao == 2) {
			System.out.print("Digite seu modelo: ");
			String modelo = sc1.nextLine();
			System.out.print("Digite sua cor: ");
			String cor = sc1.nextLine();
			System.out.print("Digite a placa: ");
			String placa = sc1.nextLine();
			System.out.print("Digite o ano de fabricacao: ");
			String ano = sc1.nextLine();
			System.out.print("Digite o preco de aluguel por dia: ");
			String precoPorDia = sc1.nextLine();
			Moto moto = new Moto( modelo, cor, placa, Integer.parseInt(ano), Double.parseDouble(precoPorDia));
			empresa.addVehicle("moto", modelo, cor, placa, ano, precoPorDia);
		} else {
			System.out.println("Opcao invalida.");
		}
		
	}

	/**
	 * Exclui um usuario de forma interativa.
	 */
	public void excluirUsuario() {

		// implementar
	}

	/**
	 * Exclui um item de forma interativa.
	 * @throws NotFoundException 
	 * @throws InvalidParameterException 
	 * @throws EmptyDatabaseException 
	 */
	public void excluirVeiculo() throws EmptyDatabaseException, InvalidParameterException, NotFoundException {

		System.out.print("Placa do veiculo: ");
		String placa = sc1.nextLine();
		empresa.removeVehicle(placa);
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
				 empresa.listarUsuarios();
				break;
			case LISTAR_VEICULOS:
				System.out.println("Lista de veiculos:");
				empresa.listarVeiculos();
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

			case SAIR:
				System.exit(0);
			default:
				System.out.println("Opcao invalida");
				break;
			}
		}
	}

	public static void main(String[] args) {
		InterfaceTexto ig = new InterfaceTexto();
		ig.interfaceComUsuario();
	}

}


