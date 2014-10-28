package br.com.livraria.dao;

public interface DAO<T,K> {

	//DAO com m�todos gen�ricos para reutiliza��o
	void insert(T entity);
	void update(T entity);
	void remove(K id);
	T findById(K id);
}
