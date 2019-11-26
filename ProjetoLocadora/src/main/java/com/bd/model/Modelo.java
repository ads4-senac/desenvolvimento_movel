package com.bd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "modelo")
public class Modelo {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	
	@Column(name = "mod_id")
	private Long id;

	@Column(name = "mod_descricao")
	private String descricao;

	@Column(name = "mar_id")
	private Long mar;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getMar() {
		return mar;
	}

	public void setMar(Long mar) {
		this.mar = mar;
	}

	@Override
	public String toString() {
		return "Modelo{" +
				"id=" + id +
				", descricao='" + descricao + '\'' +
				", mar=" + mar +
				'}';
	}
}
