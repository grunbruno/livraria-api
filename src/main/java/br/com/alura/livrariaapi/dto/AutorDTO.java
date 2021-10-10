package br.com.alura.livrariaapi.dto;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AutorDTO {
	
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;

}
