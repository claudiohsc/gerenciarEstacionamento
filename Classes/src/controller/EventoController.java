package controller;

import model.dominio.Evento;
import model.gerenciadores.GerenciadorEvento;
import view.DescricaoEmBrancoException;
import view.MenuView;
import view.ObjetoNaoEncontradoException;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventoController {
    private final GerenciadorEvento gerenciadorEvento;
    private final MenuView menuView;

    public EventoController(GerenciadorEvento gerenciadorEvento, MenuView menuView){
        this.menuView = menuView;
        this.gerenciadorEvento = gerenciadorEvento;
    }

    public void criar() {
        Evento evento = menuView.getDetalhesDeEvento();
        try {
            gerenciadorEvento.criar(evento);
        } catch (DescricaoEmBrancoException e) {
            menuView.printExceptionMessage(e);
        }
    }

    public void pesquisar() {
        String nomeEvento = menuView.getString("o nome do evento para pesquisa");
        try {
            Evento evento = gerenciadorEvento.pesquisar(nomeEvento);
            System.out.println(evento.toString());
        } catch (ObjetoNaoEncontradoException e) {
            menuView.printExceptionMessage(e);
        }
    }

    public void alterar() {
        String nomeEvento = menuView.getString("o nome do evento para alteração");
        Evento evento = gerenciadorEvento.pesquisar(nomeEvento);

        if (evento != null) {
            String novoNomeEvento = null;
            LocalDate novaDataInicio = null;
            LocalDate novaDataFim = null;
            LocalTime novaHoraInicio = null;
            LocalTime novaHoraFim = null;

            while (true){
                int opcaoAlterarEvento = menuView.getOpcaoSubMenu("alteração do evento", "1. Nome do Evento\n2. Data Início" +
                        "\n3. Data Fim\n4. Hora Início\n5. Hora Fim\n6. Concluir alterações");

                switch (opcaoAlterarEvento){
                    case 1:
                        novoNomeEvento = menuView.getString("o novo nome do evento");
                        break;
                    case 2:
                        novaDataInicio = menuView.getData("a nova data início");
                        break;
                    case 3:
                        novaDataFim = menuView.getData("a nova data fim");
                        break;
                    case 4:
                        novaHoraInicio = menuView.getHora("a nova hora início");
                        break;
                    case 5:
                        novaHoraFim = menuView.getHora("a nova hora fim");
                        break;
                    case 6:
                        evento.alterarDetalhes(novoNomeEvento, novaDataInicio, novaDataFim, novaHoraInicio, novaHoraFim);
                        gerenciadorEvento.alterar(evento);
                        return;
                    default:
                        menuView.printOpcaoInvalida();
                        break;
                }
            }
        }
    }

    public void excluir() {
        String nomeEvento = menuView.getString("o nome do evento para exclusão");
        try {
            boolean excluido = gerenciadorEvento.excluir(nomeEvento);
            menuView.printResultadoExclusao(excluido, "Evento");
        } catch (ObjetoNaoEncontradoException e) {
            menuView.printExceptionMessage(e);
        }
    }
}
