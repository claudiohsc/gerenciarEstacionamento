package model.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoPorHora extends Acesso{
    public AcessoPorHora(String placa, LocalDate dataEntrada, LocalDate dataSaida, LocalTime horaEntrada, LocalTime horaSaida) {
        super(placa, dataEntrada, dataSaida, horaEntrada, horaSaida);
    }

    @Override
    public double calcularTarifa() {
        Estacionamento estacionamento = this.getEstacionamento();
        if (estacionamento == null) {
            throw new RuntimeException("Estacionamento não definido para este acesso");
        }

        // Calcula a duração total da estadia em horas
        long duracao = java.time.Duration.between(this.getHoraEntrada().atDate(this.getDataEntrada()),
                this.getHoraSaida().atDate(this.getDataSaida())).toHours();

        // Tarifa por hora sem desconto
        double tarifaSemDesconto = duracao * estacionamento.getTaxaDeHora();

        // Desconto
        double desconto = estacionamento.getDescontoPorHora() * tarifaSemDesconto;

        // Retorna o valor da tarifa com desconto
        return tarifaSemDesconto - desconto;
    }

}
