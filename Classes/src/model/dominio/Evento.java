package model.dominio;

import controller.EventoController;
import view.DescricaoEmBrancoException;

import java.time.LocalDate;
import java.time.LocalTime;


public class Evento {
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Evento() {

    }

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

    public void setNome(String nome) throws DescricaoEmBrancoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new DescricaoEmBrancoException("Nome do Evento");
        }
        this.nome = nome;
    }

    public void setDataInicio(LocalDate dataInicio) throws DescricaoEmBrancoException {
        if (dataInicio == null) {
            throw new DescricaoEmBrancoException("Data Início");
        }
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) throws DescricaoEmBrancoException {
        if (dataFim == null) {
            throw new DescricaoEmBrancoException("Data Fim");
        }
        this.dataFim = dataFim;
    }

    public void setHoraInicio(LocalTime horaInicio) throws DescricaoEmBrancoException {
        if (horaInicio == null) {
            throw new DescricaoEmBrancoException("Hora Inicio");
        }
        this.horaInicio = horaInicio;
    }

    public void setHoraFim(LocalTime horaFim) throws DescricaoEmBrancoException {
        if (horaFim == null) {
            throw new DescricaoEmBrancoException("Hora Fim");
        }
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

}
