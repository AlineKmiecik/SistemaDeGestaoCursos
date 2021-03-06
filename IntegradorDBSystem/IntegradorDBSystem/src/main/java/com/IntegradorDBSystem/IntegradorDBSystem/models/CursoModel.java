package com.IntegradorDBSystem.IntegradorDBSystem.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TB_CURSOS")
public class CursoModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int cursoId;
    private String nome;
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<AlunoModel> alunos;
    private LocalDateTime dataCriacaoCurso;
	
    public CursoModel() {
    	alunos = new ArrayList<AlunoModel>();
    	cursoId = 0;
    	nome = "";
    }

	public int getId() {
		return cursoId;
	}

	public void setId(int cursoId) {
		this.cursoId = cursoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AlunoModel> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoModel> alunos) {
		this.alunos = alunos;
	}

	public LocalDateTime getDataCriacaoCurso() {
		return dataCriacaoCurso;
	}

	public void setDataCriacaoCurso(LocalDateTime dataCriacaoCurso) {
		this.dataCriacaoCurso = dataCriacaoCurso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}
