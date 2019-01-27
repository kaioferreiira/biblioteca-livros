package br.com.biblioteca.livros.resources;

import java.util.List;

import br.com.biblioteca.livros.Service.LivroService;
import br.com.biblioteca.livros.domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listar(){
        List<Livro> livros = livroService.findAll();
        return ResponseEntity.ok().body(livros);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(livro);
    }


    @GetMapping(value="/nome/{id}")
    public ResponseEntity<String> findNomeId(@PathVariable Long id){
        String livro = livroService.findByLivroNomeId(id);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping(value="/livrosnome/{nome}")
    public ResponseEntity<String> findByNome(@PathVariable String nome){

        Livro livro = livroService.findByLivroNome(nome);

        return ResponseEntity.ok().body(livro.toString());
    }



}
