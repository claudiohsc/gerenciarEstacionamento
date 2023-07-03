package model.dominio;

import java.sql.Time;
import java.util.Date;

public class Evento {
    private String nome;
    private Date dataInicio;
    private Date dataFim;
    private Time horaInicio;
    private Time horaFim;

    public Evento(String nome, Date dataInicio, Date dataFim, Time horaInicio, Time horaFim) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getNome(){
        return nome;
    }
}
