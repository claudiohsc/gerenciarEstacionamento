package model.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoPorDiariaMensalista extends Acesso{
    public AcessoPorDiariaMensalista(String placa, LocalDate dataEntrada, LocalDate dataSaida, LocalTime horaEntrada, LocalTime horaSaida) {
        super(placa, dataEntrada, dataSaida, horaEntrada, horaSaida);
    }

    @Override
    public double calcularTarifa(){
        return 0;
    }
}
