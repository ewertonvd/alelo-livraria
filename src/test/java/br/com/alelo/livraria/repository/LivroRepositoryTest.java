package br.com.alelo.livraria.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alelo.livraria.modelo.Livro;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class LivroRepositoryTest {

	@Autowired
	LivroRepository repository;

	@Test
	public void deveriaCarregarUmaListaDeLivrosPeloTitulo() {
		String nomeLivro = "Lógica de Programação";
		List<Livro> livros = repository.findByTitulo(nomeLivro);
		Assert.assertNotNull(livros);
		Assert.assertEquals(nomeLivro, livros.get(0).getTitulo());
	}
	
	
	@Test
	public void naoDeveriaCarregarUmaListaDeLivrosPeloTitulo() {
		String nomeLivro = "TDD para Games";
		List<Livro> livros = repository.findByTitulo(nomeLivro);
		Assert.assertTrue(livros.size() == 0);
	}
	
	
	@Test
	public void deveriaCarregarUmaListaDeLivrosPeloNomeDoAutor() {
		String nomeAutor = "Nelson Fabbri Gerbelli";
		List<Livro> livros = repository.findByAutorNome(nomeAutor);
		Assert.assertNotNull(livros);
		Assert.assertEquals(nomeAutor, livros.get(0).getAutor().getNome());
	}
	
	
	@Test
	public void naoDeveriaCarregarUmaListaDeLivrosPeloNomeDoAutor() {
		String nomeAutor = "Ewerton Vieira Donati";
		List<Livro> livros = repository.findByAutorNome(nomeAutor);
		Assert.assertTrue(livros.size() == 0);
	}
}
