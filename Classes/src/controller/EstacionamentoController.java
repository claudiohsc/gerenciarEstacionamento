package controller;

import model.dominio.Estacionamento;
import model.gerenciadores.GerenciadorEstacionamento;
import view.DescricaoEmBrancoException;
import view.MenuView;
import view.ObjetoNaoEncontradoException;

import java.time.LocalTime;

public class EstacionamentoController {
    private final GerenciadorEstacionamento gerenciadorEstacionamento;
    private final MenuView menuView;

    public EstacionamentoController(GerenciadorEstacionamento gerenciadorEstacionamento, MenuView menuView){
        this.menuView = menuView;
        this.gerenciadorEstacionamento = gerenciadorEstacionamento;
    }

    public void criar() {
        Estacionamento estacionamento = menuView.getDetalhesDeEstacionamento();
        try {
            gerenciadorEstacionamento.criar(estacionamento);
        } catch (DescricaoEmBrancoException e) {
            menuView.printExceptionMessage(e);
        }
    }

    public void pesquisar() {
        String nomeEstacionamento = menuView.getString("o nome do estacionamento para pesquisa");
        try {
            Estacionamento estacionamento = gerenciadorEstacionamento.pesquisar(nomeEstacionamento);
            System.out.println(estacionamento.toString());
        } catch (ObjetoNaoEncontradoException e) {
            menuView.printExceptionMessage(e);
        }
    }

    public void alterar() {
        String nomeEstacionamento = menuView.getString("o nome do estacionamento para alteração");
        Estacionamento estacionamento = gerenciadorEstacionamento.pesquisar(nomeEstacionamento);

        if (estacionamento != null) {
            String novoNomeEstacionamento = null;
            String novaLocalizacao = null;
            Integer novaLotacaoMaxima = null;
            Integer novaLotacaoAtual = null;
            Double novaTaxaDeFracao = null;
            Double novaTaxaDeHora = null;
            Double novoDescontoPorHora = null;
            Double novaTaxaDeDiaria = null;
            Double novaTaxaNoturna = null;
            Double novaTaxaMensal = null;
            Double novaTaxaDeEvento = null;
            LocalTime novoHorarioAberturaDiurno = null;
            LocalTime novoHorarioFechamentoDiurno = null;
            LocalTime novoHorarioAberturaNoturno = null;
            LocalTime novoHorarioFechamentoNoturno = null;

            while (true){
                int opcaoAlterarEstacionamento = menuView.getOpcaoSubMenu("alteração do estacionamento",
                        "1. Nome do Estacionamento\n2. Localização\n3. Lotação Máxima\n4. Lotação Atual\n5. Taxa de Fração (15 minutos)" +
                                "\n6. Hora Cheia\n7. Desconto Por Hora\n8. Diária Diruna\n9. Diária Noturna\n10. Taxa Mensal\n11. Taxa de Evento" +
                                "\n12. Horário de Abertura Diurno\n13. Horário de Fechamento Diurno\n14. Horário de Abertura Noturno" +
                                "\n15. Horário de Fechamento Noturno\n16. Concluir alterações");

                switch (opcaoAlterarEstacionamento){
                    case 1:
                        novoNomeEstacionamento = menuView.getString("o novo nome do estacionamento");
                        break;
                    case 2:
                        novaLocalizacao = menuView.getString("a nova localização");
                        break;
                    case 3:
                        novaLotacaoMaxima = menuView.getInteiro("a nova lotação máxima");
                        break;
                    case 4:
                        novaLotacaoAtual = menuView.getInteiro("a nova lotação atual");
                        break;
                    case 5:
                        novaTaxaDeFracao = menuView.getNumeroReal("a nova taxa de fração 15 minutos");
                        break;
                    case 6:
                        novaTaxaDeHora = menuView.getNumeroReal("a nova taxa de hora cheia");
                        break;
                    case 7:
                        novoDescontoPorHora = menuView.getNumeroReal("a nova taxa de desconto por hora");
                        break;
                    case 8:
                        novaTaxaDeDiaria = menuView.getNumeroReal("a nova taxa de diária diurna");
                        break;
                    case 9:
                        novaTaxaNoturna = menuView.getNumeroReal("a nova taxa de diária noturna");
                        break;
                    case 10:
                        novaTaxaMensal = menuView.getNumeroReal("a nova taxa mensal");
                        break;
                    case 11:
                        novaTaxaDeEvento = menuView.getNumeroReal("a nova taxa de evento");
                        break;
                    case 12:
                        novoHorarioAberturaDiurno = menuView.getHora("de abertura diurna do estacionamento");
                        break;
                    case 13:
                        novoHorarioFechamentoDiurno = menuView.getHora("de fechamento diurna do estacionamento");
                        break;
                    case 14:
                        novoHorarioAberturaNoturno = menuView.getHora("de abertura noturna do estacionamento");
                        break;
                    case 15:
                        novoHorarioFechamentoNoturno = menuView.getHora("de fechamento noturna do estacionamento");
                        break;
                    case 16:
                        estacionamento.alterarDetalhes(novoNomeEstacionamento,
                                novaLocalizacao, novaLotacaoMaxima, novaLotacaoAtual,
                                novaTaxaDeFracao, novaTaxaDeHora, novoDescontoPorHora, novaTaxaDeDiaria,
                                novaTaxaNoturna, novaTaxaMensal, novaTaxaDeEvento,
                                novoHorarioAberturaDiurno, novoHorarioFechamentoDiurno,
                                novoHorarioAberturaNoturno, novoHorarioFechamentoNoturno);
                        gerenciadorEstacionamento.alterar(estacionamento);
                        return;
                    default:
                        menuView.printOpcaoInvalida();
                        break;
                }
            }
        }
    }

    public void excluir() {
        String nomeEstacionamento = menuView.getString("o nome do estacionamento para exclusão");
        try {
            boolean excluido = gerenciadorEstacionamento.excluir(nomeEstacionamento);
            menuView.printResultadoExclusao(excluido, "Estacionamento");
        } catch (ObjetoNaoEncontradoException e) {
            menuView.printExceptionMessage(e);
        }
    }

}
