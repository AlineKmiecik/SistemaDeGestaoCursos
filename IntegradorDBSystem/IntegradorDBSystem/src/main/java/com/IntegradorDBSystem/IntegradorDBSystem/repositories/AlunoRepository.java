package com.IntegradorDBSystem.IntegradorDBSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IntegradorDBSystem.IntegradorDBSystem.models.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {
	boolean existsByNome(String nome);
}
