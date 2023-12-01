package ar.com.codoacodo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//instanciar un objeto de la clase Auto
				Auto clio = new Auto("renault",
						"clio",
						"azul",
						2020,
						"abc123",
						3f);
				
				clio.encender();
				
				clio.acelerar();
				
				clio.frenar();
				clio.frenar();
	}

}
