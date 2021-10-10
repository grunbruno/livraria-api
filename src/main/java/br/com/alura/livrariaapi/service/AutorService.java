package br.com.alura.livrariaapi.service;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.livrariaapi.dto.AutorDTO;
import br.com.alura.livrariaapi.dto.AutorFormDTO;
import br.com.alura.livrariaapi.model.Autor;
import br.com.alura.livrariaapi.repostirory.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Page<AutorDTO> listar(Pageable pageable){
		
		Page<Autor> autores = autorRepository.findAll(pageable);

		return autores
				.map( a -> modelMapper.map(a, AutorDTO.class));
	}
	
	@Transactional
	public AutorDTO cadastrar(AutorFormDTO autorDTO) {
		Autor autor = modelMapper.map(autorDTO, Autor.class);
		autorRepository.save(autor);
		
		return modelMapper.map(autor, AutorDTO.class);
	}


	public void validateAutor(Long idAutor) {
		System.out.println("Validando autor de ID: " + idAutor);
		Optional<Autor> findById = autorRepository.findById(idAutor);

		if(!findById.isPresent())
			throw new RuntimeException("Autor ainda não cadastrado!");
		
	}
}
