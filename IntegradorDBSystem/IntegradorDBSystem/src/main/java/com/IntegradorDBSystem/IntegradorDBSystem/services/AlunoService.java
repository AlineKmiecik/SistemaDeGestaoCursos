package com.IntegradorDBSystem.IntegradorDBSystem.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.IntegradorDBSystem.IntegradorDBSystem.enums.StatusCursoEvento;
import com.IntegradorDBSystem.IntegradorDBSystem.models.AlunoModel;
import com.IntegradorDBSystem.IntegradorDBSystem.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	AlunoRepository alunoRepository;
	
	public Enum<StatusCursoEvento> create(AlunoModel AlunoModel) {
		try {
			if(alunoRepository.existsByNome(AlunoModel.getNome()) ){
				return StatusCursoEvento.ERROR;
			}else{
				alunoRepository.save(AlunoModel);
			}
			
			
		} catch (Exception e) {
			System.out.println(StatusCursoEvento.ERROR + ": " + e);
			
		}
		return StatusCursoEvento.SUCCESS;
	}
	
	public Page<AlunoModel> findAll(Pageable pageable) {
        return  alunoRepository.findAll(pageable);
    }

    public Optional<AlunoModel> findById(int AlunoId) {
        return alunoRepository.findById(AlunoId);
    }
    
    public Enum<StatusCursoEvento> update(AlunoModel alunoModel) {
    	try {
    		if( !alunoRepository.existsByNome(alunoModel.getNome())) {
    			return StatusCursoEvento.ERROR;
    		}else {
    			alunoRepository.save(alunoModel);
    		}
			
			
		} catch (Exception e) {
			System.out.println(StatusCursoEvento.ERROR + ": " + e);
			
		}
    	return StatusCursoEvento.SUCCESS;
    }
    
    public void delete(int alunoId) {
    	AlunoModel alunoModelTemp = new AlunoModel();
    	alunoModelTemp.setAlunoId(alunoId);
    	alunoRepository.delete(alunoModelTemp);
    }
	
}
