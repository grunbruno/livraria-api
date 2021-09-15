package br.com.alura.livrariaapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.dto.AutorDTO;
import br.com.alura.dto.AutorFormDTO;
import br.com.alura.livrariaapi.model.Autor;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	List<Autor> autores = new ArrayList<>();
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping
	public List<AutorDTO> listar() {
		return autores
				.stream()
				.map( a -> modelMapper.map(a, AutorDTO.class))
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public void cadastrar(@RequestBody AutorFormDTO autor) {
		autores.add(modelMapper.map(autor, Autor.class));
	}
	
}
