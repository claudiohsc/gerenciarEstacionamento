package controller;

import model.dominio.Acesso;
import model.gerenciadores.GerenciadorAcesso;
import model.gerenciadores.GerenciadorEstacionamento;
import model.gerenciadores.GerenciadorEvento;
import view.DescricaoEmBrancoException;
import view.MenuView;

public class MenuController {
    private final GerenciadorAcesso gerenciadorAcesso;
    private final GerenciadorEstacionamento gerenciadorEstacionamento;
    private final GerenciadorEvento gerenciadorEvento;
    private final MenuView menuView;

    public MenuController(){
        gerenciadorAcesso = new GerenciadorAcesso();
        gerenciadorEstacionamento = new GerenciadorEstacionamento();
        gerenciadorEvento = new GerenciadorEvento();
        menuView = new MenuView();
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

    private void criar (){
        int opcaoCriar = menuView.getOpcaoSubMenu("criação");
        switch (opcaoCriar) {
            case 1:
                Acesso acesso = menuView.getDetalhesDeAcesso();
                try {
                    gerenciadorAcesso.criar(acesso);
                } catch (DescricaoEmBrancoException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                // Código para criar estacionamento
                break;
            case 3:
                // Código para criar evento
                break;
            default:
                menuView.printOpcaoInvalida();
                break;
        }
    }

    private void pesquisar (){
        int opcaoPesquisar = menuView.getOpcaoSubMenu("pesquisa");
        switch (opcaoPesquisar) {
            case 1:
                // Código para pesquisar acesso
                break;
            case 2:
                // Código para pesquisar estacionamento
                break;
            case 3:
                // Código para pesquisar evento
                break;
            default:
                menuView.printOpcaoInvalida();
                break;
        }
    }

    private void alterar (){
        int opcaoAlterar = menuView.getOpcaoSubMenu("alteração");
        switch (opcaoAlterar) {
            case 1:
                // Código para alterar acesso
                Acesso acesso;

                break;
            case 2:
                // Código para alterar estacionamento
                break;
            case 3:
                // Código para alterar evento
                break;
            default:
                menuView.printOpcaoInvalida();
                break;
        }
    }

    private void excluir (){
        int opcaoExcluir = menuView.getOpcaoSubMenu("exclusão");
        switch (opcaoExcluir) {
            case 1:
                // Código para excluir acesso
                break;
            case 2:
                // Código para excluir estacionamento
                break;
            case 3:
                // Código para excluir evento
                break;
            default:
                menuView.printOpcaoInvalida();
                break;
        }
    }
}
