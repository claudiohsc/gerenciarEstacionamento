package model.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoPorDiariaMensalista extends Acesso{
    public AcessoPorDiariaMensalista(String placa, LocalDate dataEntrada, LocalDate dataSaida, LocalTime horaEntrada, LocalTime horaSaida) {
        super(placa, dataEntrada, dataSaida, horaEntrada, horaSaida);
    }

    @Override
    public double calcularTarifa() {
        Estacionamento estacionamento = this.getEstacionamento();
        if (estacionamento == null) {
            throw new RuntimeException("Estacionamento não definido para este acesso");
        }

        // Retorna a tarifa mensalista do estacionamento
        return estacionamento.getTaxaMensal();
    }

}
