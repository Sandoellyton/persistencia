package aplicacao_console;

import fachada.Fachada;

public class Consultar {

	public Consultar(){

		try {
			Fachada.inicializar();
			System.out.println("Busca de Video por assunto\n"+Fachada.consultarVideosPorAssunto("persistencia")+"\n");
			System.out.println("Busca de video pelo usuario\n"+Fachada.consultarVideosPorUsuario("gustavo@email.com")+"\n");
			System.out.println("Busca de usuario por video\n"+Fachada.consultarUsuarioPorVideo("youtube.com/persistencia")+"\n");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
		System.out.println("\nfim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

