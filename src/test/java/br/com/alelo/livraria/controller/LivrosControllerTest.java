package br.com.alelo.livraria.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class LivrosControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveriaRetorarAListaDeLivros() throws Exception {
		
		URI uri = new URI("/livros"); 
		String json = "{\"id\":\"1\", \"titulo\":\"Lógica de Programação\", \"conteudo\":\"O livro explora os recursos do HTML e Javascript, criando a familiaridade desde o começo dos estudos com a sintaxe da linguagem de programação, instruções, funções específicas e problemas corriqueiros da programação\", \"autor\":\"Paulo Silveira\", \"numeroPaginas\":\"180}\","
				    + "{\"id\":\"2\", \"titulo\":\"App Inventor\", \"conteudo\":\"Após ser apresentado ao ambiente, você aprenderá na prática a desenvolver alguns aplicativos do zero, partindo de alguns cálculos, até chegar a resultados mais complexos, com um recurso de localização de GPS\", \"autor\":\"Adriano Almeida\", \"numeroPaginas\":\"311}\","
					+ "{\"id\":\"3\", \"titulo\":\"HTML5 e CSS3\", \"conteudo\":\"Crie páginas elegantes de forma simples! HTML e CSS, quando bem utilizados, podem ser o sucesso de um projeto\", \"autor\":\"Nelson Fabbri Gerbelli\", \"numeroPaginas\":\"228}\"";
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	
	@Test
	public void deveriaRetorarUmLivro() throws Exception {
		
		URI uri = new URI("/livros/1"); 
		String json = "{\"id\":\"1\", \"titulo\":\"Lógica de Programação\", \"conteudo\":\"O livro explora os recursos do HTML e Javascript, criando a familiaridade desde o começo dos estudos com a sintaxe da linguagem de programação, instruções, funções específicas e problemas corriqueiros da programação\", \"autor\":\"Paulo Silveira\", \"numeroPaginas\":\"180}\"";
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	
	@Test
	public void deveriaCadastrarUmLivro() throws Exception {
		URI uri = new URI("/livros"); 
		String json = "{\"id\":\"4\", \"titulo\":\"DevOps na prática\", \"conteudo\":\"Implementar práticas de DevOps e Entrega Contínua para aumentar a frequência de deploys na sua empresa.\", \"autor\":\"Adriano Almeida\", \"numeroPaginas\":\"284\"" + "}";
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}

	
	@Test
	public void deveriaDeletarUmLivro() throws Exception {
		URI uri = new URI("/livros/3"); 
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
}