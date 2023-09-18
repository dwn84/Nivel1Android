package herencia;

public class Persona {
	private String cedula;
	private String nombre;
	private String telefono;
	private String direccion;
	
	//polimorfismo por sobrecarga
	public String saludar() {
		return "Hola!, yo soy " + nombre + ", mucho gusto";
	}
	
	public String saludar(String nom, String dia) {
		return "Hola!, yo soy " 
				+ nombre + ", mucho gusto: " 
				+ nom + " Hoy es:" + dia;
	}
	
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
