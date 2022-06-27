
package com.IntegradorDBSystem.IntegradorDBSystem.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.IntegradorDBSystem.IntegradorDBSystem.dtos.CursoDTO;
import com.IntegradorDBSystem.IntegradorDBSystem.enums.StatusCursoEvento;
import com.IntegradorDBSystem.IntegradorDBSystem.models.AlunoModel;
import com.IntegradorDBSystem.IntegradorDBSystem.models.CursoModel;
import com.IntegradorDBSystem.IntegradorDBSystem.services.AlunoService;
import com.IntegradorDBSystem.IntegradorDBSystem.services.CursoService;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

@RestController
@RequestMapping(path = "/curso")
public class CursoController {
	@Autowired
    CursoService cursoService;

    @PostMapping("/create")
    public ResponseEntity<CursoModel> createCurso(@RequestBody @Valid CursoDTO cursoDto) throws ClientProtocolException, IOException {
        CursoModel cursoModel = new CursoModel();
        
        //Converte o DTO (requisição) em model
        //BeanUtils.copyProperties(cursoDto, cursoModel);
        cursoModel = converterCursoDto(cursoDto);
        
        if (cursoService.create(cursoModel).equals(StatusCursoEvento.SUCCESS) ){
        	
        	AlunoService alunoService = new AlunoService();
        	
        	for (AlunoModel aluno : cursoModel.getAlunos()) {
        		if (alunoService.create(aluno).equals(StatusCursoEvento.SUCCESS) ){
        			System.out.println(aluno.getNome() + " Cadastrado");
        		}else {
        			System.out.println(aluno.getNome() + " Não cadastrado"); 
        		}
			}
        	
        	//microsservice pho request 
        	SendEmailMicrosservice(cursoDto);
        	
        	return new ResponseEntity<>(cursoModel, HttpStatus.CREATED);
        	
        }else {
        	return new ResponseEntity<>(cursoModel, HttpStatus.CONFLICT);
        }
        
    }

    @GetMapping("/list")
    public ResponseEntity<Page<CursoModel>> getAllCursos(@PageableDefault(page = 0, size = 5, sort = "cursoId", direction = Sort.Direction.DESC) Pageable pageable){
    	
        return new ResponseEntity<>(cursoService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<Object> getOneCurso(@PathVariable(value="cursoId") int cursoId){
        Optional<CursoModel> cursoModelOptional = cursoService.findById(cursoId);
        
        if(!cursoModelOptional.isPresent()) {        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado.");
            
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(cursoModelOptional.get());
            
        }
    }
    
    @PostMapping("/update")
    public ResponseEntity<CursoModel> updateCurso(@RequestBody @Valid CursoDTO cursoDto) {
        CursoModel cursoModel = new CursoModel();
        
        //Converte o DTO (requisição) em model
        BeanUtils.copyProperties(cursoDto, cursoModel);
        
        if (cursoService.update(cursoModel).equals(StatusCursoEvento.SUCCESS) ){
        	return new ResponseEntity<>(cursoModel, HttpStatus.ACCEPTED);
        }else {
        	return new ResponseEntity<>(cursoModel, HttpStatus.CONFLICT);
        }
    }
    
    @GetMapping("delete/{cursoId}")
    public ResponseEntity<Object> deleteCurso(@PathVariable(value="cursoId") int cursoId){
        cursoService.delete(cursoId);
        
        Optional<CursoModel> cursoModelTemp = cursoService.findById(cursoId);
		
        if(cursoModelTemp.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar o curso.");
            
        }else {
            return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso");
            
        }
    }
    
    private CursoModel converterCursoDto (CursoDTO cursoDTO) {
    	CursoModel cursoModel = new CursoModel();
    	cursoModel.setAlunos(cursoDTO.getAlunos());
    	cursoModel.setId(cursoDTO.getId());
    	cursoModel.setNome(cursoDTO.getNome());
    	
    	return cursoModel;
    	
    	
    }
    
    private void SendEmailMicrosservice(CursoDTO cursoDTO) throws ClientProtocolException, IOException {
		/*
		 * String URL =
		 * "http://localhost:80/confimacao_email.php?action=EnviarEmailConfirmacao";
		 * 
		 * System.out.println(URL);
		 * 
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 * restTemplate.postForObject(
		 * "http://localhost:80/confimacao_email.php?action=EnviarEmailConfirmacao",
		 * cursoDTO, CursoDTO.class);
		 * 
		 * //restTemplate.postForObject(URL, cursoModel, Void.class);
		 */    
    	
    	String       postUrl       = "http://localhost:80/confimacao_email.php?action=EnviarEmailConfirmacao";// put in your url
    	Gson         gson          = new Gson();
    	HttpClient   httpClient    = HttpClientBuilder.create().build();
    	HttpPost     post          = new HttpPost(postUrl);
    	StringEntity postingString = new StringEntity(gson.toJson(cursoDTO) );//gson.tojson() converts your pojo to json
    	post.setEntity(postingString);
    	post.setHeader("Content-type", "application/json");
    	HttpResponse  response = httpClient.execute(post);
    
    
    }
	
}
