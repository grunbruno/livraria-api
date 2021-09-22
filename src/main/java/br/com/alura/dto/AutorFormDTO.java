package br.com.alura.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AutorFormDTO extends AutorDTO {

	@NotNull
	@NotEmpty
	private String miniCurriculo;

}
