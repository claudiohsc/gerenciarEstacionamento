package model.dominio;

import view.DescricaoEmBrancoException;

import java.time.LocalDate;
import java.time.LocalTime;

public class Acesso {

	private String placa;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	private Estacionamento estacionamento;

	public Acesso() {
	}

	public Acesso(String placa, LocalDate dataEntrada, LocalDate dataSaida, LocalTime horaEntrada, LocalTime horaSaida) {
		this.placa = placa;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}

	public double calcularTarifa() {
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

	public void setPlaca(String placa) throws DescricaoEmBrancoException {
		if (placa == null || placa.trim().isEmpty()) {
			throw new DescricaoEmBrancoException("Placa");
		}
		this.placa = placa;
	}

	public void setDataEntrada(LocalDate dataEntrada) throws DescricaoEmBrancoException {
		if (dataEntrada == null) {
			throw new DescricaoEmBrancoException("Data Entrada");
		}
		this.dataEntrada = dataEntrada;
	}

	public void setDataSaida(LocalDate dataSaida) throws DescricaoEmBrancoException {
		if (dataSaida == null) {
			throw new DescricaoEmBrancoException("Data Saída");
		}
		this.dataSaida = dataSaida;
	}

	public void setHoraEntrada(LocalTime horaEntrada) throws DescricaoEmBrancoException {
		if (horaEntrada == null) {
			throw new DescricaoEmBrancoException("Hora Entrada");
		}
		this.horaEntrada = horaEntrada;
	}

	public void setHoraSaida(LocalTime horaSaida) throws DescricaoEmBrancoException {
		if (horaSaida == null) {
			throw new DescricaoEmBrancoException("Hora Saída");
		}
		this.horaSaida = horaSaida;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	@Override
	public String toString(){
		return "Acesso {" +
				"placa='" + this.getPlaca() + '\'' +
				", dataEntrada=" + this.getDataEntrada() +
				", dataSaida=" + this.getDataSaida() +
				", horaEntrada='" + this.getHoraEntrada() + '\'' +
				", horaSaida='" + this.getHoraSaida() + '\'' +
				", estacionamento='" + this.getEstacionamento().getNome() + '\'' +
				'}';
	}

}
