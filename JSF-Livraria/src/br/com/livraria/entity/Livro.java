package br.com.livraria.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="TAB_LIVRO")
@GenericGenerator(name="seqLivro", strategy="increment")
public class Livro {

	@Id
	@Column(name="COD_LIVRO")
	@GeneratedValue(generator="seqLivro", strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="TITULO", nullable=false)
	private String titulo;
	
	@Column(name="ISBN", nullable=false)
	private String isbn;
	
	@Column(name="PRECO", nullable=false)
	private double preco;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_LANCAMENTO", nullable=false)
	private Calendar dataLancamento = Calendar.getInstance();
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="TAB_AUTOR_LIVRO",joinColumns={@JoinColumn(name="COD_LIVRO")},inverseJoinColumns={@JoinColumn(name="COD_AUTOR")})
	private List<Autor> autores = new ArrayList<Autor>();
	
	public void adicionaAutor(Autor autor) {
		this.autores.add(autor);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Calendar getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	
	
}
