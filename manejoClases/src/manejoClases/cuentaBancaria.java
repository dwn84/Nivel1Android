package manejoClases;
import java.util.Calendar;

public class CuentaBancaria {
	//atributos de la clase
	private double saldo;
	private Calendar fechaCreacion;
	private Cliente propietarioCuenta;	

	//constructor
	
	public CuentaBancaria() {		 
		this.saldo = 9999999;
		this.propietarioCuenta = new Cliente("N.N.","601999999","Calle siempreviva 1-1");
		this.fechaCreacion = Calendar.getInstance();	
	}
	
	//sobrecarga de constructor
	
	public CuentaBancaria(String nombre,String telefono, String direccion) {		 
		this.saldo = 0;
		this.propietarioCuenta = new Cliente(nombre, telefono, direccion);
		this.fechaCreacion = Calendar.getInstance();	
	}
	
	public CuentaBancaria(String nombre,String telefono, String direccion, double dinero) {		 
		this.saldo = dinero;
		this.propietarioCuenta = new Cliente(nombre, telefono, direccion);
		this.fechaCreacion = Calendar.getInstance();	
	}
	
	//métodos - acciones
	
	//modificar de acceso(public - private)
	//tipo de retorno (int, double, String, String[], void)
	//nombre del método (en forma de verbo)
	//entre paréntesis, los datos de entrada (parámetros)
	//SI el método tiene un tipo de retorno diferente de void, 
	//debe tener al final el retorno (return)

	public void consignar(double dinero) {		
		saldo += dinero;
	}
	
	public String retirar(double dinero) {		
		if(dinero<=saldo) {
			saldo -= dinero;
			return "Retiro de dinero exitoso. El saldo es:" + saldo;
		}else{
			return "Saldo insuficiente. El saldo actual es:" + saldo;
		}		
	}
	
	public String getSaldo() {
		return "El saldo actual es: " + saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getFechaCreacion() {
		int annio = this.fechaCreacion.get(Calendar.YEAR);
        int mes = this.fechaCreacion.get(Calendar.MONTH) + 1; // Los meses en Calendar van de 0 a 11, por lo que sumamos 1
        int dia = this.fechaCreacion.get(Calendar.DAY_OF_MONTH);

		return "Fecha de apertura de cuenta: " + annio + "-" + mes + "-" + dia ;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public void setNombreCliente(String nombre) {
		propietarioCuenta.setNombre(nombre);		
	}
	
	public void setDireccionCliente(String direccion) {
		propietarioCuenta.setDireccion(direccion);		
	}
	public void setTelefonoCliente(String telefono) {
		propietarioCuenta.setTelefono(telefono);		
	}
	public String getDatosCliente() {
		String datos = "Nombre completo: "
		               + propietarioCuenta.getNombre()
		               + "\nDireccion: "
		               + propietarioCuenta.getDireccion()
		               + "\nTelefono: "
		               + propietarioCuenta.getTelefono();
		return datos;
	}
	
}


