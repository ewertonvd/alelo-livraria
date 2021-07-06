package br.com.alelo.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alelo.livraria.modelo.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	List<Livro> findByTitulo(String titulo);
	
	List<Livro> findByAutorNome(String nome);
}