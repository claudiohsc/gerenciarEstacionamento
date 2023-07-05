package model.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoPorEvento extends Acesso{
    public AcessoPorEvento(String placa, LocalDate dataEntrada, LocalDate dataSaida, LocalTime horaEntrada, LocalTime horaSaida) {
        super(placa, dataEntrada, dataSaida, horaEntrada, horaSaida);
    }

    @Override
    public double calcularTarifa() {
        Estacionamento estacionamento = this.getEstacionamento();
        if (estacionamento == null) {
            throw new RuntimeException("Estacionamento não definido para este acesso");
        }

        // Retorna a tarifa de evento do estacionamento
        return estacionamento.getTaxaDeEvento();
    }
}
