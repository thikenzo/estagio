package br.sceweb.modelo;

import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.SQLException;


public class EmpresaDAO {
	
	public String adiciona(Empresa empresa){
		try (Connection conn = new FabricadeConexoes().getConnection()){
			
		}
		
	catch (SQLException e){
		throw new RuntimeException(e);
	}
		return "cadastro realizzado com sucesso" ;
	}
}
