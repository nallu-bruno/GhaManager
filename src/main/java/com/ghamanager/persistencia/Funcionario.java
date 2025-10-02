package com.ghamanager.persistencia;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String matricula;
    private String rg;
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;
    private String endereco;
    @Temporal(TemporalType.DATE)
    private Date dataDeAdmissao;
    private String funcao;
    private String setor;
    private String demitido;
    @Temporal(TemporalType.DATE)
    private Date dataDeDemissao;
    private String observacoes;
    
     @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Curso> cursos = new ArrayList<>(); 

    public Funcionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Date dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDemitido() {
        return demitido;
    }

    public void setDemitido(String demitido) {
        this.demitido = demitido;
    }

    public Date getDataDeDemissao() {
        return dataDeDemissao;
    }

    public void setDataDeDemissao(Date dataDeDemissao) {
        this.dataDeDemissao = dataDeDemissao;
    }

    public String getobservacoes() {
        return observacoes;
    }

    public void setobservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
    
    
    
}
