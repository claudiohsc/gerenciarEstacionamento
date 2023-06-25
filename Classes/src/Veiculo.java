package gerenciaEstacionamento;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Veiculo {

	private String placa;
	private String modelo;
	
	
	SimpleDateFormat formatarDataHora = new SimpleDateFormat("dd/M/yy hh:mm:ss");
	
	private String hoje = formatarDataHora.format(new Date());
	
		
	private Boolean verificacao = false;
	
	private String horaEntrada; // "dd/mm/yy hh:mm:ss"
	private String horaSaida;  // "dd/mm/yy hh:mm:ss"
	
	private float valorAPagar; // xx.xx
	
	public Veiculo(String placa, String modelo, String horaEntrada, String horaSaida, Boolean verificacao) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.verificacao = verificacao;
	}


	public void entrarEstacionamento() {
		if(this.verificacao == false) {
			this.verificacao = true;
			System.out.println("O veículo entrou no estacionamento!");
		}
		else {
			System.out.println("O veículo já está dentro do estacionamento!");
		}
	}
	
	public void sairEstacionamento() {
		if(this.verificacao == true) {
			this.verificacao = false;
			System.out.println("O veículo saiu do estacionamento!");
		}
		else {
			System.out.println("O veículo já saiu do estacionamento!");
		}
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public float getValorAPagar() {
		return valorAPagar;
	}

	public void setValorAPagar(float valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
}
