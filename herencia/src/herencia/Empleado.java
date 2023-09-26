package herencia;

public class Empleado extends Persona implements IPersona{

	@Override
	public void despedirse() {
		System.out.println("Hasta pronto, ha sido un dia laboral muy producto");
	}

	@Override
	public void transportarse() {
		System.out.println("Me voy en bus...");		
	}

	@Override
	public void mostrarNombre() {
		System.out.println("Soy "+ getNombre());
		
	}

	@Override
	public void mostrarEdad() {
		System.out.println("Tengo muchos años");
		
	}

	@Override
	public void mostrarTelefono() {
		// TODO Auto-generated method stub
		
	}

}
