package eteczl.atividade_Interface;

import java.util.List;

import javax.swing.JFrame;


import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.UserSistema;
import persistencia.Conexao;
import view.LoginPanel;
import persistencia.PessoaDAO;

public class App 
{
	private static String versao = "v1.0";
	private List<UserSistema> userCadastrados = new ArrayList<UserSistema>();
	private List<UserSistema> userLogados = new ArrayList<UserSistema>();
	private UserSistema usuarioLogado;
	
	public App(){
		this.userCadastrados.add(new UserSistema("Administrador","ray","123456"));
		this.showPanelLogin();
		
	}
	
	public void showPanelLogin(){
		JFrame jFrame = new JFrame("Interface Principal");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jFrame.add(new LoginPanel(this));
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setSize(250,150);
		jFrame.setResizable(false);
		
	
	}
	
	public List<UserSistema> getUsuariosCadastrados(){
		return userCadastrados;
	}
	
	public UserSistema getUsuarioLogado() {
		return usuarioLogado;
	}	
	
	public void setUserLogado(UserSistema userLogado){
		this.userLogados = userLogados;
	}
	public List<UserSistema> getUsuariosLogados() {
		return userLogados;
	}

	public void setUsuariosLogados(List<UserSistema> usuariosLogados) {
		this.userLogados = userLogados;
	}
	
	public static void main(String[] args) throws Exception {
		new App();
		Connection conn = new Conexao().getMysqlConnection();

		PessoaDAO pessoa = new PessoaDAO(conn);
		UserSistema a = new UserSistema("nomeCompleto " , "E", " senha ");
		pessoa.inserir(a);
	
		/*ResultSet rss = stm.executeQuery("Select * from aluno");
			while(rss.next()){
				System.out.println(rss.getString("nome"));	
			}
		
		System.out.println(mysqlConnection);*/
		
		
		
	}
	
}
