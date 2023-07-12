package model.gerenciadores;

import model.dominio.Evento;
import view.DescricaoEmBrancoException;
import view.ObjetoNaoEncontradoException;

public class GerenciadorEvento extends Gerenciador<Evento>{
    @Override
    public void criar(Evento evento) {
        registros.put(evento.getNome(), evento);
    }

    @Override
    public void alterar(Evento evento) {
        registros.put(evento.getNome(), evento);
    }
}
