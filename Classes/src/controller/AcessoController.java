package controller;

import model.dominio.Acesso;
import model.dominio.AcessoPorEvento;
import model.dominio.Estacionamento;
import model.gerenciadores.GerenciadorAcesso;
import model.gerenciadores.GerenciadorEstacionamento;
import view.DescricaoEmBrancoException;
import view.MenuView;
import view.ObjetoNaoEncontradoException;

import java.time.LocalDate;
import java.time.LocalTime;

public class AcessoController{
    private final GerenciadorAcesso gerenciadorAcesso;
    private final GerenciadorEstacionamento gerenciadorEstacionamento;
    private final MenuView menuView;

    public AcessoController(GerenciadorAcesso gerenciadorAcesso, GerenciadorEstacionamento gerenciadorEstacionamento, MenuView menuView){
        this.menuView = menuView;
        this.gerenciadorAcesso = gerenciadorAcesso;
        this.gerenciadorEstacionamento = gerenciadorEstacionamento;
    }

    public void criar() {
        String nomeEstacionamento = menuView.getString("o nome do estacionamento que deseja criar o acesso");

        Estacionamento estacionamento;
        try {
            estacionamento = gerenciadorEstacionamento.pesquisar(nomeEstacionamento);
        } catch (ObjetoNaoEncontradoException e) {
            menuView.printExceptionMessage(e);
            return;
        }

        Acesso acesso = menuView.getDetalhesDeAcesso();
        acesso.setEstacionamento(estacionamento);

        if (menuView.isEvento()) {
            acesso = new AcessoPorEvento(acesso.getPlaca(), acesso.getDataEntrada(),
                    acesso.getDataSaida(), acesso.getHoraEntrada(), acesso.getHoraSaida());
            acesso.setEstacionamento(estacionamento);
        }

        try {
            gerenciadorAcesso.criar(acesso);
        } catch (DescricaoEmBrancoException e) {
            menuView.printExceptionMessage(e);
        }
    }

    public Acesso pesquisar() {
        String placa = menuView.getString("a placa do veículo para pesquisa");
        try {
            Acesso acesso = gerenciadorAcesso.pesquisar(placa);
            System.out.println(acesso.toString());

            // double tarifa = acesso.calcularTarifa();
            // System.out.println("Tarifa para este acesso: " + tarifa);
            return acesso;
        } catch (ObjetoNaoEncontradoException e) {
            menuView.printExceptionMessage(e);
        }
        return null;
    }


    public void alterar() {
        Acesso acesso = this.pesquisar();
        if (acesso != null) {
            try {
                String novaPlaca = null;
                LocalDate novaDataEntrada = null;
                LocalDate novaDataSaida = null;
                LocalTime novaHoraEntrada = null;
                LocalTime novaHoraSaida = null;
                Estacionamento novoEstacionamento = null;

                while (true){
                    int opcaoAlterarAcesso = menuView.getOpcaoSubMenu("alteração do acesso", "1. Placa\n2. Data de Entrada" +
                            "\n3. Data de Saída\n4. Hora de Entrada\n5. Hora de Saída\n6. Estacionamento\n7. Concluir alterações");

                    switch (opcaoAlterarAcesso){
                        case 1:
                            novaPlaca = menuView.getString("a nova placa do veículo");
                            break;
                        case 2:
                            novaDataEntrada = menuView.getData("a nova data de entrada");
                            break;
                        case 3:
                            novaDataSaida = menuView.getData("a nova data de saída");
                            break;
                        case 4:
                            novaHoraEntrada = menuView.getHora("a nova hora de entrada");
                            break;
                        case 5:
                            novaHoraSaida = menuView.getHora("a nova hora de saída");
                            break;
                        case 6:
                            String nomeNovoEstacionamento = menuView.getString("o nome do novo estacionamento");
                            try {
                                novoEstacionamento = gerenciadorEstacionamento.pesquisar(nomeNovoEstacionamento);
                            } catch (ObjetoNaoEncontradoException e) {
                                menuView.printExceptionMessage(e);
                                break;
                            }
                            break;
                        case 7:
                            acesso.alterarDetalhes(novaPlaca, novaDataEntrada, novaDataSaida, novaHoraEntrada, novaHoraSaida, novoEstacionamento);
                            if (novoEstacionamento != null) {
                                acesso.setEstacionamento(novoEstacionamento);
                            }
                            acesso = gerenciadorAcesso.inferirTipoDeAcesso(acesso, acesso.getEstacionamento());
                            gerenciadorAcesso.alterar(acesso);
                            return;
                        default:
                            menuView.printOpcaoInvalida();
                            break;
                    }
                }
            } catch (ObjetoNaoEncontradoException e) {
                menuView.printExceptionMessage(e);
            }
        }
    }

    public void excluir() {
        String placa = menuView.getString("a placa do veículo para exclusão");
        try {
            boolean excluido = gerenciadorAcesso.excluir(placa);
            menuView.printResultadoExclusao(excluido, "Acesso");
        } catch (ObjetoNaoEncontradoException e) {
            menuView.printExceptionMessage(e);
        }
    }
}
