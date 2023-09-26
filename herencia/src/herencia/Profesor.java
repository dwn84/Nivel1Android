package herencia;

public class Profesor extends Persona implements indumentaria{
	@Override
	public void despedirse() {
		System.out.println("Hasta pronto");	
	}

	@Override
	public void transportarse() {
		System.out.println("Me voy en mi carrito");		
	}

	@Override
	public void equiparVestuario() {
		System.out.println("Me he puesto una bata de laboratorio");
	}

	@Override
	public void reservarLibros() {
		System.out.println("Puedo prestar 20 libros al mes");
		
	}
}
