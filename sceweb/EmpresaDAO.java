package br.sceweb.modelo;

import org.apache.log4j.Logger;

import br.sceweb.servico.FabricadeConexoes;



import java.sql.Connection;
import java.sql.SQLException;


public class EmpresaDAO {
	
	public int adiciona(Empresa empresa){
		preparedStatement ps;
		int codigoRetorno = 0;
		
		try(Connection conn = new FabricadeConexoes().getConnection()){
			ps = conn.prepareStatement(
					"Insert into empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereço, telefone) values (?,?,?,?,?)");
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getnNmeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
			codigoRetorno = ps.executeUpdate();
			ps.close();
		}catch (SQLExeption e ){
	throw new RuntimeExeptpion(e);
					
		}
		return codigoRetorno;
	}
}
