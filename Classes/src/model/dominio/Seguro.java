package model.dominio;

public class Seguro {
	private Seguradora seguradora;

	private String numeroApolice;

	public Seguro (Seguradora seguradora, String numeroApolice){
		this.seguradora = seguradora;
		this.numeroApolice = numeroApolice;
	}

}
