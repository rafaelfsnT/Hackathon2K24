package Vacina.model;

import java.time.LocalDate;

public class Agendamento {
    private Integer id;
    private String agente;
    private String idoso;
    private String vacina;
    private LocalDate atendimento;

    public Agendamento (Integer id, String agente, String idoso,String vacina, LocalDate atendimento){
        this.id = id;
        this.agente = agente;
        this.idoso = idoso;
        this.vacina= vacina;
        this.atendimento = atendimento;
    }

    public Agendamento ( String agente, String idoso, String vacina, LocalDate atendimento){
        this.agente = agente;
        this.idoso = idoso;
        this.vacina= vacina;
        this.atendimento = atendimento;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdoso() {
        return idoso;
    }

    public void setIdoso(String idoso) {
        this.idoso = idoso;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public LocalDate getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(LocalDate atendimento) {
        this.atendimento = atendimento;
    }
    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }


}
