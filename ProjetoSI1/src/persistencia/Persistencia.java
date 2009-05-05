package persistencia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.persistence.FileStreamStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

/**
 * Classe que implementa a persistência através do uso de listas
 *
 * @author Andressa
 * @author Lenin
 * @author Niedja Roberta
 * @author Renata
 * @author Tatyanne Lapa
 *
 */
public class Persistencia<E> {

	private List<E> listaDePersistencia;

	/**
	 * construtor da classe Persistencia
	 *
	 */
	public Persistencia(String diretorio) {

		// constrói a pasta do caminho se ela não existir
		new File(diretorio).mkdirs();

		// constrói a lista persistente
		this.listaDePersistencia = new XmlArrayList(new FileStreamStrategy(
				new File(diretorio)));
	}

	/**
	 * retorna uma lista virtual dos dados salvos na persistencia
	 *
	 * @return List<E> memoria
	 *
	 */
	public List<E> getListaPersistente() {
		List<E> memoria = new ArrayList<E>();
		for (E dado : listaDePersistencia) {
			memoria.add(dado);

		}
		return memoria;
	}

	/**
	 * persiste os dados a partir de uma lista virtual
	 *
	 * @param List
	 *            <E> lista
	 */
	public void persiste(List<E> lista) {
		listaDePersistencia.clear();
		for (E dado : lista) {
			listaDePersistencia.add(dado);
		}
	}

	public void apagaPersistencia (){
		listaDePersistencia.clear();
	}
}
