package com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.model.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{
	
}
