package view;

import model.dominio.Acesso;
import model.dominio.Estacionamento;
import model.dominio.Evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner;
    private final DateTimeFormatter dateFormatter;
    private final DateTimeFormatter timeFormatter;

    public MenuView(){
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    }

    public int getOpcaoMenuPrincipal(){
        int opcao = -1;
        while(true) {
            System.out.println("Menu Principal");
            System.out.println("1. Criar\n2. Pesquisar\n3. Alterar\n4. Excluir\n5. Sair");
            if(scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                if(opcao > 0) {
                    break;
                }
            } else {
                scanner.nextLine();
            }
            printOpcaoInvalida();
        }
        scanner.nextLine();
        return opcao;
    }

    public int getOpcaoSubMenu(String tipoMenu, String opcoes) {
        int opcao = -1;
        while(true) {
            System.out.println(opcoes);
            System.out.println("Escolha uma opção de " + tipoMenu + ":");
            if(scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                if(opcao > 0) {
                    break;
                }
            } else {
                scanner.nextLine();
            }
            printOpcaoInvalida();
        }
        scanner.nextLine();
        return opcao;
    }

    public void printOpcaoInvalida(){
        System.out.println("Opção inválida");
    }

    public void closeScanner(){
        scanner.close();
    }

    private String getPlacaVeiculo(){
        System.out.println("Digite a placa do veiculo: ");
        return scanner.nextLine();
    }

    public String getString (String tipo){
        System.out.println("Digite " + tipo + ": ");
        return scanner.nextLine();
    }

    public LocalDate getData(String tipo){
        while (true){
            System.out.println("Digite a data de " + tipo + " (dd/mm/aaaa): ");
            String dataStr = scanner.nextLine();

            if (dataStr.equalsIgnoreCase("sair") || dataStr.trim().isEmpty()){
                return null;
            }

            try {
                return LocalDate.parse(dataStr, dateFormatter);
            } catch (Exception e){
                System.out.println("Data inválida. Tente novamente.");
            }
        }
    }

    public LocalTime getHora(String tipo){
        while (true){
            System.out.println("Digite a hora de " + tipo + " (HH:mm): ");
            String horaStr = scanner.nextLine();

            if (horaStr.equalsIgnoreCase("sair") || horaStr.trim().isEmpty()){
                return null;
            }

            // Adicionar um 0 se a hora tiver um único dígito
            if (horaStr.length() == 4 && horaStr.charAt(1) == ':') {
                horaStr = "0" + horaStr;
            }

            try {
                return LocalTime.parse(horaStr, timeFormatter);
            } catch (Exception e){
                System.out.println("Hora inválida. Tente novamente.");
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public int getInteiro(String tipo) throws ValorAcessoInvalidoException{
        while (true) {
            System.out.println("Digite " + tipo + ": ");
            String inteiroStr = scanner.nextLine().trim();

            if (inteiroStr.isEmpty()){
                return 0;
            }

            try {
                int inteiro = Integer.parseInt(inteiroStr);
                if (inteiro > 0){
                    return inteiro;
                } else {
                    throw new ValorAcessoInvalidoException("Valor de acesso inválido. Tente novamente");
                }
            } catch (ValorAcessoInvalidoException e){
                printExceptionMessage(e);
            }
        }
    }

    public double getNumeroReal(String tipo) throws ValorAcessoInvalidoException {
        while (true){
            System.out.println("Digite " + tipo + ": ");
            String numeroRealStr = scanner.nextLine().trim();

            if (numeroRealStr.isEmpty()) {
                return 0.0;
            }

            try {
                double numeroReal = Double.parseDouble(numeroRealStr);
                if (numeroReal > 0) {
                    return numeroReal;
                } else {
                    throw new ValorAcessoInvalidoException("Valor de acesso inválido. Tente novamente");
                }
            } catch (ValorAcessoInvalidoException e) {
                printExceptionMessage(e);
            }
        }
    }

    public Acesso getDetalhesDeAcesso(){
        String placa = getPlacaVeiculo();
        LocalDate dataEntrada = getData("entrada");
        LocalDate dataSaida = getData("saída");
        LocalTime horaEntrada = getHora("entrada");
        LocalTime horaSaida = getHora("saída");

        return new Acesso(placa, dataEntrada, dataSaida, horaEntrada, horaSaida);
    }
    
    //Estacionamento
    
    public Estacionamento getDetalhesDeEstacionamento() {
    	String nome = getString("o nome do Estacionamento");
    	String localizacao = getString("a Localicação");
    	int lotacaoMaxima = getInteiro("a Lotação Máxima");
    	int lotacaoAtual = getInteiro("a Lotação Atual");
    	double taxaDeFracao = getNumeroReal("a Taxa de Fração 15 minutos");
    	double taxaDeHora = getNumeroReal("a Taxa de Hora Cheia");
        double descontoPorHora = getNumeroReal("o Desconto Por Hora");
    	double taxaDeDiaria = getNumeroReal("a Taxa de Diária Diurna");
    	double taxaNoturna = getNumeroReal("a Taxa de Diária Noturna (em %)");
    	double taxaMensal = getNumeroReal("a Taxa Mensal");
    	double taxaDeEvento = getNumeroReal("a Taxa de Evento");
        LocalTime horarioAberturaDiurno = getHora("de abertura do horário diurno");
        LocalTime horarioFechamentoDiurno = getHora("de fechamento do horário diurno");
        LocalTime horarioAberturaNoturno = getHora("de abertura do horário noturno");
        LocalTime horarioFechamentoNoturno = getHora("de fechamento do horário noturno");

        return new Estacionamento(nome, localizacao, lotacaoMaxima, lotacaoAtual, taxaDeFracao,
                taxaDeHora, descontoPorHora, taxaDeDiaria, taxaNoturna, taxaMensal, taxaDeEvento, horarioAberturaDiurno,
                horarioFechamentoDiurno, horarioAberturaNoturno, horarioFechamentoNoturno);
    }
    
 // Acesso do Evento!!

    public Evento getDetalhesDeEvento() {
        String nome = getString("o nome do Evento");
        LocalDate dataInicio = getData("Inicial");
        LocalDate dataFim = getData("Final");
        LocalTime horaInicio = getHora("Inicial");
        LocalTime horaFim = getHora("Final");
        
        return new Evento(nome, dataInicio, dataFim, horaInicio, horaFim);

    }

    public void printResultadoExclusao(boolean resultado, String tipoObjeto) {
        if(resultado) {
            System.out.println(tipoObjeto + " excluído com sucesso!");
        } else {
            System.out.println("Não foi possível excluir o " + tipoObjeto.toLowerCase() + ".");
        }
    }

    public boolean isEvento() {
        while (true){
            System.out.println("O acesso é para um evento? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals("s")) {
                return true;
            } else if (resposta.equals("n")) {
                return false;
            } else {
                System.out.println("Resposta inválida. Por favor, digite 's' para sim ou 'n' para não.");
            }
        }
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

}
