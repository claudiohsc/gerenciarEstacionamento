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

import java.time.LocalDate;
import java.time.LocalTime;

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
        int opcaoCriar = menuView.getOpcaoSubMenu("criação", "1. Acesso\n2. Estacionamento\n3. Evento");
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
        int opcaoPesquisar = menuView.getOpcaoSubMenu("pesquisa", "1. Acesso\n2. Estacionamento\n3. Evento");
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
        int opcaoAlterar = menuView.getOpcaoSubMenu("alteração", "1. Acesso\n2. Estacionamento\n3. Evento");
        switch (opcaoAlterar) {
            case 1:
                String placa = menuView.getString("a placa do veículo para alteração");
                alterarAcesso(placa);
                break;
            case 2:
                String nomeEstacionamento = menuView.getString("o nome do estacionamento para alteração");
                alterarEstacionamento(nomeEstacionamento);
                break;
            case 3:
                String nomeEvento = menuView.getString("o nome do evento para alteração");
                alterarEvento(nomeEvento);
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
                String placa = menuView.getString("a placa do veículo para exclusão");
                try {
                    excluido = gerenciadorAcesso.excluir(placa);
                    menuView.printResultadoExclusao(excluido, "Acesso");
                } catch (ObjetoNaoEncontradoException e) {
                    menuView.printExceptionMessage(e);
                }
                break;
            case 2:
                String nomeEstacionamento = menuView.getString("o nome do estacionamento para exclusão");
                try {
                    excluido = gerenciadorEstacionamento.excluir(nomeEstacionamento);
                    menuView.printResultadoExclusao(excluido, "Estacionamento");
                } catch (ObjetoNaoEncontradoException e) {
                    menuView.printExceptionMessage(e);
                }
                break;
            case 3:
                String nomeEvento = menuView.getString("o nome do evento para exclusão");
                try {
                    excluido = gerenciadorEvento.excluir(nomeEvento);
                    menuView.printResultadoExclusao(excluido, "Evento");
                } catch (ObjetoNaoEncontradoException e) {
                    menuView.printExceptionMessage(e);
                }
                break;
            default:
                menuView.printOpcaoInvalida();
                break;
        }
    }

    private void alterarAcesso(String placa) {
        try {
            Acesso acesso = gerenciadorAcesso.pesquisar(placa);

            while (true){
                int opcaoAlterarAcesso = menuView.getOpcaoSubMenu("alteração do acesso", "1. Placa\n2. Data de Entrada" +
                        "\n3. Data de Saída\n4. Hora de Entrada\n5. Hora de Saída\n6. Concluir alterações");

                switch (opcaoAlterarAcesso){
                    case 1:
                        String novaPlaca = menuView.getString("a nova placa do veículo");
                        acesso.setPlaca(novaPlaca);
                        break;
                    case 2:
                        LocalDate novaDataEntrada = menuView.getData("a nova data de entrada");
                        acesso.setDataEntrada(novaDataEntrada);
                        break;
                    case 3:
                        LocalDate novaDataSaida = menuView.getData("a nova data de saída");
                        acesso.setDataSaida(novaDataSaida);
                        break;
                    case 4:
                        LocalTime novaHoraEntrada = menuView.getHora("a nova hora de entrada");
                        acesso.setHoraEntrada(novaHoraEntrada);
                        break;
                    case 5:
                        LocalTime novaHoraSaida = menuView.getHora("a nova hora de saída");
                        acesso.setHoraSaida(novaHoraSaida);
                        break;
                    case 6:
                        gerenciadorAcesso.alterar(acesso);
                        return;
                    default:
                        menuView.printOpcaoInvalida();
                        break;
                }
            }
        } catch (ObjetoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void alterarEstacionamento(String nomeEstacionamento) {
        try {
            Estacionamento estacionamento = gerenciadorEstacionamento.pesquisar(nomeEstacionamento);

            while (true){
                int opcaoAlterarEstacionamento = menuView.getOpcaoSubMenu("alteração do estacionamento", "1. Nome do Estacionamento\n2. Localização" +
                        "\n3. Lotação Máxima\n4. Lotação Atual\n5. Taxa de Fração (15 minutos)\n6. Hora Cheia\n7. Diária Diruna\n8. Diária Noturna" +
                        "\n9. Taxa Mensal\n10. Taxa de Evento\n11. Concluir alterações");

                switch (opcaoAlterarEstacionamento){
                    case 1:
                        String novoNomeEstacionamento = menuView.getString("o novo nome do estacionamento");
                        estacionamento.setNome(novoNomeEstacionamento);
                        break;
                    case 2:
                        String novaLocalizacao = menuView.getString("a nova localização");
                        estacionamento.setLocalizacao(novaLocalizacao);
                        break;
                    case 3:
                        int novaLotacaoMaxima = menuView.getInteiro("a nova lotação máxima");
                        estacionamento.setLotacaoMaxima(novaLotacaoMaxima);
                        break;
                    case 4:
                        int novaLotacaoAtual = menuView.getInteiro("a nova lotação atual");
                        estacionamento.setLotacaoAtual(novaLotacaoAtual);
                        break;
                    case 5:
                        double novaTaxaDeFracao = menuView.getNumeroReal("a nova taxa de fração 15 minutos");
                        estacionamento.setTaxaDeFracao(novaTaxaDeFracao);
                        break;
                    case 6:
                        double novaTaxaDeHora = menuView.getNumeroReal("a nova taxa de hora cheia");
                        estacionamento.setTaxaDeHora(novaTaxaDeHora);
                        break;
                    case 7:
                        double novaTaxaDeDiaria = menuView.getNumeroReal("a nova taxa de diária diurna");
                        estacionamento.setTaxaDeDiaria(novaTaxaDeDiaria);
                        break;
                    case 8:
                        double novaTaxaNoturna = menuView.getNumeroReal("a nova taxa de diária noturna");
                        estacionamento.setTaxaNoturna(novaTaxaNoturna);
                        break;
                    case 9:
                        double novaTaxaMensal = menuView.getNumeroReal("a nova taxa mensal");
                        estacionamento.setTaxaMensal(novaTaxaMensal);
                        break;
                    case 10:
                        double novaTaxaDeEvento = menuView.getNumeroReal("a nova taxa de evento");
                        estacionamento.setTaxaDeEvento(novaTaxaDeEvento);
                        break;
                    case 11:
                        gerenciadorEstacionamento.alterar(estacionamento);
                        return;
                    default:
                        menuView.printOpcaoInvalida();
                        break;
                }
            }
        } catch (ObjetoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void alterarEvento(String nomeEvento) {
        try {
            Evento evento = gerenciadorEvento.pesquisar(nomeEvento);

            while (true){
                int opcaoAlterarEvento = menuView.getOpcaoSubMenu("alteração do evento", "1. Nome do Evento\n2. Data Início" +
                        "\n3. Data Fim\n4. Hora Início\n5. Hora Fim\n6. Concluir alterações");

                switch (opcaoAlterarEvento){
                    case 1:
                        String novoNomeEvento = menuView.getString("o novo nome do evento");
                        evento.setNome(novoNomeEvento);
                        break;
                    case 2:
                        LocalDate novaDataInicio = menuView.getData("a nova data início");
                        evento.setDataInicio(novaDataInicio);
                        break;
                    case 3:
                        LocalDate novaDataFim = menuView.getData("a nova data fim");
                        evento.setDataFim(novaDataFim);
                        break;
                    case 4:
                        LocalTime novaHoraInicio = menuView.getHora("a nova hora início");
                        evento.setHoraInicio(novaHoraInicio);
                        break;
                    case 5:
                        LocalTime novaHoraFim = menuView.getHora("a nova hora fim");
                        evento.setHoraFim(novaHoraFim);
                        break;
                    case 6:
                        gerenciadorEvento.alterar(evento);
                        return;
                    default:
                        menuView.printOpcaoInvalida();
                        break;
                }
            }
        } catch (ObjetoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}
