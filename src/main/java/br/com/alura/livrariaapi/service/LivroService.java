package br.com.alura.livrariaapi.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaapi.dto.LivroDTO;
import br.com.alura.livrariaapi.dto.LivroFormDTO;
import br.com.alura.livrariaapi.model.Autor;
import br.com.alura.livrariaapi.model.Livro;
import br.com.alura.livrariaapi.repostirory.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	AutorService autorService;
	
	public Page<LivroDTO> listar(Pageable pageable){
		return livroRepository.findAll(pageable)
		.map( l -> modelMapper.map(l, LivroDTO.class));
	}
	
	
	public void cadastrar(LivroFormDTO livroFormDTO) {
		
		Autor autor = autorService.getAutor(livroFormDTO.getAutor().getId());
		Livro livro = modelMapper.map(livroFormDTO, Livro.class);		
		livro.setAutor(autor);
		livroRepository.save(livro);
	}
}
