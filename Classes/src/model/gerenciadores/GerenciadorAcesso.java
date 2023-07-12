package model.gerenciadores;

import model.dominio.*;
import view.DescricaoEmBrancoException;
import view.ObjetoNaoEncontradoException;

import java.time.Duration;
import java.time.LocalTime;

public class GerenciadorAcesso extends Gerenciador<Acesso>{
    @Override
    public void criar(Acesso acesso)  {
        Estacionamento estacionamento = acesso.getEstacionamento();
        acesso = this.inferirTipoDeAcesso(acesso, estacionamento);
        registros.put(acesso.getPlaca(), acesso);
    }

    @Override
    public void alterar(Acesso acesso) {
        registros.put(acesso.getPlaca(), acesso);
    }

    public Acesso inferirTipoDeAcesso(Acesso acesso, Estacionamento estacionamento) {
        LocalTime horaEntrada = acesso.getHoraEntrada();
        LocalTime horaSaida = acesso.getHoraSaida();
        Duration duracao = Duration.between(horaEntrada, horaSaida);

        // Horários de funcionamento do estacionamento
        LocalTime inicioFuncionamento = estacionamento.getHorarioAberturaDiurno();
        LocalTime fimFuncionamento = estacionamento.getHorarioFechamentoDiurno();

        // Faixa de horário noturna
        LocalTime inicioNoturno = estacionamento.getHorarioAberturaNoturno();
        LocalTime fimNoturno = estacionamento.getHorarioFechamentoNoturno();

        if (horaEntrada.isAfter(inicioFuncionamento) && horaSaida.isBefore(fimFuncionamento)) {
            if (duracao.toMinutes() <= 60) {
                return new AcessoPorFracao(acesso.getPlaca(), acesso.getDataEntrada(), acesso.getDataSaida(),
                        horaEntrada, horaSaida);
            } else {
                return new AcessoPorHora(acesso.getPlaca(), acesso.getDataEntrada(), acesso.getDataSaida(),
                        horaEntrada, horaSaida);
            }
        } else if (horaEntrada.isAfter(inicioFuncionamento) && horaSaida.isAfter(inicioNoturno) && horaSaida.isBefore(fimNoturno)) {
            return new AcessoPorDiariaNoturna(acesso.getPlaca(), acesso.getDataEntrada(), acesso.getDataSaida(),
                    horaEntrada, horaSaida);
        } else {
            return new AcessoPorDiariaDiurna(acesso.getPlaca(), acesso.getDataEntrada(), acesso.getDataSaida(),
                    horaEntrada, horaSaida);
        }
    }
}
