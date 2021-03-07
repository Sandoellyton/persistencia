package aplicacao_console;

import fachada.*;

public class Deletar {

	public Deletar() {
		
		try {
			Fachada.inicializar();
			
			System.out.println("Apagando... ");
			/*Fachada.apagarVisualizacao(1);*/
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}


	public void deletar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
		
}
