package gerenciaEstacionamento;



public class AcessoFracao extends Acesso {
    

    public void calcularTarifa(){
        Double taxa = estacionamento.getTaxaDeFracao();
        String[] horarioEntrada = (veiculo.getHoraEntrada()).split(":"); // [hh, mm]
        String[] horarioSaida = (veiculo.getHoraSaida()).split(":");


        int horaEntrada = Integer.parseInt(horarioEntrada[0]);
        int minutoEntrada = Integer.parseInt(horarioEntrada[1]);

        int horaSaida = Integer.parseInt(horarioSaida[0]);
        int minutoSaida = Integer.parseInt(horarioSaida[1]);

        int minutosEntrada = (horaEntrada*60) + minutoEntrada;  //somatorio de minutos na entrada
        int minutosSaida = (horaSaida*60) + minutoSaida;

        int fracoes = (minutosSaida - minutosEntrada) / 15;  //encontra o numero de fracoes

        float valor = fracoes * taxa;

        veiculo.setValorAPagar(valor);

    }
}
