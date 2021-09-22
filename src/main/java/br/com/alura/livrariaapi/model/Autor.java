package br.com.alura.livrariaapi.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
	
	private int id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String miniCurriculo;
	
}
