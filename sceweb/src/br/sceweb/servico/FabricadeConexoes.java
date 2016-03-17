package br.sceweb.servico;

import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class FabricadeConexoes {
	
Logger logger = Logger .getLogger(FabricadeConexoes.class);
public Connection getConnection() {
	
	String url = "jdbc.mysql://localhost/sceweb";
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url,"root","");
	}
		
	catch (Exception e ){
		logger.info("SQLExeption na classe Fabrica de Conexoes causa: " + e.getMessage());
		
		throw new RuntimeException(e);
		
		
	}
		
}
}


	public int excluir (String cnpj){
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = new FabricadeConexoes().getConnection()){
			ps = conn.prepareStatement("delete from empresa where cnpj = ?");
			ps.SetString(1,cnpj);
			codigoRetorno = ps.executeUpdate();
		}catch (SQLExcpetion e){
			throw new RuntimeException(e);
					
		}
		return codigoRetorno;	
	}
































