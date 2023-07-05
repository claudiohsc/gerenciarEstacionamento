package model.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoPorDiariaNoturna extends Acesso {
    public AcessoPorDiariaNoturna(String placa, LocalDate dataEntrada, LocalDate dataSaida, LocalTime horaEntrada, LocalTime horaSaida) {
        super(placa, dataEntrada, dataSaida, horaEntrada, horaSaida);
    }

    @Override
    public double calcularTarifa() {
        Estacionamento estacionamento = this.getEstacionamento();
        if (estacionamento == null) {
            throw new RuntimeException("Estacionamento não definido para este acesso");
        }

        LocalTime horaInicioNoturno = estacionamento.getHorarioAberturaNoturno();
        LocalTime horaFimNoturno = estacionamento.getHorarioFechamentoNoturno();

        // Verifica se a entrada e a saída do veículo estão dentro do período noturno
        if ((this.getHoraEntrada().isAfter(horaInicioNoturno) || this.getHoraEntrada().equals(horaInicioNoturno))
                && (this.getHoraSaida().isBefore(horaFimNoturno) || this.getHoraSaida().equals(horaFimNoturno))) {
            // Se a estadia for noturna, cobra a tarifa diária noturna
            double tarifaDiariaDiurna = estacionamento.getTaxaDeDiaria();
            double percentualDiariaNoturna = estacionamento.getTaxaNoturna();
            return tarifaDiariaDiurna * percentualDiariaNoturna / 100;
        } else {
            // Se a estadia não for totalmente noturna, cobra a tarifa diária diurna
            return estacionamento.getTaxaDeDiaria();
        }
    }

}
