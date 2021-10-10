package br.com.alura.livrariaapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.livrariaapi.dto.AutorDTO;
import br.com.alura.livrariaapi.dto.AutorFormDTO;
import br.com.alura.livrariaapi.service.AutorService;
import br.com.alura.livrariaapi.util.UriFactory;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	AutorService autorService;
	
	@GetMapping
	public Page<AutorDTO> listar(Pageable pageable) {
		return autorService.listar(pageable);
	}
	
	@PostMapping
	public ResponseEntity<AutorDTO> cadastrar(@RequestBody @Valid AutorFormDTO autor, UriComponentsBuilder uriBuilder) {
		AutorDTO autorDto = autorService.cadastrar(autor);
		
		return ResponseEntity.created(UriFactory.getURI(uriBuilder, "/autores/{id}", autorDto.getId())).build();
		
	}
	
}
