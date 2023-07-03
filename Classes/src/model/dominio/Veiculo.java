package model.dominio;

public class Veiculo {

	private String placa;
	private Seguro seguro;

	//SimpleDateFormat formatarDataHora = new SimpleDateFormat("dd/M/yy hh:mm:ss");

	//private String hoje = formatarDataHora.format(new Date());

	public Veiculo(String placa, Seguro seguro){
		this.placa = placa;
		this.seguro = seguro;
	}

}
