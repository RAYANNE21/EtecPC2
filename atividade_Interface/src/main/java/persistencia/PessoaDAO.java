package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserSistema;
import model.Pessoa;
import eteczl.atividade_Interface.App;
import java.sql.Connection;


public class PessoaDAO<T extends Pessoa>  implements IDAO<T>{
	
	Connection conn;
	
	public PessoaDAO(Connection conn2){
		this.conn = conn2;
		
	}

	public void inserir(T o) throws Exception {
		
		Conexao pessoa = new Conexao();
		String sql ="insert INTO aluno (nome) value ('"+((UserSistema) o).getLogin()+"')";
		System.out.println(sql);
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.executeUpdate();
	}

	public List<T> listar() throws Exception {
		List<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
		return null;
	}



	

	

	
}
