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

    public Acesso getDetalhesDeAcesso(){
        String placa = getPlacaVeiculo();
        LocalDate dataEntrada = getData("entrada");
        LocalDate dataSaida = getData("saída");
        LocalTime horaEntrada = getHora("entrada");
        LocalTime horaSaida = getHora("saída");

        return new Acesso(placa, dataEntrada, dataSaida, horaEntrada, horaSaida);
    }

    private String getPlacaVeiculo(){
        System.out.println("Digite a placa do veiculo: ");
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
    
    //Estacionamento
    
    public Estacionamento getDetalhesDeEstacionamento() {
    	String nome = getNome();
    	String localizacao = getLocalizacao();
    	int lotacaoMaxima = getLotacaoMaxima();
    	int lotacaoAtual = getLotacaoAtual();
    	Double taxaDeFracao = getTaxaDeFracao();
    	Double taxaDeHora = getTaxaDeHora();
    	Double taxaDeDiaria = getTaxaDeDiaria();
    	Double taxaNoturna = getTaxaNoturna();
    	Double taxaMensal = getTaxaMensal();
    	Double taxaDeEvento = getTaxaDeEvento();
    	
    	return new Estacionamento(nome, localizacao, lotacaoMaxima, lotacaoAtual, taxaDeFracao,
    			taxaDeHora, taxaDeDiaria, taxaNoturna, taxaMensal, taxaDeEvento);
    }
    
    private String getNome(){
        System.out.println("Digite o nome do Estacionamento: ");
        return scanner.nextLine();
    }
    
    private String getLocalizacao(){
        System.out.println("Digite a localização do Estacionamento: ");
        return scanner.nextLine();
    }
    private int getLotacaoMaxima(){
        System.out.println("Digite a Lotação Máxima do Estacionamento: ");
        return scanner.nextInt();
    }
    private int getLotacaoAtual(){
        System.out.println("Digite a Lotação Atual do Estacionamento: ");
        return scanner.nextInt();
    }
    private Double getTaxaDeFracao(){
        System.out.println("Digite a Taxa de Fração do Estacionamento: ");
        return scanner.nextDouble();
    }
    private Double getTaxaDeHora(){
        System.out.println("Digite a Taxa de Hora do Estacionamento: ");
        return scanner.nextDouble();
    }
    private Double getTaxaDeDiaria(){
        System.out.println("Digite a Taxa de Diária do Estacionamento: ");
        return scanner.nextDouble();
    }
    private Double getTaxaNoturna(){
        System.out.println("Digite a Taxa Noturna do Estacionamento: ");
        return scanner.nextDouble();
    }
    private Double getTaxaMensal(){
        System.out.println("Digite a Taxa Mensal do Estacionamento: ");
        return scanner.nextDouble();
    }
    private Double getTaxaDeEvento(){
        System.out.println("Digite a Taxa de Evento do Estacionamento: ");
        return scanner.nextDouble();
    }
    
    //fim do estacionamento (criacao)
    
 // Acesso do Evento!!

    public Evento getDetalhesDeEvento() {
        String nome = getNomeDoEvento();
        LocalDate dataInicio = getdataDoEvento("Inicial");
        LocalDate dataFim = getdataDoEvento("Final");
        LocalTime horaInicio = getHoradoEvento("Inicial");
        LocalTime horaFim = getHoradoEvento("Final");
        
        return new Evento(nome, dataInicio, dataFim, horaInicio, horaFim);

    }

    private String getNomeDoEvento() {
        System.out.println("Digite o nome do evento: ");
        return scanner.nextLine();
    }

    private LocalDate getdataDoEvento(String tipo) {
        while (true) {
            System.out.println("Digite a data  " + tipo + " (dd/mm/aaaa): ");
            String dataStr = scanner.nextLine();

            if (dataStr.equalsIgnoreCase("sair")) {
                return null;
            }

            try {
                return LocalDate.parse(dataStr, dateFormatter);
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }
    }

    private LocalTime getHoradoEvento(String tipo) {
        while (true) {
            System.out.println("Digite a hora " + tipo + " (HH:mm): ");
            String horaStr = scanner.nextLine();

            if (horaStr.equalsIgnoreCase("sair")) {
                return null;
            }

            try {
                return LocalTime.parse(horaStr, timeFormatter);
            } catch (Exception e) {
                System.out.println("Hora inválida. Tente novamente.");
            }
        }
    }

}
