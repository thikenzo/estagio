package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {

	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("Empresa x");
		empresa.setCnpj("8942423200180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}

	@Test(expected = RuntimeException.class)
	public void CT02UC02FBCadastro_empresa_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0,empresaDAO.adiciona(empresa));
		}	
	

	public void CT03UC03FBCadastra_empresa_cnpj_ja_invalido() {
		Empresa empresa2 = new Empresa();
		try{
			empresa2.setCnpj("8942423200018");
			fail("deveria disparar uma exception");
		} catch (Exception e){
			assertEquals("CNPJ inválido!", e.getMessage());
			
		}
	}
		
		public void CT04UC04FBCadastra_empresa_com_dados_invalidos() {
			Empresa empresa2 = new Empresa();
			try{
				empresa2.setNomeDaEmpresa("");
				fail("deveria disparar uma exception");
			} catch (Exception e){
				assertEquals("nome da empresa invalido!", e.getMessage());
				
			}
		
	}	
				
	@Test
	public void CT01UC01FBCadastro_com_sucesso() {
		empresaDAO.exclui("8942423200180");
		assertEquals(1,empresaDAO.adiciona(empresa));
		empresaDAO.exclui("8942423200180");
	}

	@AfterClass	
	public static void tearDownAfterClass() throws Exception {
	}
}




