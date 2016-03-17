package br.sceweb.modelo;

public class Empresa {
	String cnpj;
	String nomeDaEmpresa;
	String nomeFantasia;
	String endereco;
	String telefone;
	
	public String getNomeDaEmpresa(){
		return nomeDaEmpresa;	
		
	}
public void setNomeDaEmpresa(String nomeDaEmpresa){
	this.nomeDaEmpresa = nomeDaEmpresa;
}
}
