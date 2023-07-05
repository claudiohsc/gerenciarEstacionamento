package model.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoPorFracao extends Acesso {
    public AcessoPorFracao(String placa, LocalDate dataEntrada, LocalDate dataSaida, LocalTime horaEntrada, LocalTime horaSaida) {
        super(placa, dataEntrada, dataSaida, horaEntrada, horaSaida);
    }

    @Override
    public double calcularTarifa(){
        Estacionamento estacionamento = this.getEstacionamento();
        if (estacionamento == null) {
            throw new RuntimeException("Estacionamento não definido para este acesso");
        }
        double taxaDeFracao = estacionamento.getTaxaDeFracao();

        // Calcula a duração total da estadia em minutos
        long duracao = java.time.Duration.between(this.getHoraEntrada().atDate(this.getDataEntrada()),
                this.getHoraSaida().atDate(this.getDataSaida())).toMinutes();

        // Calcula quantas frações de 15 minutos existem nessa duração
        // Observação: Estamos usando Math.ceil para arredondar para cima, assim se o carro ficou 16 minutos, ele será cobrado por duas frações
        long numeroDeFracoes = (long) Math.ceil(duracao / 15.0);

        // Retorna o valor da tarifa multiplicado pelo número de frações
        return numeroDeFracoes * taxaDeFracao;
    }
}
