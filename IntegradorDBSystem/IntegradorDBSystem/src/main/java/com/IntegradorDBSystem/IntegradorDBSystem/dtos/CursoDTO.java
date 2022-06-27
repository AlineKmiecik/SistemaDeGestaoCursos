package com.IntegradorDBSystem.IntegradorDBSystem.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.IntegradorDBSystem.IntegradorDBSystem.models.AlunoModel;

import lombok.Data;


public class CursoDTO {
	private int id;
	@NotBlank
    private String nome;
    private List<AlunoModel> alunos;
    
    public CursoDTO() {
    	id = 0;
    	nome = "";
    	alunos = new ArrayList();
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    
    
}
