package br.com.alura.livrariaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaapi.dto.LivrosPorAutorDTO;
import br.com.alura.livrariaapi.repostirory.AutorRepository;

@Service
public class RelatorioService {
	
	@Autowired
	AutorRepository autorRepository;
	
	public List<LivrosPorAutorDTO> relatorioLivrosPorAutor(){
		return autorRepository.relatorioLivrosPorAutor();
	}
}
