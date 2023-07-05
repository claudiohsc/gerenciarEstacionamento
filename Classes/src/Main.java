
import controller.AcessoController;
import controller.EstacionamentoController;
import controller.EventoController;
import controller.MenuController;
import model.gerenciadores.GerenciadorAcesso;
import model.gerenciadores.GerenciadorEstacionamento;
import model.gerenciadores.GerenciadorEvento;
import view.MenuView;

public class Main {
    public static void main(String[] args) {
        GerenciadorAcesso gerenciadorAcesso = new GerenciadorAcesso();
        GerenciadorEstacionamento gerenciadorEstacionamento = new GerenciadorEstacionamento();
        GerenciadorEvento gerenciadorEvento = new GerenciadorEvento();
        MenuView menuView = new MenuView();
        AcessoController acessoController = new AcessoController(gerenciadorAcesso, gerenciadorEstacionamento, menuView);
        EstacionamentoController estacionamentoController = new EstacionamentoController(gerenciadorEstacionamento, menuView);
        EventoController eventoController = new EventoController(gerenciadorEvento, menuView);

        MenuController menuController = new MenuController(gerenciadorAcesso, gerenciadorEstacionamento, gerenciadorEvento, menuView,
                acessoController, estacionamentoController, eventoController);

        menuController.iniciar();
    }
}
