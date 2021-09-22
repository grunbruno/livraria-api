package br.com.alura.livrariaapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.dto.LivroDTO;
import br.com.alura.livrariaapi.model.Livro;

@Service
public class LivroService {
	
	private List<Livro> livros = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private AutorService autorService;
	
	public List<LivroDTO> listar(){
		return livros
		.stream()
		.map( l -> modelMapper.map(l, LivroDTO.class))
		.collect(Collectors.toList());
	}
	
	
	public void cadastrar(LivroDTO livroDTO) {
		
		autorService.cadastrar(livroDTO.getAutor());
		livros.add(modelMapper.map(livroDTO, Livro.class));
	}
}
