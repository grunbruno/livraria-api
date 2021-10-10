package br.com.alura.livrariaapi.repostirory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.livrariaapi.dto.LivrosPorAutorDTO;
import br.com.alura.livrariaapi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	@Query("SELECT new  br.com.alura.livrariaapi.dto.LivrosPorAutorDTO("
			+ "autor.nome , COUNT(*), ( COUNT(*) * 1.0) / ( SELECT COUNT(*) FROM Livro l2 ) * 1.0 ) "
			+ "FROM Livro livro "
			+ "JOIN livro.autor autor "
			+ "group by autor.id") 
	public List<LivrosPorAutorDTO> relatorioLivrosPorAutor(); 
}
