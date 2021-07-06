package br.com.alelo.livraria.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alelo.livraria.modelo.Autor;
import br.com.alelo.livraria.modelo.Livro;
import br.com.alelo.livraria.repository.AutorRepository;

public class LivroForm {

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

	public String getConteudo() {
		return conteudo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public Livro converter(AutorRepository autorRepository) {
		Autor autor = autorRepository.findByNome(nomeAutor);
		return new Livro(titulo, conteudo, autor, numeroPaginas);
	}
}
