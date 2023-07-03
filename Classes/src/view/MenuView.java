package view;

import model.dominio.Acesso;

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

}
