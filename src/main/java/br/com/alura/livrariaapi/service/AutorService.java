package br.com.alura.livrariaapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaapi.dto.AutorDTO;
import br.com.alura.livrariaapi.dto.AutorFormDTO;
import br.com.alura.livrariaapi.model.Autor;

@Service
public class AutorService {
	
	private Map<Integer,Autor> autores = new HashMap<Integer, Autor>();
	private ModelMapper modelMapper = new ModelMapper();
	
	public List<AutorDTO> listar(){
		return autores
		.entrySet()
		.stream()
		.map( Map.Entry::getValue)
		.collect(Collectors.toList())
			.stream()
			.map( a -> modelMapper.map(a, AutorDTO.class))
			.collect(Collectors.toList());
		
			
	}
	
	
	public void cadastrar(AutorFormDTO autorDTO) {
		Autor autor = modelMapper.map(autorDTO, Autor.class);
		autor.setId(new Random().nextInt(99999999));
		autores.put(autor.getId(),autor);
		
		System.out.println(autores);
	}


	public Autor getAutor(int idAutor) {
		System.out.println("Validando autor de ID: " + idAutor);
		System.out.println("Lista de autores: " + autores);
		
		Autor autor = autores.get(Integer.valueOf(idAutor));
		
		if(autor == null)
			throw new RuntimeException("Autor ainda não cadastrado!");
		
		return autor;
	}
}
