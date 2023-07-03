package controller;

import model.dominio.Acesso;
import model.dominio.Estacionamento;
import model.dominio.Evento;
import model.gerenciadores.GerenciadorAcesso;
import model.gerenciadores.GerenciadorEstacionamento;
import model.gerenciadores.GerenciadorEvento;
import view.DescricaoEmBrancoException;
import view.ObjetoNaoEncontradoException;
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
                Estacionamento estacionamento = menuView.getDetalhesDeEstacionamento();
                try {
                    gerenciadorEstacionamento.criar(estacionamento);
                } catch (DescricaoEmBrancoException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                Evento evento = menuView.getDetalhesDeEvento();
                try {
                    gerenciadorEvento.criar(evento);
                } catch (DescricaoEmBrancoException e) {
                    System.out.println(e.getMessage());
                }
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
                String placa = menuView.getString("a placa do veículo para pesquisa");
                try {
                    Acesso acesso = gerenciadorAcesso.pesquisar(placa);
                    System.out.println(acesso.toString());
                } catch (ObjetoNaoEncontradoException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                String nomeEstacionamento = menuView.getString("o nome do estacionamento para pesquisa");
                try {
                    Estacionamento estacionamento = gerenciadorEstacionamento.pesquisar(nomeEstacionamento);
                    System.out.println(estacionamento.toString());
                } catch (ObjetoNaoEncontradoException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                String nomeEvento = menuView.getString("o nome do evento para pesquisa");
                try {
                    Evento evento = gerenciadorEvento.pesquisar(nomeEvento);
                    System.out.println(evento.toString());
                } catch (ObjetoNaoEncontradoException e) {
                    System.out.println(e.getMessage());
                }
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
