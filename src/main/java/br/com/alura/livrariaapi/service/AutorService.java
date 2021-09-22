package br.com.alura.livrariaapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.dto.AutorDTO;
import br.com.alura.dto.AutorFormDTO;
import br.com.alura.livrariaapi.model.Autor;

@Service
public class AutorService {
	
	private List<Autor> autores = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();
	
	public List<AutorDTO> listar(){
		return autores
		.stream()
		.map( a -> modelMapper.map(a, AutorDTO.class))
		.collect(Collectors.toList());
	}
	
	
	public void cadastrar(AutorFormDTO autorDTO) {
		autores.add(modelMapper.map(autorDTO, Autor.class));
	}
}
