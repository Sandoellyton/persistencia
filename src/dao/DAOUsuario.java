package dao;

import java.util.List;
import com.db4o.query.Query;
import modelo.Usuario;
import modelo.Video;

public class DAOUsuario extends DAO<Usuario>{

	public Usuario read (Object chave) {
		String mail = (String) chave;
		
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("email").constrain(mail);
		List<Usuario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public List<Usuario> consultarUsuarioPorVideo(String link) {
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("visualizacoes").descend("video").descend("link").constrain(link);
		List<Usuario> result = q.execute(); 
		return result;
	}
}

