package br.com.alura.livrariaapi.repostirory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.livrariaapi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
