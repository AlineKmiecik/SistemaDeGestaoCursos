package com.IntegradorDBSystem.IntegradorDBSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IntegradorDBSystem.IntegradorDBSystem.models.CursoModel;

public interface CursoRepository extends JpaRepository<CursoModel, Integer>{
	boolean existsByNome(String nome);
}
