package model.dominio;

import java.time.LocalTime;
import java.util.List;

public class Estacionamento {

	private String nome;
	private String localizacao;
	private int lotacaoMaxima;
	private int lotacaoAtual;
	private double taxaDeFracao;
	private double taxaDeHora;
	private double descontoPorHora;
	private double taxaDeDiaria;
	private double taxaNoturna;
	private double taxaMensal;
	private double taxaDeEvento;
	private LocalTime horarioAberturaDiurno;
	private LocalTime horarioFechamentoDiurno;
	private LocalTime horarioAberturaNoturno;
	private LocalTime horarioFechamentoNoturno;
	private List<Veiculo> veiculos;

	public Estacionamento() {

	}

	//
	public Estacionamento(String nome, String localizacao, int lotacaoMaxima, int lotacaoAtual,
	  double taxaDeFracao, double taxaDeHora, double descontoPorHora, double taxaDeDiaria, double taxaNoturna,
	  double taxaMensal, double taxaDeEvento, LocalTime horarioAberturaDiurno,
	  LocalTime horarioFechamentoDiurno, LocalTime horarioAberturaNoturno,
	  LocalTime horarioFechamentoNoturno) {
		super();
		this.nome = nome;
		this.localizacao = localizacao;
		this.lotacaoMaxima = lotacaoMaxima;
		this.lotacaoAtual = lotacaoAtual;
		this.taxaDeFracao = taxaDeFracao;
		this.taxaDeHora = taxaDeHora;
		this.descontoPorHora = descontoPorHora;
		this.taxaDeDiaria = taxaDeDiaria;
		this.taxaNoturna = taxaNoturna;
		this.taxaMensal = taxaMensal;
		this.taxaDeEvento = taxaDeEvento;
		this.horarioAberturaDiurno = horarioAberturaDiurno;
		this.horarioFechamentoDiurno = horarioFechamentoDiurno;
		this.horarioAberturaNoturno = horarioAberturaNoturno;
		this.horarioFechamentoNoturno = horarioFechamentoNoturno;
	}

	public String getNome(){
		return this.nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public int getLotacaoMaxima() {
		return lotacaoMaxima;
	}

	public int getLotacaoAtual() {
		return lotacaoAtual;
	}

	public double getTaxaDeFracao() {
		return taxaDeFracao;
	}

	public double getTaxaDeHora() {
		return taxaDeHora;
	}

	public double getTaxaDeDiaria() {
		return taxaDeDiaria;
	}

	public double getTaxaNoturna() {
		return taxaNoturna;
	}

	public double getTaxaMensal() {
		return taxaMensal;
	}

	public double getTaxaDeEvento() {
		return taxaDeEvento;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public void setLotacaoMaxima(int lotacaoMaxima) {
		this.lotacaoMaxima = lotacaoMaxima;
	}

	public void setLotacaoAtual(int lotacaoAtual) {
		this.lotacaoAtual = lotacaoAtual;
	}

	public void setTaxaDeFracao(double taxaDeFracao) {
		this.taxaDeFracao = taxaDeFracao;
	}

	public void setTaxaDeHora(double taxaDeHora) {
		this.taxaDeHora = taxaDeHora;
	}

	public void setTaxaDeDiaria(double taxaDeDiaria) {
		this.taxaDeDiaria = taxaDeDiaria;
	}

	public void setTaxaNoturna(double taxaNoturna) {
		this.taxaNoturna = taxaNoturna;
	}

	public void setTaxaMensal(double taxaMensal) {
		this.taxaMensal = taxaMensal;
	}

	public void setTaxaDeEvento(double taxaDeEvento) {
		this.taxaDeEvento = taxaDeEvento;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public LocalTime getHorarioAberturaDiurno() {
		return horarioAberturaDiurno;
	}

	public void setHorarioAberturaDiurno(LocalTime horarioAberturaDiurno) {
		this.horarioAberturaDiurno = horarioAberturaDiurno;
	}

	public LocalTime getHorarioFechamentoDiurno() {
		return horarioFechamentoDiurno;
	}

	public void setHorarioFechamentoDiurno(LocalTime horarioFechamentoDiurno) {
		this.horarioFechamentoDiurno = horarioFechamentoDiurno;
	}

	public LocalTime getHorarioAberturaNoturno() {
		return horarioAberturaNoturno;
	}

	public void setHorarioAberturaNoturno(LocalTime horarioAberturaNoturno) {
		this.horarioAberturaNoturno = horarioAberturaNoturno;
	}

	public LocalTime getHorarioFechamentoNoturno() {
		return horarioFechamentoNoturno;
	}

	public void setHorarioFechamentoNoturno(LocalTime horarioFechamentoNoturno) {
		this.horarioFechamentoNoturno = horarioFechamentoNoturno;
	}

	public double getDescontoPorHora() {
		return descontoPorHora;
	}

	public void setDescontoPorHora(double descontoPorHora) {
		this.descontoPorHora = descontoPorHora;
	}

	@Override
	public String toString() {
		return "Estacionamento {" +
				"nome='" + this.getNome() + '\'' +
				", localizacao='" + this.getLocalizacao() + '\'' +
				", lotacaoMaxima=" + this.getLocalizacao() +
				", lotacaoAtual=" + this.getLotacaoAtual() +
				", taxaDeFracao=" + this.getTaxaDeFracao() +
				", taxaDeHora=" + this.getTaxaDeHora() +
				", descontoPorHora=" + this.getDescontoPorHora() +
				", taxaDeDiaria=" + this.getTaxaDeDiaria() +
				", taxaNoturna=" + this.getTaxaNoturna() +
				", taxaMensal=" + this.getTaxaMensal() +
				", taxaDeEvento=" + this.getTaxaDeEvento() +
				", horarioAberturaDiurno=" + this.getHorarioAberturaDiurno() +
				", horarioFechamentoDiurno=" + this.getHorarioFechamentoDiurno() +
				", horarioAberturaNoturno=" + this.getHorarioAberturaNoturno() +
				", horarioFechamentoNoturno=" + this.getHorarioFechamentoNoturno() +
				'}';
	}

	public void alterarDetalhes(String novoNomeEstacionamento, String novaLocalizacao, Integer novaLotacaoMaxima,
								Integer novaLotacaoAtual, Double novaTaxaDeFracao, Double novaTaxaDeHora, Double novoDescontoPorHora,
								Double novaTaxaDeDiaria, Double novaTaxaNoturna, Double novaTaxaMensal,
								Double novaTaxaDeEvento, LocalTime novoHorarioAberturaDiurno,
								LocalTime novoHorarioFechamentoDiurno, LocalTime novoHorarioAberturaNoturno,
								LocalTime novoHorarioFechamentoNoturno) {
		if (novoNomeEstacionamento != null) {
			this.setNome(novoNomeEstacionamento);
		}
		if (novaLocalizacao != null) {
			this.setLocalizacao(novaLocalizacao);
		}
		if (novaLotacaoMaxima != null) {
			this.setLotacaoMaxima(novaLotacaoMaxima);
		}
		if (novaLotacaoAtual != null) {
			this.setLotacaoAtual(novaLotacaoAtual);
		}
		if (novaTaxaDeFracao != null) {
			this.setTaxaDeFracao(novaTaxaDeFracao);
		}
		if (novaTaxaDeHora != null) {
			this.setTaxaDeHora(novaTaxaDeHora);
		}
		if (novoDescontoPorHora != null) {
			this.setDescontoPorHora(novoDescontoPorHora);
		}
		if (novaTaxaDeDiaria != null) {
			this.setTaxaDeDiaria(novaTaxaDeDiaria);
		}
		if (novaTaxaNoturna != null) {
			this.setTaxaNoturna(novaTaxaNoturna);
		}
		if (novaTaxaMensal != null) {
			this.setTaxaMensal(novaTaxaMensal);
		}
		if (novaTaxaDeEvento != null) {
			this.setTaxaDeEvento(novaTaxaDeEvento);
		}
		if (novoHorarioAberturaDiurno != null) {
			this.setHorarioAberturaDiurno(novoHorarioAberturaDiurno);
		}
		if (novoHorarioFechamentoDiurno != null) {
			this.setHorarioFechamentoDiurno(novoHorarioFechamentoDiurno);
		}
		if (novoHorarioAberturaNoturno != null) {
			this.setHorarioAberturaNoturno(novoHorarioAberturaNoturno);
		}
		if (novoHorarioFechamentoNoturno != null) {
			this.setHorarioFechamentoNoturno(novoHorarioFechamentoNoturno);
		}
	}

}
