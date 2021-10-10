package br.com.alura.livrariaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaapi.dto.AutorDTO;
import br.com.alura.livrariaapi.dto.AutorFormDTO;
import br.com.alura.livrariaapi.model.Autor;
import br.com.alura.livrariaapi.repostirory.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public List<AutorDTO> listar(){
		
		List<Autor> autores = autorRepository.findAll();

		return autores
				.stream()
				.map( a -> modelMapper.map(a, AutorDTO.class))
				.collect(Collectors.toList());
	}
	
	
	public void cadastrar(AutorFormDTO autorDTO) {
		Autor autor = modelMapper.map(autorDTO, Autor.class);
		autorRepository.save(autor);
	}


	public Autor getAutor(Long idAutor) {
		System.out.println("Validando autor de ID: " + idAutor);
		Optional<Autor> findById = autorRepository.findById(idAutor);

		if(!findById.isPresent())
			throw new RuntimeException("Autor ainda não cadastrado!");
		
		return findById.get();
	}
}
