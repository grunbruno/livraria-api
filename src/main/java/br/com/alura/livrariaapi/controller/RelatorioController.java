package br.com.alura.livrariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaapi.dto.LivrosPorAutorDTO;
import br.com.alura.livrariaapi.service.RelatorioService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {
	
	@Autowired
	RelatorioService relatorioService;
	
	@GetMapping("/autores")
	public List<LivrosPorAutorDTO> relatorioLivrosPorAutor(){
		return relatorioService.relatorioLivrosPorAutor();
	}

}
