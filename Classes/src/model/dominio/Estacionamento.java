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
}
