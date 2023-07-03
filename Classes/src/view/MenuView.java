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
        System.out.println("Menu Principal");
        System.out.println("1. Criar\n2. Pesquisar\n3. Alterar\n4. Excluir\n5. Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public int getOpcaoSubMenu(String tipoMenu) {
        System.out.println("1. Acesso\n2. Estacionamento\n3. Evento");
        System.out.println("Escolha um opção de " + tipoMenu + ":");
        int opcao = scanner.nextInt();
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

    private LocalDate getData(String tipo){
        while (true){
            System.out.println("Digite a data de " + tipo + " (dd/mm/aaaa): ");
            String dataStr = scanner.nextLine();

            if (dataStr.equalsIgnoreCase("sair")){
                return null;
            }

            try {
                return LocalDate.parse(dataStr, dateFormatter);
            } catch (Exception e){
                System.out.println("Data inválida. Tente novamente.");
            }
        }
    }

    private LocalTime getHora(String tipo){
        while (true){
            System.out.println("Digite a hora de " + tipo + " (HH:mm): ");
            String horaStr = scanner.nextLine();

            if (horaStr.equalsIgnoreCase("sair")){
                return null;
            }

            try {
                return LocalTime.parse(horaStr, timeFormatter);
            } catch (Exception e){
                System.out.println("Hora inválida. Tente novamente.");
            }
        }

    }

    private int getInteiro(String tipo){
        while (true) {
            System.out.println("Digite " + tipo + ": ");
            String inteiroStr = scanner.nextLine().trim();

            if (inteiroStr.isEmpty()){
                return 0;
            }

            try {
                int inteiro = Integer.parseInt(inteiroStr);
                if (inteiro >= 0){
                    return inteiro;
                } else {
                    System.out.println("Por favor, insira um número inteiro positivo.");
                }
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
    }

    private double getNumeroReal(String tipo) {
        while (true){
            System.out.println("Digite " + tipo + ": ");
            String numeroRealStr = scanner.nextLine().trim();

            if (numeroRealStr.isEmpty()) {
                return 0.0;
            }

            try {
                double numeroReal = Double.parseDouble(numeroRealStr);
                if (numeroReal >= 0) {
                    return numeroReal;
                } else {
                    System.out.println("Por favor, insira um número real positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Tente novamente.");
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
    	double taxaDeDiaria = getNumeroReal("a Taxa de Diária Diurna");
    	double taxaNoturna = getNumeroReal("a Taxa de Diária Noturna (em %)");
    	double taxaMensal = getNumeroReal("a Taxa Mensal");
    	double taxaDeEvento = getNumeroReal("a Taxa de Evento");
    	
    	return new Estacionamento(nome, localizacao, lotacaoMaxima, lotacaoAtual, taxaDeFracao,
    			taxaDeHora, taxaDeDiaria, taxaNoturna, taxaMensal, taxaDeEvento);
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

}
