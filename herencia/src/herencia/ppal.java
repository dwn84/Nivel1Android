package herencia;

public class ppal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int licencias = 100;//crea un valor constante
		double x = 99;
		//Al definir una clase abstracta, NO se pueden
		//crear objetos con esa clase
		/*Persona pe1 = new Persona();
		Persona laura = new Persona();*/
		Empleado emp1 = new Empleado();
		Estudiante e1 = new Estudiante();
		Estudiante e2 = new Estudiante();
		Profesor pr1 = new Profesor();	
		System.out.println(pr1.getCedula());		
		//pe1.setNombre("Melquiadez");
		//System.out.println(pe1.saludar());
		e1.setNombre("Marco");
		e2.setNombre("Martha");
		System.out.println(e1.saludar("Ana", "Lunes"));
		System.out.println(e2.saludar());
		pr1.setNombre("Einstein");
		System.out.println(pr1.saludar());
		System.out.println(pr1.saludar());	
		e1.despedirse();
		//laura.despedirse();
		pr1.despedirse();
		emp1.despedirse();
		e1.transportarse();
		emp1.transportarse();
		pr1.transportarse();
		emp1.mostrarNombre();
		e1.reservarLibros();
		pr1.reservarLibros();
				

		 Vehiculo ferrarif40 = new Vehiculo();
	      // Con esta instrucción se imprime en la consola
	      System.out.println("El carro se inicializó con " 
	      + ferrarif40.darKilometrosRecorridos() + " km recorridos.");
	      
	      ferrarif40.incrementarKilometros(10);
	      ferrarif40.incrementarKilometros(8);
	      ferrarif40.incrementarKilometros(19);
	      ferrarif40.incrementarKilometros(2);	      
	      System.out.println("El carro ha recorrido " 
	    	      + ferrarif40.darKilometrosRecorridos() + " km recorridos.");
	
	}

}
