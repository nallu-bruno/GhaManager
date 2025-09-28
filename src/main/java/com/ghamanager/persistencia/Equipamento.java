package com.ghamanager.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String patrimonio;
    private String tipoDoEquipamento;
    private String emUso;
    private String transferencia;
    private String transferido;  
    @Temporal(TemporalType.DATE)
    private Date ultimaPreventiva;
    @Temporal(TemporalType.DATE)
    private Date proximaPreventiva;
    private String observacoes;

    public Equipamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getTipoDoEquipamento() {
        return tipoDoEquipamento;
    }

    public void setTipoDoEquipamento(String tipoDoEquipamento) {
        this.tipoDoEquipamento = tipoDoEquipamento;
    }

     public String getEmUso() {
        return emUso;
    }

    public void setEmUso(String emUso) {
        this.emUso = emUso;
    }

    public String getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(String transferencia) {
        this.transferencia = transferencia;
    }

    public String getTransferido() {
        return transferido;
    }

    public void setTransferido(String transferido) {
        this.transferido = transferido;
    }
   

    public Date getUltimaPreventiva() {
        return ultimaPreventiva;
    }

    public void setUltimaPreventiva(Date ultimaPreventiva) {
        this.ultimaPreventiva = ultimaPreventiva;
    }

    public Date getProximaPreventiva() {
        return proximaPreventiva;
    }

    public void setProximaPreventiva(Date proximaPreventiva) {
        this.proximaPreventiva = proximaPreventiva;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
  }
