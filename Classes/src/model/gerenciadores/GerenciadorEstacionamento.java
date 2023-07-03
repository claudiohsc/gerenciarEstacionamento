package model.gerenciadores;

import model.dominio.Estacionamento;

public class GerenciadorEstacionamento extends Gerenciador<Estacionamento>{
    @Override
    public void criar(Estacionamento estacionamento) {
        registros.put(estacionamento.getNome(), estacionamento);
    }

    @Override
    public Estacionamento pesquisar(String nome) {
        return registros.get(nome);
    }

    @Override
    public void alterar(Estacionamento estacionamento) {
        registros.put(estacionamento.getNome(), estacionamento);
    }

    @Override
    public void excluir(String nome) {
        registros.remove(nome);
    }
}
