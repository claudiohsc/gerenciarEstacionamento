package gerenciaEstacionamento;

import java.text.*;

public class Estacionamento {

	private String nome;
	private String localizacao;
	private int lotacaoMaxima;
	private int lotacaoAtual;
	private Double taxaDeFracao;
	private Double taxaDeHora;
	private Double taxaDeDiaria;
	private Double taxaNoturna;
	private Double taxaMensal;
	private Double taxaDeEvento;
	private SimpleDateFormat horarioAbertura;
	private SimpleDateFormat horaioFechamento;
	private Double retornoContratante;

	public void adicionarVeiculo() {

	}

	public void removerVeiculo() {

	}

	public Boolean verificarLotacao() {
		return null;
		
	}

	public Double calcularTaxa() {
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getLotacaoMaxima() {
		return lotacaoMaxima;
	}

	public void setLotacaoMaxima(int lotacaoMaxima) {
		this.lotacaoMaxima = lotacaoMaxima;
	}

	public int getLotacaoAtual() {
		return lotacaoAtual;
	}

	public void setLotacaoAtual(int lotacaoAtual) {
		this.lotacaoAtual = lotacaoAtual;
	}

	public Double getTaxaDeFracao() {
		return taxaDeFracao;
	}

	public void setTaxaDeFracao(Double taxaDeFracao) {
		this.taxaDeFracao = taxaDeFracao;
	}

	public Double getTaxaDeHora() {
		return taxaDeHora;
	}

	public void setTaxaDeHora(Double taxaDeHora) {
		this.taxaDeHora = taxaDeHora;
	}

	public Double getTaxaDeDiaria() {
		return taxaDeDiaria;
	}

	public void setTaxaDeDiaria(Double taxaDeDiaria) {
		this.taxaDeDiaria = taxaDeDiaria;
	}

	public Double getTaxaNoturna() {
		return taxaNoturna;
	}

	public void setTaxaNoturna(Double taxaNoturna) {
		this.taxaNoturna = taxaNoturna;
	}

	public Double getTaxaMensal() {
		return taxaMensal;
	}

	public void setTaxaMensal(Double taxaMensal) {
		this.taxaMensal = taxaMensal;
	}

	public Double getTaxaDeEvento() {
		return taxaDeEvento;
	}

	public void setTaxaDeEvento(Double taxaDeEvento) {
		this.taxaDeEvento = taxaDeEvento;
	}

	public SimpleDateFormat getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(SimpleDateFormat horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public SimpleDateFormat getHoraioFechamento() {
		return horaioFechamento;
	}

	public void setHoraioFechamento(SimpleDateFormat horaioFechamento) {
		this.horaioFechamento = horaioFechamento;
	}

	public Double getRetornoContratante() {
		return retornoContratante;
	}

	public void setRetornoContratante(Double retornoContratante) {
		this.retornoContratante = retornoContratante;
	}
	
	
}
