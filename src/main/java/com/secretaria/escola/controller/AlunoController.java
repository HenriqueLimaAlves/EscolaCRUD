package com.secretaria.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secretaria.escola.model.Alunos;
import com.secretaria.escola.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Alunos>> findAllAluno(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alunos> findById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Alunos> post(@RequestBody Alunos alunos){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(alunos));
	}
	
	@PutMapping
	public ResponseEntity<Alunos> put(@RequestBody Alunos nome){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		repository.deleteById(id);
	}
	
	
}
