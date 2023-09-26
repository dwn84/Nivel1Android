package herencia;

public class Vehiculo {
	
	private double kilometrosRecorridos;
	private double tiempoDeRecorrido;
	private double galones;
	private double aceite;
	   
	public Vehiculo ()
	{
		kilometrosRecorridos = 0;tiempoDeRecorrido = 0;
	}
	//Aplicando técnica de refactorización: consolidación de condicional
	//https://refactoring.guru/consolidate-conditional-expression
	public double validarParametros() {
		if (condicionales()) {
			return 0;
		}		
		return 99;
		
	}
	
	private boolean condicionales() {
		if((kilometrosRecorridos>9999)
				||(tiempoDeRecorrido>8700) 
				||(galones>1000)
				||(aceite==555)) {
			return true;
		}else {
			return false;
		}
	}
	
	public double agregarRecorrido(double kilometrosRecorridosP, double tiempoDeRecorridoP)
	{	
			
		if(kilometrosRecorridosP >= 0 && tiempoDeRecorridoP >= 0)
		{
			kilometrosRecorridos += kilometrosRecorridosP;
			tiempoDeRecorrido += tiempoDeRecorridoP;	
		}			      
		  
		double galonesConsumidos = kilometrosRecorridosP/40.0;
		galones -= galonesConsumidos;
		  
		kilometrosRecorridos += kilometrosRecorridosP;
		return galonesConsumidos;
	}
	   
	public double darVelocidadPromedioDelRecorrido ()
	{
		return kilometrosRecorridos/tiempoDeRecorrido;
	}
	
	public String darEstadoAceite ()
	{
		String estadoAceite = "no necesita cambio";
		if(kilometrosRecorridos > 20000);
		{
			estadoAceite = "NECESITA CAMBIO!";
	    }
	      return estadoAceite;
	}
	
	public void incrementarKilometros(double kilometrosViaje)
	{
		kilometrosRecorridos += kilometrosViaje;
	}
	
	public void abastecerTanque(double galonesP)
	{
		galones += galonesP;
	}
	
	public double darKilometrosRecorridos() 
	{
		return kilometrosRecorridos;
	}
}

