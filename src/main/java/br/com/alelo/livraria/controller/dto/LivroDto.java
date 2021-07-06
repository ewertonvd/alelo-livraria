package br.com.alelo.livraria.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alelo.livraria.modelo.Livro;

public class LivroDto {

	private Long id;
	private String titulo;
	private String conteudo;
	private String autor;
	private Integer numeroPaginas;

	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.conteudo = livro.getConteudo();
		this.autor = livro.getAutor().getNome();
		this.numeroPaginas = livro.getNumeroPaginas();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}
}