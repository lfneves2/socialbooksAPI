package com.algaworks.socialbooks.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.model.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;

@RestController
@RequestMapping(value="/livros")
public class LivrosResources {
	
	@Autowired
	LivrosRepository livrosRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Livro livro) {
		livrosRepository.save(livro);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Livro buscar(@PathVariable Long id) {
		return livrosRepository.findOne(id);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id) {
		livrosRepository.delete(id);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void atualizar(@RequestBody Livro livro, @PathVariable Long id) {
		livro.setId(id);
		livrosRepository.save(livro);
	}
	
}
