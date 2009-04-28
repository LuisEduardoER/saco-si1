import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import empresa.Empresa;
import Veiculos.Veiculo;

public class Mainzinha {

	private static Map<String, ArrayList<Veiculo>> mapa = new TreeMap<String, ArrayList<Veiculo>>();
	
	public static void main(String[] args) throws Exception{
		
		Veiculo v1 = new Veiculo("carro", "celta", "branco", "ABC1234", 2001, 30);
		Veiculo v2 = new Veiculo("carro", "palio", "branco", "DBE3456", 2008, 60);
		Veiculo v3 = new Veiculo("carro", "uno", "azul", "FGH6785", 2008, 60);
		
		ArrayList<Veiculo> veiculo = new ArrayList<Veiculo>();
		
		alugaVeiculo("carlos", v1);
		alugaVeiculo("paulo", v2);
		alugaVeiculo("carlos", v3);
		
		System.out.println(mapa);
		
//		String key = "";
//		Iterator i1 = mapa.keySet().iterator();
//		Iterator i2 = mapa.get(key).iterator();
		
		
	}
	
	public static void alugaVeiculo(String email, Veiculo veic){
		ArrayList<Veiculo> arrayAtual = new ArrayList<Veiculo>();
		if(mapa.get(email) != null){
			arrayAtual = mapa.get(email);
		}
		arrayAtual.add(veic);
		mapa.put(email, arrayAtual);
	}
}
