package br.com.alelo.livraria.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alelo.livraria.modelo.Autor;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AutorRepositoryTest {

	@Autowired
	AutorRepository repository;

	@Test
	public void deveRetornarUmAutorPeloNome() {
		String nomeAutor = "Valéria Helena P. Gerbelli";
		Autor autor = repository.findByNome(nomeAutor);
		Assert.assertNotNull(autor);
		Assert.assertEquals(nomeAutor, autor.getNome());
	}
	
	@Test
	public void naoDeveRetornarUmAutorPeloNome() {
		String nomeAutor = "Ewerton Vieira Donati";
		Autor autor = repository.findByNome(nomeAutor);
		Assert.assertNull(autor);
	}
}