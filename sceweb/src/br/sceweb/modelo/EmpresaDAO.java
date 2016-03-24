package br.sceweb.modelo;

import org.apache.log4j.Logger;

import com.mysql.jdbc.PreparedStatement;

import br.sceweb.servico.FabricadeConexoes;

import java.sql.Connection;
import java.sql.SQLException;


public class EmpresaDAO {
	
	public int adiciona(Empresa empresa){
		PreparedStatement ps;
		int codigoRetorno = 0;
		
		try(Connection conn = new FabricadeConexoes().getConnection()){
			ps = (PreparedStatement) conn.prepareStatement(
					"Insert into empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) values (?,?,?,?,?)");
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
			codigoRetorno = ps.executeUpdate();
			ps.close();
		}
		
		catch (SQLException e){
	throw new RuntimeException(e);
					
		}
		return codigoRetorno;
	}


public int exclui (String cnpj){
	PreparedStatement ps;
	int codigoRetorno = 0;
	try (Connection conn = new FabricadeConexoes().getConnection()){
		ps = (PreparedStatement) conn.prepareStatement("delete from empresa where cnpj = ?");
		ps.setString(1,cnpj);
		codigoRetorno = ps.executeUpdate();
	}catch (SQLException e){
		throw new RuntimeException(e);
				
	}
	return codigoRetorno;	
}
}

