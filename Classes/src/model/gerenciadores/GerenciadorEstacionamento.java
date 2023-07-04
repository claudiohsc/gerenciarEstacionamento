package model.gerenciadores;

import model.dominio.Estacionamento;
import view.DescricaoEmBrancoException;
import view.ObjetoNaoEncontradoException;

public class GerenciadorEstacionamento extends Gerenciador<Estacionamento>{
    @Override
    public void criar(Estacionamento estacionamento) throws DescricaoEmBrancoException {

        if (estacionamento.getLotacaoMaxima() == 0 || estacionamento.getTaxaDeFracao() == 0.0 || estacionamento.getTaxaDeHora() == 0.0
                || estacionamento.getTaxaDeDiaria() == 0.0 || estacionamento.getTaxaNoturna() == 0.0) {
            throw new DescricaoEmBrancoException("Os campos obirgatórios não foram preenchidos.");
        }
        registros.put(estacionamento.getNome(), estacionamento);
    }

    @Override
    public void alterar(Estacionamento estacionamento) {
        registros.put(estacionamento.getNome(), estacionamento);
    }

    @Override
    public boolean excluir(String nomeEstacionamento) throws ObjetoNaoEncontradoException {
        Estacionamento estacionamento = pesquisar(nomeEstacionamento);
        return registros.remove(nomeEstacionamento, estacionamento);
    }
}
