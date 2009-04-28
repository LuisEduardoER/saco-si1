package Testes;

import java.util.ArrayList;
import java.util.List;

import easyaccept.EasyAcceptFacade;
import facade.Facade;

public class testEasyAccept {

	public static void main(String[] args) {
		List<String> arquivo = new ArrayList<String>();
		// Adiciona o arquivo us1-cadastrarUsuario.txt na lista de Scripts de

		// teste
		arquivo.add("us1.txt"); // OK
		arquivo.add("us2-adicionarCliente.txt"); // OK
		arquivo.add("us3-RemoverCliente.txt"); // OK
		arquivo.add("us4-RemoverUsuario.txt"); // OK
		arquivo.add("us5-AdicionarVeiculo.txt"); // OK
		arquivo.add("us6-removerVeiculo.txt"); // OK
		arquivo.add("us7-ConsultarRequisicoesReservasVeiculos.txt"); // OK
		arquivo.add("us8-RegistrarAluguelDeVeiculo.txt");
		arquivo.add("us10-11-Registrar-NotificarLiberacaoDeVeiculo.txt");
		arquivo.add("us12-13-Registrar-NotificarAtrasoDeAluguel.txt");
		arquivo.add("us14-ConsultarSituacaoVeiculo.txt");

		List<String> executar = new ArrayList<String>();

		for (String obj : arquivo) {
			Facade facadeUS1 = new Facade();
			executar.add(obj);
			// Instancia a fachada do EasyAccept
			EasyAcceptFacade eaFacade = new EasyAcceptFacade(facadeUS1,	executar);

			// Executa o teste
			eaFacade.executeTests();

			// Imprimir o resultado do teste

			System.out.println(eaFacade.getCompleteResults());
			executar.clear();
		}

	}

}
