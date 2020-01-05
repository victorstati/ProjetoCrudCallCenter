package br.com.callCenterVendas.model.domain;

import util.ValidacaoException;

public class Pessoa {

	private Integer codigo;
	private String nome;
	private String email;
	
	public void valida() throws ValidacaoException {
		if(nome == null || nome.equals("")){
			throw new ValidacaoException("Campo nome obrigatório!");
		}
	}
	
	
	public Pessoa() {
		
	}


	public Pessoa(Integer codigo, String nome, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	
	

}
