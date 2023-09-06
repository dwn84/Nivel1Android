package manejoClases;

import java.util.Date;

public class cuentaBancaria {
	//atributos de la clase
	private double saldo;
	private String nombreCliente;
	private Date fechaCreacion;
	
	//métodos - acciones
	
	//modificar de acceso(public - private)
	//tipo de retorno (int, double, String, void)
	//nombre del método (en forma de verbo)
	//entre paréntesis, los datos de entrada
	//SI el método tiene un tipo de retorno diferente de void, 
	//debe tener al final el retorno (return)
	public double consultarEstadoCuenta(int s, double t, String n) {
		double total = 111;	
		if(s != 0) {
			total = (t / s) + total; 
		}					
		
		return total;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}


