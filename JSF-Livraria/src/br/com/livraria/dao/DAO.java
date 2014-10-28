package br.com.livraria.dao;

public interface DAO<T,K> {

	//DAO com métodos genéricos para reutilização
	void insert(T entity);
	void update(T entity);
	void remove(K id);
	T findById(K id);
}
