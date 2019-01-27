package br.com.biblioteca.livros.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.biblioteca.livros.domain.Livro;
import br.com.biblioteca.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElse(null);
    }

    public String findByLivroNome(Long idLivro){

        List<Livro> livros = livroRepository.findAll();
        List<Livro> streamLivros = livros.stream().flatMap(livro -> livros.stream()).collect(Collectors.toList());

        Optional<Livro> livro = streamLivros
                .stream()
                .filter(l -> l.getId().equals(idLivro))
                .findFirst();

        Livro nomeLivro = livro.orElse(new Livro());
        return nomeLivro.getNome();
    }


}
