package br.com.livraria.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.livraria.dao.LivroDAO;
import br.com.livraria.entity.Livro;

public class LivroDAOImpl extends DAOImpl<Livro, Integer> implements LivroDAO {

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Livro> getLivros() {
		TypedQuery<Livro> query = em.createQuery("SELECT l FROM Livro l", Livro.class);
		return query.getResultList();
	}

}
