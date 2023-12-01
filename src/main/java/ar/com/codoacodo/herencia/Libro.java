package ar.com.codoacodo.herencia;

public class Libro extends Articulo{
	//libro no puede nacer si primero no nace el articulo
	private String isbn;

	public Libro(String titulo, Float precio, String img, String isbn) {
		super(titulo, precio, img);
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + "]";
	}
	
	
}
