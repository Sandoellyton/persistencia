package aplicacao_console;

import fachada.Fachada;

import java.time.LocalDateTime;

public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();

			System.out.println("cadastrando...");

			LocalDateTime dataHora = LocalDateTime.now();

			// CADASTRAR VIDEOS

			Fachada.cadastrarVideo("youtube.com/persistencia", "persistencia de dados", "persistencia", dataHora);
			Fachada.cadastrarVideo("youtube.com/banco-de-dados", "postgreSQL", "sql", dataHora);


			// CADASTRAR USUARIOS

			Fachada.cadastrarUsuario("sandy@email.com");
			Fachada.cadastrarUsuario("jhonatha@email.com");
			Fachada.cadastrarUsuario("gustavo@email.com");
			Fachada.cadastrarUsuario("galisa@email.com");


			//REGISTRAR VISUALIZAÇÃO
			Fachada.registrarVisualizacao("youtube.com/persistencia", "gustavo@email.com", 8);
			Fachada.registrarVisualizacao("youtube.com/persistencia", "galisa@email.com", 8);
			Fachada.registrarVisualizacao("youtube.com/persistencia", "sandy@email.com", 5);
			Fachada.registrarVisualizacao("youtube.com/banco-de-dados", "sandy@email.com", 7);
			Fachada.registrarVisualizacao("youtube.com/banco-de-dados", "jhonatha@email.com", 5);


		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}
