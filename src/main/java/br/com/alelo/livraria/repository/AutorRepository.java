package br.com.alelo.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alelo.livraria.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Autor findByNome(String nome);
}