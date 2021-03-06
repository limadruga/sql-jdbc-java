package pos_java_jdbc.pos_java_jdbc;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.sun.jna.platform.win32.WinBase.PROCESS_INFORMATION.ByReference;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.UserPosJava;

public class TesteBancoJDBC {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		UserPosJava userPosJava = new UserPosJava();
		userPosJava.setId(10L);
		userPosJava.setNome("Arthur");
		userPosJava.setEmail("arthur@gmail.com");
		
		userPosDAO.salvar(userPosJava);
	}
	
	public void initListar() throws SQLException {
		UserPosDAO dao = new UserPosDAO();
		List<UserPosJava> list = dao.listar();
		for(UserPosJava userPosJava: list) {
			System.out.println(userPosJava);
			System.out.println("-----------------------------------");
		}
	}
	
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		
		try {
			UserPosJava userPosJava = dao.buscar(10L);
			System.out.println(userPosJava);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			UserPosJava objetoBanco = dao.buscar(5L);
			objetoBanco.setNome("Nome mudado com método atualizar");
			dao.atualizar(objetoBanco);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(5L);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(83) 9392-8392");
		telefone.setTipo("Casa");
		telefone.setUsuario(16L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void testeCarregaFonesUser() {
		UserPosDAO dao = new UserPosDAO();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(10L);
		
		for(BeanUserFone beanUserFone: beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("------------------------------------------------");
		}
	}
	
	public void testeDeleteUserFone() {
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(15L);
	}
}
