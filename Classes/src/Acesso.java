package gerenciaEstacionamento;

abstract class Acesso {

	private Veiculo veiculo;
	private Estacionamento estacionamento;

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


}
