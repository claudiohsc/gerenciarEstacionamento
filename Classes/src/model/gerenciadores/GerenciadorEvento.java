package model.gerenciadores;

import model.dominio.Evento;

public class GerenciadorEvento extends Gerenciador<Evento>{
    @Override
    public void criar(Evento evento) {
        registros.put(evento.getNome(), evento);
    }

    @Override
    public Evento pesquisar(String nome) {
        return registros.get(nome);
    }

    @Override
    public void alterar(Evento evento) {
        registros.put(evento.getNome(), evento);
    }

    @Override
    public void excluir(String nome) {
        registros.remove(nome);
    }
}
