package com.fiap.global_solution.global_solution.modelling;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LEITURAS")
public class LeituraModelling {

    @Id
    @Column(name = "ESTACAOID")
    private String estacaoId;

    @Column(name = "NIVELAGUA")
    private double nivelAgua;

    @Column(name = "DATAHORA")
    private LocalDateTime dataHora;



    public String getEstacaoId() {
        return estacaoId;
    }

    public void setEstacaoId(String estacaoId) {
        this.estacaoId = estacaoId;
    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(double nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
