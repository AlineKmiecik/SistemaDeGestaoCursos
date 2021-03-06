package com.IntegradorDBSystem.IntegradorDBSystem.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.IntegradorDBSystem.IntegradorDBSystem.enums.StatusCursoEvento;
import com.IntegradorDBSystem.IntegradorDBSystem.models.AlunoModel;
import com.IntegradorDBSystem.IntegradorDBSystem.models.CursoModel;
import com.IntegradorDBSystem.IntegradorDBSystem.repositories.AlunoRepository;
import com.IntegradorDBSystem.IntegradorDBSystem.repositories.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public Enum<StatusCursoEvento> create(CursoModel cursoModel) {
		try {
			cursoModel.setDataCriacaoCurso(LocalDateTime.now());
			if(cursoRepository.existsByNome(cursoModel.getNome()) ){
				return StatusCursoEvento.ERROR;
			}else{
				cursoRepository.save(cursoModel);
			}
			
			
		} catch (Exception e) {
			System.out.println(StatusCursoEvento.ERROR + ": " + e);
			
		}
		return StatusCursoEvento.SUCCESS;
	}
	
	public Page<CursoModel> findAll(Pageable pageable) {
        return  cursoRepository.findAll(pageable);
    }

    public Optional<CursoModel> findById(int cursoId) {   	
        return cursoRepository.findById(cursoId);
    }
    
    public Enum<StatusCursoEvento> update(CursoModel cursoModel) {
    	try {
    		if( !cursoRepository.existsByNome(cursoModel.getNome())) {
    			return StatusCursoEvento.ERROR;
    		}else {
    			cursoRepository.save(cursoModel);
    		}
			
			
		} catch (Exception e) {
			System.out.println(StatusCursoEvento.ERROR + ": " + e);
			
		}
    	return StatusCursoEvento.SUCCESS;
    }
    
    public void delete(int cursoId) {
    	CursoModel cursoModelTemp = new CursoModel();
    	cursoModelTemp.setId(cursoId);
        cursoRepository.delete(cursoModelTemp);
    }
	
}
