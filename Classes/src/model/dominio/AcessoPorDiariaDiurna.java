package model.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoPorDiariaDiurna extends Acesso{
    public AcessoPorDiariaDiurna(String placa, LocalDate dataEntrada, LocalDate dataSaida, LocalTime horaEntrada, LocalTime horaSaida) {
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

        // Se a duração for superior a 9 horas, cobra a tarifa diária diurna
        if (duracao > 9) {
            return estacionamento.getTaxaDeDiaria();
        } else {
            // Caso contrário, cobra a tarifa por hora para a duração
            return duracao * estacionamento.getTaxaDeHora();
        }
    }
}
