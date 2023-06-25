package gerenciaEstacionamento;

public class Acesso {

	private Veiculo veiculo;
	private Estacionamento estacionamento;
	private int valorFracao;
	private int valorHoraCheia;
	private int diariaDiurna;
	private int diariaNoturna;
	private int valorMensal;
	private int valorPorEvento;

	public void calcularTarifa() {

	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public int getValorFracao() {
		return valorFracao;
	}

	public void setValorFracao(int valorFracao) {
		this.valorFracao = valorFracao;
	}

	public int getValorHoraCheia() {
		return valorHoraCheia;
	}

	public void setValorHoraCheia(int valorHoraCheia) {
		this.valorHoraCheia = valorHoraCheia;
	}

	public int getDiariaDiurna() {
		return diariaDiurna;
	}

	public void setDiariaDiurna(int diariaDiurna) {
		this.diariaDiurna = diariaDiurna;
	}

	public int getDiariaNoturna() {
		return diariaNoturna;
	}

	public void setDiariaNoturna(int diariaNoturna) {
		this.diariaNoturna = diariaNoturna;
	}

	public int getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(int valorMensal) {
		this.valorMensal = valorMensal;
	}

	public int getValorPorEvento() {
		return valorPorEvento;
	}

	public void setValorPorEvento(int valorPorEvento) {
		this.valorPorEvento = valorPorEvento;
	}

}
