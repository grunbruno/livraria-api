package br.com.alura.dto;

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
	
	@Size(min = 10)
	private String titulo;
	
	@PastOrPresent
	private LocalDate dataLancamento;
	
	@Min(value = 100)
	private int numeroDePaginas;
	
	private AutorFormDTO autor;
	
}
