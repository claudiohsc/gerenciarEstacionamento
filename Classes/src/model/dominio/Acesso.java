package model.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Acesso {

	private String placa;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;

	public Acesso(String placa, LocalDate dataEntrada, LocalDate dataSaida, LocalTime horaEntrada, LocalTime horaSaida) {
		this.placa = placa;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}

	public double calcularTarifa () {

		return 0;
	}

	public String getPlaca(){
		return placa;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public LocalTime getHoraSaida() {
		return horaSaida;
	}
}
