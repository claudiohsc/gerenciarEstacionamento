package model.dominio;

import java.util.List;

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
		return nome;
	}

}
