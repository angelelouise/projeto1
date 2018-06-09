package br.ufrn.ws.angprojservice.dominio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name= "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id;
	
	@NotEmpty
	@Column(name ="usuario")
	private String usuario;
	
	@NotEmpty
	@Column(name ="senha")
	private String senha;
	
	@NotEmpty
	@Column(name ="nome")
	private String nome;
	
	@NotEmpty
	@Column(name ="email")
	private String email;
	
	@Column(name ="descricao")
	private String descricao;
	
	@FutureOrPresent
	@Column(name ="datacadastro")
	private LocalDate dataCadastro;

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return usuario;
	}

	public void setUser(String user) {
		this.usuario = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
