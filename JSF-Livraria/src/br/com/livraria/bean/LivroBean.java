package br.com.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.livraria.dao.AutorDAO;
import br.com.livraria.dao.LivroDAO;
import br.com.livraria.dao.impl.AutorDAOImpl;
import br.com.livraria.dao.impl.LivroDAOImpl;
import br.com.livraria.entity.Autor;
import br.com.livraria.entity.Livro;
import br.com.livraria.singleton.EntityManagerFactorySingleton;

@ManagedBean
@ViewScoped
public class LivroBean {
	
	private Livro livro;
	private int autorId;
	
	public LivroBean(){
		livro = new Livro();
	}

	
	public String formAutor(){
		System.out.println("Chamando o formulário do autor.. ");
		return "autor?faces-redirect=true";
	}
	
	private AutorDAO createAutorDAO(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return new AutorDAOImpl(em);
	}
	
	//metodo para apresentar na view
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}
	
	//Me da os autores do banco de dados..
	public List<Autor> getAutores(){
		return createAutorDAO().getAutores();
	}
	
	public List<Livro> getLivros(){
		return createLivroDAO().getLivros();
	}
	
	private LivroDAO createLivroDAO(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return new LivroDAOImpl(em);
	}
	
	public void salvar(){
		if(livro.getAutores().isEmpty()){
			//throw new RuntimeException("Livro deve ter pelo menos um Autor");
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor"));
			return;
		}else if(livro.getId() == 0){
			createLivroDAO().insert(this.livro);
		}	
	}
	
	//este metodo não grava no banco, ele associa o autor ao livro
	public void gravarAutor(){
		//mas para isso preciso pegar o ID do autor para passar no autorId da classe
		Autor autor = createAutorDAO().findById(this.autorId);
		this.livro.adicionaAutor(autor);
		System.out.println("Livro escrito por: " +autor.getNome());
	}
	
	
	//Getters e Setters
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}
	
	
}
