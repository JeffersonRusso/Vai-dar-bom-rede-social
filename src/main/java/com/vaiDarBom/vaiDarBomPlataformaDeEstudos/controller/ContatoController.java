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

import com.vaiDarBom.vaiDarBomPlataformaDeEstudos.model.Contato;
import com.vaiDarBom.vaiDarBomPlataformaDeEstudos.repository.ContatoRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	ContatoRepository repositoty;
	
	@GetMapping
	public ResponseEntity<List<Contato>> GetAll(){
		return ResponseEntity.ok(repositoty.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contato> GetById(@PathVariable long id){
		return repositoty.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Contato> post (@RequestBody Contato contato){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(contato));
	}
	
	@PutMapping
	public ResponseEntity<Contato> put (@RequestBody Contato contato){
		return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(contato));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoty.deleteById(id);
	}
}
