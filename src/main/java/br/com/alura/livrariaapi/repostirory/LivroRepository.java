package br.com.alura.livrariaapi.repostirory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.livrariaapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
