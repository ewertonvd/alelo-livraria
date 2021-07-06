package br.com.alelo.livraria.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alelo.livraria.modelo.Livro;
import br.com.alelo.livraria.repository.LivroRepository;

public class AtualizacaoLivroForm {

	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String titulo;

	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String conteudo;

	@NotNull
	@NotEmpty
	private String nomeAutor;

	@NotNull
	private Integer numeroPaginas;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Livro atualiza(Long id, LivroRepository livroRepository) {
		Livro livro = livroRepository.getOne(id);
		livro.setTitulo(titulo);
		livro.setConteudo(conteudo);
		livro.getAutor().setNome(nomeAutor);
		livro.setNumeroPaginas(numeroPaginas);
		return livro;
	}
}