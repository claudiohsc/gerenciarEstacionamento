package model.gerenciadores;

import model.dominio.Evento;
import view.DescricaoEmBrancoException;

public class GerenciadorEvento extends Gerenciador<Evento>{
    @Override
    public void criar(Evento evento) throws DescricaoEmBrancoException {
        if (evento.getNome() == null || evento.getDataInicio() == null || evento.getDataFim() == null
            || evento.getHoraInicio() == null || evento.getHoraFim() == null){
            throw new DescricaoEmBrancoException("Os campos obrigatórios não foram preenchidos.");
        }
        registros.put(evento.getNome(), evento);
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
