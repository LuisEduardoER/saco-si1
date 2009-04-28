package easyTeste;

import java.util.ArrayList;
import java.util.List;

import easyaccept.EasyAcceptFacade;
import fachada.fachada01;

/**
 * Classe de testes de aceitacao.
 *
 *
 */
public class EasyTeste {

        public static void main(String[] args) {
                List<String> arquivo = new ArrayList<String>();
                // Adiciona o arquivo us1-cadastrarUsuario.txt na lista de Scripts de
                // teste
                arquivo.add("./easyacceptTestes/us01.txt");
                arquivo.add("./easyacceptTestes/us02-17.txt");
                arquivo.add("./easyacceptTestes/us03.txt");
                arquivo.add("./easyacceptTestes/us04.txt");
                arquivo.add("./easyacceptTestes/us05.txt");
                arquivo.add("./easyacceptTestes/us06.txt");
                arquivo.add("./easyacceptTestes/us07.txt");
                arquivo.add("./easyacceptTestes/us08.txt");
                arquivo.add("./easyacceptTestes/us10-11.txt");
                arquivo.add("./easyacceptTestes/us12-13.txt");
                arquivo.add("./easyacceptTestes/us14.txt");
                // Instancia a fachada do seu sotfware
                fachada01 facade = new fachada01();

                // Instancia a fachada do EasyAccept
                EasyAcceptFacade eaFacade = new EasyAcceptFacade(facade, arquivo);

                // Executa o teste
                eaFacade.executeTests();

                // Imprimir o resultado do teste
                System.out.println(eaFacade.getCompleteResults());
        }

}
