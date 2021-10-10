package br.com.alura.livrariaapi.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class LivroDTO {
	
	private Long id;
	private String titulo;
	private LocalDate dataLancamento;
	private int numeroDePaginas;
	private AutorFormDTO autor;
	
}
