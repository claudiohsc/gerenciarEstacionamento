package model.gerenciadores;

import model.dominio.Estacionamento;
import view.DescricaoEmBrancoException;
import view.ObjetoNaoEncontradoException;

public class GerenciadorEstacionamento extends Gerenciador<Estacionamento>{
    @Override
    public void criar(Estacionamento estacionamento) {
        registros.put(estacionamento.getNome(), estacionamento);
    }

    @Override
    public void alterar(Estacionamento estacionamento) {
        registros.put(estacionamento.getNome(), estacionamento);
    }

}
