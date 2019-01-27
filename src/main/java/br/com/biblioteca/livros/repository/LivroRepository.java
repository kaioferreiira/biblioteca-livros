package br.com.biblioteca.livros.repository;

import br.com.biblioteca.livros.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findByNome(String nome);

}
