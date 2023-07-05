package com.zavala.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acessorio_seq")
	@SequenceGenerator(name="acessorio_seq", sequenceName="sq_acessorio", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", length = 100, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "CLASSIFICACAO", length = 100, nullable = false)
	private String classificacao;
	
	@Column(name = "DETALHES_TECNICOS", length = 100, nullable = true)
	private String detalhes_tecnicos;
	
	@ManyToMany(mappedBy = "acessorios")
	private List<Carro> carros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getDetalhes_tecnicos() {
		return detalhes_tecnicos;
	}

	public void setDetalhes_tecnicos(String detalhes_tecnicos) {
		this.detalhes_tecnicos = detalhes_tecnicos;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

}
