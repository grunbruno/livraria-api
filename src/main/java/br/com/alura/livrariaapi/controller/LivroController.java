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

import br.com.alura.livrariaapi.dto.LivroDTO;
import br.com.alura.livrariaapi.dto.LivroFormDTO;
import br.com.alura.livrariaapi.service.LivroService;
import br.com.alura.livrariaapi.util.UriFactory;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping
	public Page<LivroDTO> listar(Pageable pageable){
		return livroService.listar(pageable);
	}
	
	@PostMapping
	public ResponseEntity<LivroDTO> cadastrar(@RequestBody @Valid LivroFormDTO livroDTO , UriComponentsBuilder uriBuilder) {
		LivroDTO livro = livroService.cadastrar(livroDTO);
				
		return ResponseEntity.created(UriFactory.getURI(uriBuilder, "/livros/{id}", livro.getId())).build();
	}
}
