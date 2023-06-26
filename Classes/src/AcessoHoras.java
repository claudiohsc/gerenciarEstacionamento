package gerenciaEstacionamento;


public class AcessoHoras extends Acesso {
    
    //só deve ser realizado após confirmar que o acesso foi somente por horas cheias;

    public void calcularTarifa(){
        Double taxa = estacionamento.getTaxaDeFracao();
        Double desconto = estacionamento.getTaxaDeHora();
        String[] horarioEntrada = (veiculo.getHoraEntrada()).split(":"); // [hh, mm]
        String[] horarioSaida = (veiculo.getHoraSaida()).split(":");


        int horaEntrada = Integer.parseInt(horarioEntrada[0]);

        int horaSaida = Integer.parseInt(horarioSaida[0]);

        int fracoes = (horaSaida - horaEntrada);  //encontra o numero de fracoes;

        float valor = (fracoes * taxa) - ((fracoes*taxa)*(desconto/100));  // total - desconto;

        veiculo.setValorAPagar(valor);

    }
}
