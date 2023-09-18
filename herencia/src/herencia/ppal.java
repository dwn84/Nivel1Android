package herencia;

public class ppal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int licencias = 100;
		double x = 99;
		Persona pe1 = new Persona();
		Estudiante e1 = new Estudiante();
		Estudiante e2 = new Estudiante();
		Profesor pr1 = new Profesor();
		pe1.setNombre("Melquiadez");
		System.out.println(pe1.saludar());
		e1.setNombre("Marco");
		e2.setNombre("Martha");
		System.out.println(e1.saludar("Ana", "Lunes"));
		System.out.println(e2.saludar());
		pr1.setNombre("Einstein");
		System.out.println(pr1.saludar());
				
		x = 99/99;
		
		
		x = 88/99;
		
		x = 77/99;
		
	}

}
