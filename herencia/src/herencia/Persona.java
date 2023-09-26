package herencia;

public abstract class Persona {
	private String cedula;
	private String nombre;
	private String telefono;
	private String direccion;
	
	//constructores
	public Persona() {
		cedula = "999";
		nombre = "N.N.";
		telefono = "3012225588";
		direccion = "Cra 1 #1-11";		
	}	
	
	public Persona(String cedula, String nombre, String telefono, String direccion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	//polimorfismo por sobrecarga
	public String saludar() {
		return "Hola!, yo soy " + nombre + ", mucho gusto";
	}
	//impedir que el método se pueda reescribir por los herederos
	public String saludar(String nom, String dia) {
		return "Hola!, yo soy " 
				+ nombre + ", mucho gusto: " 
				+ nom + " Hoy es:" + dia;
	}
	//Métodos abstractos: sin código o implementación
	public abstract void despedirse();
	public abstract void transportarse();
		
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	


}
