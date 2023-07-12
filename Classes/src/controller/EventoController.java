package controller;

import model.dominio.Evento;
import model.gerenciadores.GerenciadorEvento;
import view.DescricaoEmBrancoException;
import view.MenuView;
import view.ObjetoNaoEncontradoException;


public class EventoController {
    private final GerenciadorEvento gerenciadorEvento;
    private final MenuView menuView;

    public EventoController(GerenciadorEvento gerenciadorEvento, MenuView menuView){
        this.menuView = menuView;
        this.gerenciadorEvento = gerenciadorEvento;
    }

    public void criar() {
        Evento evento = new Evento();

        try {
            evento.setNome(menuView.getString("o nome do evento"));
            evento.setDataInicio(menuView.getData("o data início do evento"));
            evento.setDataFim(menuView.getData("o data fim do evento"));
            evento.setHoraInicio(menuView.getHora("o hora início do evento"));
            evento.setHoraFim(menuView.getHora("o hora fim do evento"));
        } catch (DescricaoEmBrancoException e) {
            menuView.printExceptionMessage(e);
        }
        gerenciadorEvento.criar(evento);
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
            while (true){
                int opcaoAlterarEvento = menuView.getOpcaoSubMenu("alteração do evento", "1. Nome do Evento\n2. Data Início" +
                        "\n3. Data Fim\n4. Hora Início\n5. Hora Fim\n6. Concluir alterações");

                try {
                    switch (opcaoAlterarEvento){
                        case 1:
                            evento.setNome(menuView.getString("o novo nome do evento"));
                            break;
                        case 2:
                            evento.setDataInicio(menuView.getData("a nova data início"));
                            break;
                        case 3:
                            evento.setDataFim(menuView.getData("a nova data fim"));
                            break;
                        case 4:
                            evento.setHoraInicio(menuView.getHora("a nova hora início"));
                            break;
                        case 5:
                            evento.setHoraFim(menuView.getHora("a nova hora fim"));
                            break;
                        case 6:
                            gerenciadorEvento.alterar(evento);
                            return;
                        default:
                            menuView.printOpcaoInvalida();
                            break;
                    }
                } catch (DescricaoEmBrancoException e) {
                    menuView.printExceptionMessage(e);
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
