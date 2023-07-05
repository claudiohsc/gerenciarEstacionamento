package model.dominio;

import java.time.LocalDate;
import java.time.LocalTime;


public class Evento {
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Evento(String nome, LocalDate dataInicio, LocalDate dataFim, LocalTime horaInicio, LocalTime horaFim) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getNome(){
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    @Override
    public String toString() {
        return "Evento {" +
                "nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                '}';
    }

    public void alterarDetalhes(String novoNomeEvento, LocalDate novaDataInicio, LocalDate novaDataFim, LocalTime novaHoraInicio, LocalTime novaHoraFim) {
        if (novoNomeEvento != null) {
            this.setNome(novoNomeEvento);
        }
        if (novaDataInicio != null) {
            this.setDataInicio(novaDataInicio);
        }
        if (novaDataFim != null) {
            this.setDataFim(novaDataFim);
        }
        if (novaHoraInicio != null) {
            this.setHoraInicio(novaHoraInicio);
        }
        if (novaHoraFim != null) {
            this.setHoraFim(novaHoraFim);
        }
    }
}
