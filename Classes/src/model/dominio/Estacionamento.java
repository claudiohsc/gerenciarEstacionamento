package model.dominio;

import java.util.List;

public class Estacionamento {

	private String nome;
	private String localizacao;
	private int lotacaoMaxima;
	private int lotacaoAtual;
	private double taxaDeFracao;
	private double taxaDeHora;
	private double taxaDeDiaria;
	private double taxaNoturna;
	private double taxaMensal;
	private double taxaDeEvento;
	private List<Veiculo> veiculos;

	public Estacionamento() {

	}

	//
	public Estacionamento(String nome, String localizacao, int lotacaoMaxima, int lotacaoAtual, Double taxaDeFracao,
			Double taxaDeHora, Double taxaDeDiaria, Double taxaNoturna, Double taxaMensal, Double taxaDeEvento) {
		super();
		this.nome = nome;
		this.localizacao = localizacao;
		this.lotacaoMaxima = lotacaoMaxima;
		this.lotacaoAtual = lotacaoAtual;
		this.taxaDeFracao = taxaDeFracao;
		this.taxaDeHora = taxaDeHora;
		this.taxaDeDiaria = taxaDeDiaria;
		this.taxaNoturna = taxaNoturna;
		this.taxaMensal = taxaMensal;
		this.taxaDeEvento = taxaDeEvento;
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

	@Override
	public String toString() {
		return "Estacionamento {" +
				"nome='" + this.getNome() + '\'' +
				", localizacao='" + this.getLocalizacao() + '\'' +
				", lotacaoMaxima=" + this.getLocalizacao() +
				", lotacaoAtual=" + this.getLotacaoAtual() +
				", taxaDeFracao=" + this.getTaxaDeFracao() +
				", taxaDeHora=" + this.getTaxaDeHora() +
				", taxaDeDiaria=" + this.getTaxaDeDiaria() +
				", taxaNoturna=" + this.getTaxaNoturna() +
				", taxaMensal=" + this.getTaxaMensal() +
				", taxaDeEvento=" + this.getTaxaDeEvento() +
				'}';
	}
}
