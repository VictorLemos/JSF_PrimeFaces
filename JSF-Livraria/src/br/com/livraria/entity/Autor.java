package br.com.livraria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TAB_AUTOR")
@GenericGenerator(name="seqAutor", strategy="increment")
public class Autor {

	@Id
	@Column(name="COD_AUTOR")
	@GeneratedValue(generator="seqAutor", strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="NM_AUTOR", nullable=false)
	private String nome;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
