package com.IntegradorDBSystem.IntegradorDBSystem.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IntegradorDBSystem.IntegradorDBSystem.dtos.AlunoDTO;
import com.IntegradorDBSystem.IntegradorDBSystem.dtos.CursoDTO;
import com.IntegradorDBSystem.IntegradorDBSystem.enums.StatusCursoEvento;
import com.IntegradorDBSystem.IntegradorDBSystem.models.AlunoModel;
import com.IntegradorDBSystem.IntegradorDBSystem.models.CursoModel;
import com.IntegradorDBSystem.IntegradorDBSystem.services.AlunoService;
import com.IntegradorDBSystem.IntegradorDBSystem.services.CursoService;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoController {
	@Autowired
    AlunoService alunoService;	 

	/*
	 * @GetMapping("/list") public ResponseEntity<Page<CursoModel>>
	 * getAllCursos(@PageableDefault(page = 0, size = 5, sort = "cursoId", direction
	 * = Sort.Direction.DESC) Pageable pageable){
	 * 
	 * return new ResponseEntity<>(cursoService.findAll(pageable), HttpStatus.OK); }
	 */

	/*
	 * @GetMapping("/{cursoId}") public ResponseEntity<Object>
	 * getOneCurso(@PathVariable(value="cursoId") int cursoId){ Optional<CursoModel>
	 * cursoModelOptional = cursoService.findById(cursoId);
	 * 
	 * if(!cursoModelOptional.isPresent()) { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso n??o encontrado.");
	 * 
	 * }else { return
	 * ResponseEntity.status(HttpStatus.OK).body(cursoModelOptional.get());
	 * 
	 * } }
	 */
    
	/*
	 * @PostMapping("/update") public ResponseEntity<CursoModel>
	 * updateCurso(@RequestBody @Valid CursoDTO cursoDto) { CursoModel cursoModel =
	 * new CursoModel();
	 * 
	 * //Converte o DTO (requisi????o) em model BeanUtils.copyProperties(cursoDto,
	 * cursoModel);
	 * 
	 * if (cursoService.update(cursoModel).equals(StatusCursoEvento.SUCCESS) ){
	 * return new ResponseEntity<>(cursoModel, HttpStatus.ACCEPTED); }else { return
	 * new ResponseEntity<>(cursoModel, HttpStatus.CONFLICT); } }
	 */
    
	/*
	 * @GetMapping("delete/{cursoId}") public ResponseEntity<Object>
	 * deleteCurso(@PathVariable(value="cursoId") int cursoId){
	 * cursoService.delete(cursoId);
	 * 
	 * Optional<CursoModel> cursoModelTemp = cursoService.findById(cursoId);
	 * 
	 * if(cursoModelTemp.isPresent()) { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar o curso.");
	 * 
	 * }else { return
	 * ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso");
	 * 
	 * } }
	 */
}
