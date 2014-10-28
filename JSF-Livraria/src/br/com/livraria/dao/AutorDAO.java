package br.com.livraria.dao;

import java.util.List;

import br.com.livraria.entity.Autor;

public interface AutorDAO extends DAO<Autor, Integer>  {

	List<Autor> getAutores();
	
}
