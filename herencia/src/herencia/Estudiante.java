package herencia;

public class Estudiante extends Persona implements indumentaria{

	@Override
	public void despedirse() {
		System.out.println("Hasta mañana");	
	}

	@Override
	public void transportarse() {
		System.out.println("Me voy en uber");		
	}
	

	
	//cambiar los datos del contructor heredado
	public Estudiante() {
		super();//constructor de la clase superior - clase padre - la clase que se encuentra en el extends
		//traer los métodos de la clase de nivel superior
		super.setCedula("111");
		super.setDireccion("Calle 99#9-99");
		
		//invocar los métodos respectivos
		System.out.println(this.saludar());//de la clase Estudiante
		System.out.println(super.saludar());//de la clase Persona
			
		
			
		
	}
	//Polimorfismo por reescritura de método
	public String saludar() {
		return "Soy estudiante de la institucion INFOCENTER!";
	}

	@Override
	public void equiparVestuario() {
		System.out.println("Me pongo el uniforme");
		
	}

	@Override
	public void reservarLibros() {
		System.out.println("Puedo prestar 5 libros al mes");
		
	}
	

}
