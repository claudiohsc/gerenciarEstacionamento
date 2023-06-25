package gerenciaEstacionamento;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;



public class Veiculo {

	private String placa;
	private String modelo;
	
	private Date hoje = new Date();
	
	//Locale.setDefault()
	
	String hojeFormat = DateFormat.getInstance().format(hoje);
	
	
	
	private Date horaEntrada;
	private Date horaSaida;
	
	private float valorAPagar;
	
	public void entrarEstacionamento() {
		
	}
	
	public void sairEstacionamento() {
		
	}
}
