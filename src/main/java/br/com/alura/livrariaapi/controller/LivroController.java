package br.com.alura.livrariaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaapi.dto.LivroDTO;
import br.com.alura.livrariaapi.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping
	public List<LivroDTO> listar(){
		return livroService.listar();
	}
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid LivroDTO livroDTO) {
		System.out.println(livroDTO);
		livroService.cadastrar(livroDTO);
	}
}
