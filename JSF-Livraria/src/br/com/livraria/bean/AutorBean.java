package br.com.livraria.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.livraria.dao.AutorDAO;
import br.com.livraria.dao.impl.AutorDAOImpl;
import br.com.livraria.entity.Autor;
import br.com.livraria.singleton.EntityManagerFactorySingleton;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor;
	
	
	public AutorBean(){
		autor = new Autor();
	}
	
	public void remover(String cod){
		getAutores().remove(getAutor().getId());
		int codigoBusca = Integer.parseInt(cod);
		createAutorDAO().remove(codigoBusca);
		autor = new Autor();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("autor.xhtml");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private AutorDAO createAutorDAO(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		return new AutorDAOImpl(em);
	}
	
	public String formLivro(){
		//Chamando o formulário do livro..
		return "livro?faces-redirect=true";
	}
	
	//Me da os autores do banco de dados..
		public List<Autor> getAutores(){
			return createAutorDAO().getAutores();
		}
	
	public void salvar(){
		if(autor.getId() == 0){
			//Cadastre um autor
			System.out.println("Gravando autor " + this.autor.getNome());
			createAutorDAO().insert(this.autor);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor cadastrado com sucesso!!", null));
			this.autor = new Autor();
		}else{
			//Atualize um Autor
		System.out.println("Alterando autor " + this.autor.getNome());
		createAutorDAO().update(this.autor);
		}
	}
	
	//Getters e Setters
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
