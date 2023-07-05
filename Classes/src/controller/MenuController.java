package controller;

import model.dominio.Acesso;
import model.dominio.Estacionamento;
import model.dominio.Evento;
import model.gerenciadores.GerenciadorAcesso;
import model.gerenciadores.GerenciadorEstacionamento;
import model.gerenciadores.GerenciadorEvento;
import view.ObjetoNaoEncontradoException;
import view.MenuView;

import java.time.LocalDate;
import java.time.LocalTime;

public class MenuController {
    private final GerenciadorAcesso gerenciadorAcesso;
    private final GerenciadorEstacionamento gerenciadorEstacionamento;
    private final GerenciadorEvento gerenciadorEvento;
    private final MenuView menuView;
    private final AcessoController acessoController;
    private final EstacionamentoController estacionamentoController;
    private final EventoController eventoController;

    public MenuController(GerenciadorAcesso gerenciadorAcesso,
                          GerenciadorEstacionamento gerenciadorEstacionamento,
                          GerenciadorEvento gerenciadorEvento,
                          MenuView menuView, AcessoController acessoController,
                          EstacionamentoController estacionamentoController,
                          EventoController eventoController){
        this.gerenciadorAcesso = gerenciadorAcesso;
        this.gerenciadorEstacionamento = gerenciadorEstacionamento;
        this.gerenciadorEvento = gerenciadorEvento;
        this.menuView = menuView;
        this.acessoController = acessoController;
        this.estacionamentoController = estacionamentoController;
        this.eventoController = eventoController;
    }

    public void iniciar () {
        boolean sair = false;

        while (!sair) {
            int opcao = menuView.getOpcaoMenuPrincipal();

            switch (opcao) {
                case 1:
                    criar();
                    break;
                case 2:
                    pesquisar();
                    break;
                case 3:
                    alterar();
                    break;
                case 4:
                    excluir();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    menuView.printOpcaoInvalida();
                    break;
            }
        }

        menuView.closeScanner();
    }

    private void criar() {
        int opcaoCriar = menuView.getOpcaoSubMenu("criação", "1. Acesso\n2. Estacionamento\n3. Evento");
        switch (opcaoCriar) {
            case 1:
                acessoController.criar();
                break;
            case 2:
                estacionamentoController.criar();
                break;
            case 3:
                eventoController.criar();
                break;
            default:
                menuView.printOpcaoInvalida();
                break;
        }
    }

    private void pesquisar (){
        int opcaoPesquisar = menuView.getOpcaoSubMenu("pesquisa", "1. Acesso\n2. Estacionamento\n3. Evento");
        switch (opcaoPesquisar) {
            case 1:
                acessoController.pesquisar();
                break;
            case 2:
                estacionamentoController.pesquisar();
                break;
            case 3:
                eventoController.pesquisar();
                break;
            default:
                menuView.printOpcaoInvalida();
                break;
        }
    }

    private void alterar (){
        int opcaoAlterar = menuView.getOpcaoSubMenu("alteração", "1. Acesso\n2. Estacionamento\n3. Evento");
        switch (opcaoAlterar) {
            case 1:
                acessoController.alterar();
                break;
            case 2:
                estacionamentoController.alterar();
                break;
            case 3:
                eventoController.alterar();
                break;
            default:
                menuView.printOpcaoInvalida();
                break;
        }
    }

    private void excluir (){
        int opcaoExcluir = menuView.getOpcaoSubMenu("exclusão", "1. Acesso\n2. Estacionamento\n3. Evento");
        boolean excluido;
        switch (opcaoExcluir) {
            case 1:
                acessoController.excluir();
                break;
            case 2:
                estacionamentoController.excluir();
                break;
            case 3:
                eventoController.excluir();
                break;
            default:
                menuView.printOpcaoInvalida();
                break;
        }
    }
}
