package br.com.biblioteca.livros;

import java.util.Arrays;

import br.com.biblioteca.livros.domain.Livro;
import br.com.biblioteca.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaLivrosApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository livroRepository;


	public static void main(String[] args) {
		SpringApplication.run(BibliotecaLivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Livro l1 = new Livro(1l,"Senhor dos Aneis - Sociedade do anel", "kaio1");
		Livro l2 = new Livro(2l,"Senhor dos Aneis - As duas torres", "kaio2");
		Livro l3 = new Livro(3l,"Senhor dos Aneis - O retorno do rei", "kaio3");

		livroRepository.saveAll(Arrays.asList(l1,l2,l3));

	}
}

