package br.com.livraria.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.livraria.dao.AutorDAO;
import br.com.livraria.entity.Autor;

public class AutorDAOImpl extends DAOImpl<Autor, Integer> implements AutorDAO{

	public AutorDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Autor> getAutores() {
		TypedQuery<Autor> query = em.createQuery("SELECT a FROM Autor a", Autor.class);
		return query.getResultList();
	}

}
