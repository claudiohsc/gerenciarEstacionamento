package model.dominio;

import view.DescricaoEmBrancoException;

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

	public void setNome(String nome) throws DescricaoEmBrancoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new DescricaoEmBrancoException("Nome do Estacionamento");
		}
		this.nome = nome;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public void setLotacaoMaxima(int lotacaoMaxima) throws DescricaoEmBrancoException {
		if (lotacaoMaxima == 0) {
			throw new DescricaoEmBrancoException("Lotação Máxima");
		}
		this.lotacaoMaxima = lotacaoMaxima;
	}

	public void setLotacaoAtual(int lotacaoAtual) {
		this.lotacaoAtual = lotacaoAtual;
	}

	public void setTaxaDeFracao(double taxaDeFracao) throws DescricaoEmBrancoException {
		if (taxaDeFracao == 0) {
			throw new DescricaoEmBrancoException("Taxa de Fração");
		}
		this.taxaDeFracao = taxaDeFracao;
	}

	public void setTaxaDeHora(double taxaDeHora) throws DescricaoEmBrancoException {
		if (taxaDeHora == 0) {
			throw new DescricaoEmBrancoException("Taxa de Hora Cheia");
		}
		this.taxaDeHora = taxaDeHora;
	}

	public void setTaxaDeDiaria(double taxaDeDiaria) throws DescricaoEmBrancoException {
		if (taxaDeDiaria == 0) {
			throw new DescricaoEmBrancoException("Taxa de Diária");
		}
		this.taxaDeDiaria = taxaDeDiaria;
	}

	public void setTaxaNoturna(double taxaNoturna) throws DescricaoEmBrancoException {
		if (taxaNoturna == 0) {
			throw new DescricaoEmBrancoException("Taxa Noturna");
		}
		this.taxaNoturna = taxaNoturna;
	}

	public void setTaxaMensal(double taxaMensal) throws DescricaoEmBrancoException {
		if (taxaMensal == 0) {
			throw new DescricaoEmBrancoException("Taxa Mensal");
		}
		this.taxaMensal = taxaMensal;
	}

	public void setTaxaDeEvento(double taxaDeEvento) throws DescricaoEmBrancoException {
		if (taxaDeEvento == 0) {
			throw new DescricaoEmBrancoException("Taxa de Evento");
		}
		this.taxaDeEvento = taxaDeEvento;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public LocalTime getHorarioAberturaDiurno() {
		return horarioAberturaDiurno;
	}

	public void setHorarioAberturaDiurno(LocalTime horarioAberturaDiurno) throws DescricaoEmBrancoException {
		if (horarioAberturaDiurno == null) {
			throw new DescricaoEmBrancoException("Horário de Abertura Diurno");
		}
		this.horarioAberturaDiurno = horarioAberturaDiurno;
	}

	public LocalTime getHorarioFechamentoDiurno() {
		return horarioFechamentoDiurno;
	}

	public void setHorarioFechamentoDiurno(LocalTime horarioFechamentoDiurno) throws DescricaoEmBrancoException {
		if (horarioFechamentoDiurno == null) {
			throw new DescricaoEmBrancoException("Horário de Fechamento Diurno");
		}
		this.horarioFechamentoDiurno = horarioFechamentoDiurno;
	}

	public LocalTime getHorarioAberturaNoturno() {
		return horarioAberturaNoturno;
	}

	public void setHorarioAberturaNoturno(LocalTime horarioAberturaNoturno) throws DescricaoEmBrancoException {
		if (horarioAberturaNoturno == null) {
			throw new DescricaoEmBrancoException("Horário de Abertura Noturno");
		}
		this.horarioAberturaNoturno = horarioAberturaNoturno;
	}

	public LocalTime getHorarioFechamentoNoturno() {
		return horarioFechamentoNoturno;
	}

	public void setHorarioFechamentoNoturno(LocalTime horarioFechamentoNoturno) throws DescricaoEmBrancoException {
		if (horarioFechamentoNoturno == null) {
			throw new DescricaoEmBrancoException("Horário de Fechamento Noturno");
		}
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

}
