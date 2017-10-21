package persistencia;

import java.util.List;

import model.UserSistema;

public interface IDAO<T> {
	
	 void inserir(T o) throws Exception; 
	 List<T> listar() throws Exception;

}
