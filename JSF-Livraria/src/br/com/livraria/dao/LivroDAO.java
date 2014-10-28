package br.com.livraria.dao;

import java.util.List;

import br.com.livraria.entity.Livro;

public interface LivroDAO extends DAO<Livro, Integer> {

	List<Livro> getLivros();
}
