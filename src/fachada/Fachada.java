package fachada;

import dao.DAO;
import dao.DAOAssunto;
import dao.DAOVideo;
import dao.DAOVisualizacao;
import dao.DAOUsuario;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

import java.time.LocalDateTime;
import java.util.List;

public class Fachada {

	private static DAOVideo daovideo = new DAOVideo();
	private static DAOAssunto daoassunto = new DAOAssunto();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();
	private static DAOUsuario daousuario = new DAOUsuario();
	private static int id;

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	public static Video cadastrarVideo(String link, String nome, String palavra, LocalDateTime dataHora) throws  Exception{
		DAO.begin();
		Video video = daovideo.read(link);
		if(video != null) {
			DAO.rollback();
			throw new Exception("video: " + link + " ja cadastrado");
		}
		video = new Video(link, nome, palavra, dataHora);
		daovideo.create(video);
		DAO.commit();
		return video;
	}

	public static Usuario cadastrarUsuario(String email) throws  Exception{
		DAO.begin();
		Usuario usuario = daousuario.read(email);
		if(usuario != null) {
			DAO.rollback();
			throw new Exception("usuario: " + email + " ja cadastrado");
		}
		usuario = new Usuario(email);
		daousuario.create(usuario);
		DAO.commit();
		return usuario;
	}

	public static void registrarVisualizacao(String link, String email, int nota) throws Exception{
		DAO.begin();
		Video video = daovideo.read(link);
		if(video == null) {
			DAO.rollback();
			throw new Exception("video: " + link + " não existe");
		}
		Usuario usuario = daousuario.read(email);
		if(usuario == null) {
			DAO.rollback();
			throw new Exception("usuario: " + email + " não existe");
		}
		Visualizacao visualizacao = new Visualizacao(id, nota, usuario, video);
		usuario.adicionar(visualizacao);
		video.adicionar(visualizacao);
		daovisualizacao.create(visualizacao);
		DAO.commit();
		id++;
	}

    public static void apagarVisualizacao(int id) throws Exception {
        DAO.begin();
        Visualizacao visualizacao = daovisualizacao.read(id);
        if (visualizacao == null) {
            DAO.rollback();
            throw new Exception("id de visualização inexistente:" + visualizacao);
        }
        daovisualizacao.delete(visualizacao);
        DAO.commit();
    }


	public static void adicionarAssunto(String link, String assunto) throws  Exception{
		DAO.begin();
		Video video = daovideo.read(link);
		if(video == null) {
			DAO.rollback();
			throw new Exception("video: " + link + " não existe");
		}

		video.adicionar(new Assunto(assunto));

		daovideo.update(video);
		DAO.commit();
	}

	public static Visualizacao localizarVisualizacao(int id) {
		DAO.begin();
		Visualizacao visualizacao = daovisualizacao.read(id);
		if(visualizacao == null) {
			DAO.rollback();
			return null;
		}else {
			return visualizacao;
		}
	}

	public static List<Video> listarVideos(){
		return daovideo.readAll();
	}

	public static List<Usuario> listarUsuarios() {
		return daousuario.readAll();
	}

	public static List<Assunto> listarAssunto(){
		return daoassunto.readAll();
	}

	public static List<Visualizacao> listarVisualizacao(){
		return daovisualizacao.readAll();
	}


	//METODOS DE BUSCA
	public static List<Video> consultarVideosPorAssunto(String palavra) {
		return daovideo.consultarVideosPorAssunto(palavra);
	}

	public static List<Video> consultarVideosPorUsuario(String email) {
		return daovideo.consultarVideosPorUsuario(email);
	}

	public static List<Usuario> consultarUsuarioPorVideo(String link) {
		return daousuario.consultarUsuarioPorVideo(link);

	}

}
