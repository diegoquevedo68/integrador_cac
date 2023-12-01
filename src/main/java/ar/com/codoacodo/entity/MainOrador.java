package ar.com.codoacodo.entity;

import java.time.LocalDate;

public class MainOrador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//crear un objeto de la clase orador, que luego se enviara a la db
		Orador nuevoOrador = new Orador("carlos", "lopez", "email@email.com", "JAVA", LocalDate.now()); 
				
		System.out.println(nuevoOrador);
	}

}
