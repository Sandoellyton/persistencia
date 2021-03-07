package aplicacao_console;

import fachada.Fachada;

public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		try {
			System.out.println("adicionando assuntos...");
			Fachada.adicionarAssunto("youtube.com/banco-de-dados", "relacional");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

