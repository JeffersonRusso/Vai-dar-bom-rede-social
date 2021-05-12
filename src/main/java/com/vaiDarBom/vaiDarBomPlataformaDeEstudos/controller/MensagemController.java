package com.vaiDarBom.vaiDarBomPlataformaDeEstudos.controller;

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

import com.vaiDarBom.vaiDarBomPlataformaDeEstudos.model.Mensagem;
import com.vaiDarBom.vaiDarBomPlataformaDeEstudos.repository.MensagemRepository;

@RestController
@RequestMapping("/mensagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MensagemController {
	
	@Autowired
	MensagemRepository repositoty;
	
	@GetMapping
	public ResponseEntity<List<Mensagem>> GetAll(){
		return ResponseEntity.ok(repositoty.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mensagem> GetById(@PathVariable long id){
		return repositoty.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<Mensagem> post (@RequestBody Mensagem Mensagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(Mensagem));
	}
	
	@PutMapping
	public ResponseEntity<Mensagem> put (@RequestBody Mensagem Mensagem){
		return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(Mensagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoty.deleteById(id);
	}	
}
