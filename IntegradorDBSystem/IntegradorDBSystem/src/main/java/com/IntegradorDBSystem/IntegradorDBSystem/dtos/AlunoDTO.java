package com.IntegradorDBSystem.IntegradorDBSystem.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

public class AlunoDTO {
	private int alunoId;
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	
	public AlunoDTO() {
		alunoId = 0;
		nome = "";
		email ="";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
	
	
	
	
}
