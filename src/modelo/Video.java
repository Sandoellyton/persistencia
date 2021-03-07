package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Video {
	private String link;
	private String nome;
	private double media;
	private LocalDateTime dataHora = LocalDateTime.now();
	private List<Assunto> assuntos = new ArrayList<>();
	private List<Visualizacao> visualizacoes = new ArrayList<>();


	public Video(String link, String nome, String palavra, LocalDateTime dataHora) {
		this.link = link;
		this.nome = nome;
		this.assuntos.add(new Assunto(palavra));

	}

	public String getNome() {
		return nome;
	}

	public String getLink() {
		return link;
	}

	public double getMedia() {
		double total = 0;
		for(Visualizacao v : visualizacoes) {
			total += v.getNota();
		}
		media = total / visualizacoes.size();
		return media;
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
	}

	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}

	@Override
	public String toString() {
		String texto = "\nVideo [" + (link != null ? "link=" + link + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ "media=" + getMedia() + ", " + "dataHora=" + dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss"));

		texto+=", assuntos=";
		for(Assunto a : assuntos) {
			texto += a.getPalavra() + ", ";
		}
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			//texto += vis;
			texto += (vis != null ? vis + ", " : "");
		}
		return texto;
	}
}
