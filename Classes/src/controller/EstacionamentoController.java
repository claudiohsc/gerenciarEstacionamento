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
        Estacionamento estacionamento = new Estacionamento();

        try {
            estacionamento.setNome(menuView.getString("o nome do estacionamento"));
            estacionamento.setLocalizacao(menuView.getString("a localização"));
            estacionamento.setLotacaoMaxima(menuView.getInteiro("a lotação máxima"));
            estacionamento.setTaxaDeFracao(menuView.getNumeroReal("a taxa de fração"));
            estacionamento.setTaxaDeHora(menuView.getNumeroReal("a taxa de hora cheia"));
            estacionamento.setTaxaDeDiaria(menuView.getNumeroReal("a taxa de diária"));
            estacionamento.setTaxaNoturna(menuView.getNumeroReal("a taxa noturna"));
            estacionamento.setTaxaMensal(menuView.getNumeroReal("a taxa mensal"));
            estacionamento.setTaxaDeEvento(menuView.getNumeroReal("a taxa de evento"));
            estacionamento.setHorarioAberturaDiurno(menuView.getHora("o horário de abertura diurno"));
            estacionamento.setHorarioFechamentoDiurno(menuView.getHora("o horário de fechamento diurno"));
            estacionamento.setHorarioAberturaNoturno(menuView.getHora("o horário de abertura noturno"));
            estacionamento.setHorarioFechamentoNoturno(menuView.getHora("o horário de fechamento noturno"));
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
            while (true){
                try {
                    int opcaoAlterarEstacionamento = menuView.getOpcaoSubMenu("alteração do estacionamento",
                            "1. Nome do Estacionamento\n2. Localização\n3. Lotação Máxima\n4. Lotação Atual\n5. Taxa de Fração (15 minutos)" +
                                    "\n6. Hora Cheia\n7. Desconto Por Hora\n8. Diária Diruna\n9. Diária Noturna\n10. Taxa Mensal\n11. Taxa de Evento" +
                                    "\n12. Horário de Abertura Diurno\n13. Horário de Fechamento Diurno\n14. Horário de Abertura Noturno" +
                                    "\n15. Horário de Fechamento Noturno\n16. Concluir alterações");

                    switch (opcaoAlterarEstacionamento){
                        case 1:
                            estacionamento.setNome(menuView.getString("o novo nome do estacionamento"));
                            break;
                        case 2:
                            estacionamento.setLocalizacao(menuView.getString("a nova localização"));
                            break;
                        case 3:
                            estacionamento.setLotacaoMaxima(menuView.getInteiro("a nova lotação máxima"));
                            break;
                        case 4:
                            estacionamento.setLotacaoAtual(menuView.getInteiro("a nova lotação atual"));
                            break;
                        case 5:
                            estacionamento.setTaxaDeFracao(menuView.getNumeroReal("a nova taxa de fração 15 minutos"));
                            break;
                        case 6:
                            estacionamento.setTaxaDeHora(menuView.getNumeroReal("a nova taxa de hora cheia"));
                            break;
                        case 7:
                            estacionamento.setDescontoPorHora(menuView.getNumeroReal("a nova taxa de desconto por hora"));
                            break;
                        case 8:
                            estacionamento.setTaxaDeDiaria(menuView.getNumeroReal("a nova taxa de diária diurna"));
                            break;
                        case 9:
                            estacionamento.setTaxaNoturna(menuView.getNumeroReal("a nova taxa de diária noturna"));
                            break;
                        case 10:
                            estacionamento.setTaxaMensal(menuView.getNumeroReal("a nova taxa mensal"));
                            break;
                        case 11:
                            estacionamento.setTaxaDeEvento(menuView.getNumeroReal("a nova taxa de evento"));
                            break;
                        case 12:
                            estacionamento.setHorarioAberturaDiurno(menuView.getHora("de abertura diurna do estacionamento"));
                            break;
                        case 13:
                            estacionamento.setHorarioFechamentoDiurno(menuView.getHora("de fechamento diurna do estacionamento"));
                            break;
                        case 14:
                            estacionamento.setHorarioAberturaNoturno(menuView.getHora("de abertura noturna do estacionamento"));
                            break;
                        case 15:
                            estacionamento.setHorarioFechamentoNoturno(menuView.getHora("de fechamento noturna do estacionamento"));
                            break;
                        case 16:
                            gerenciadorEstacionamento.alterar(estacionamento);
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
        String nomeEstacionamento = menuView.getString("o nome do estacionamento para exclusão");
        try {
            boolean excluido = gerenciadorEstacionamento.excluir(nomeEstacionamento);
            menuView.printResultadoExclusao(excluido, "Estacionamento");
        } catch (ObjetoNaoEncontradoException e) {
            menuView.printExceptionMessage(e);
        }
    }

}
