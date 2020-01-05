package br.com.callCenterVendas.model.domain;

import util.ValidacaoException;

public class Fornecedor extends Pessoa {

	private String razaoSocial;
	private String cnpj;
	
	public void valida() throws ValidacaoException {
		super.valida();
		if(razaoSocial == null || razaoSocial.equals("")){
			throw new ValidacaoException("Campo razão social obrigatório!");
		}
		
		if(cnpj == null || cnpj.equals("")){
			throw new ValidacaoException("Campo CNPJ obrigatório!");
		}
	}

	public Fornecedor(Integer codigo, String nome, String email, String razaoSocial, String cnpj) {
		super(codigo, nome, email);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}


	public Fornecedor() {
		
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
