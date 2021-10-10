package br.com.alura.livrariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LivrosPorAutorDTO {
	
	private String nomeAutor;
	private Long quantidadeLivros;
	private Double percentual;
}
