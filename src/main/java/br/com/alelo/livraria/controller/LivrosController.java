package br.com.alelo.livraria.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alelo.livraria.controller.dto.LivroDto;
import br.com.alelo.livraria.controller.form.AtualizacaoLivroForm;
import br.com.alelo.livraria.controller.form.LivroForm;
import br.com.alelo.livraria.modelo.Livro;
import br.com.alelo.livraria.repository.AutorRepository;
import br.com.alelo.livraria.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivrosController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;

	// Método para listar os LIVROS - GET;
	@GetMapping
	public List<LivroDto> lista(String titulo) {
		if (titulo == null) {
			List<Livro> livros = livroRepository.findAll();
			return LivroDto.converter(livros);

		} else {
			List<Livro> livros = livroRepository.findByTitulo(titulo);
			return LivroDto.converter(livros);
		}
	}
	
	// Método GET de UM Livro:
	@GetMapping("/{id}")
	public ResponseEntity<LivroDto> detalha(@PathVariable Long id) {
		Optional<Livro> optional = livroRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new LivroDto(optional.get()));			
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Método POST:
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDto> cadastra(@RequestBody @Valid LivroForm form, UriComponentsBuilder uriBuilder) {
		Livro livro = form.converter(autorRepository);
		livroRepository.save(livro);

		URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(new LivroDto(livro));
	}

	
	// Método PUT:
	@PutMapping("/{id}") // Atualiza TODOS os campos do registro; o PatchMapping atualiza SOMENTE os campos enviados ex. nome, msg;
	@Transactional // Avisa ao Spring que é para COMMITAR no BD ao final do método
	public ResponseEntity<LivroDto> atualiza(@PathVariable Long id, @RequestBody @Valid AtualizacaoLivroForm form) {
		Optional<Livro> optional = livroRepository.findById(id);
		if (optional.isPresent()) {
			Livro livro = form.atualiza(id, livroRepository);
			return ResponseEntity.ok(new LivroDto(livro));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Método DELETE:
	@DeleteMapping("/{id}")
	@Transactional // Avisa ao Spring que é para COMMITAR no BD ao final do método
	public ResponseEntity<?> remove(@PathVariable Long id){
		Optional<Livro> optional = livroRepository.findById(id);
		if(optional.isPresent()) {
			livroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else { 
			return ResponseEntity.notFound().build();
		}
	}
}
