package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visualizacao {
	private int id;
	private LocalDateTime datahora = LocalDateTime.now();
	private int nota;
	private Usuario usuario;
	private Video video;
	
	public Visualizacao(int id, int nota, Usuario usuario, Video video) {
		this.id = id;
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
	}
	
	public int getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return "[id=" + id + 
				", datahora=" + datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss")) + 
				", nota=" + nota +
				"\n usuario=" + usuario.getEmail() + ", video=" + video.getNome() + "]";
	}
}
