package modelo;


import java.util.GregorianCalendar;



public class Aluguel {

	private Pessoa cliente;
	private Veiculo veiculo;
	private GregorianCalendar dataInicioDoAluguel;
	private GregorianCalendar dataFimDoAluguel;
	private double precoTotal;


	public Aluguel(Pessoa pessoa, Veiculo veiculo,String dataInicioDoAluguel,
			String dataFimDoAluguel) {
		this.cliente = pessoa;
		this.veiculo = veiculo;
		
		String[] dataISTR = dataInicioDoAluguel.split("/");
		int diaI = Integer.parseInt(dataISTR[0]);
		int mesI = Integer.parseInt(dataISTR[1]);
		int anoI = Integer.parseInt(dataISTR[2]);
		this.dataInicioDoAluguel = new GregorianCalendar();
		this.dataInicioDoAluguel.set(anoI, mesI-1, diaI);
		
		String[] dataFSTR = dataFimDoAluguel.split("/");
		int diaF = Integer.parseInt(dataFSTR[0]);
		int mesF = Integer.parseInt(dataFSTR[1]);
		int anoF = Integer.parseInt(dataFSTR[2]);
		this.dataFimDoAluguel = new GregorianCalendar();
		this.dataFimDoAluguel.set(anoF, mesF-1, diaF);
		
		
	}

	

	public int getDataInicioDoAluguel() {
		return dataInicioDoAluguel.get(GregorianCalendar.DAY_OF_MONTH);
	}

	

	public int getDataFimDoAluguel() {
		return dataFimDoAluguel.get(GregorianCalendar.DAY_OF_MONTH);
	}

	
	public int tempoTotalDoAluguel() {
		return getDataFimDoAluguel() - getDataInicioDoAluguel();
	}

	

	public double getPrecoTotal() {
		precoTotal = tempoTotalDoAluguel() * this.veiculo.getPrecoPorDia();
		return precoTotal;
	}


	public int getDiasDeAtraso() {
		
		GregorianCalendar diaAtual = new GregorianCalendar();
		
		return getDataFimDoAluguel() - diaAtual.get(GregorianCalendar.DAY_OF_MONTH);
	}

	
	public double multa() {

		double precoComMulta = 2 * getPrecoTotal();
		setPrecoTotal(precoComMulta);
		return precoComMulta;
	}

	private void setPrecoTotal(double precoComMulta) {

		this.precoTotal = precoComMulta;

	}

	
	public Pessoa getCliente() {
		return cliente;
	}

	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public boolean aluguelEstaAtrasado() {
		
		GregorianCalendar diaAtual = new GregorianCalendar();
		
		if (diaAtual.before(dataFimDoAluguel))
			return true;
		return false;
	}
}
