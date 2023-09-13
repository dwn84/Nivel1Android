package manejoClases;
import javax.swing.JOptionPane;

public class menuppal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double resultado;
		CuentaBancaria edd = new CuentaBancaria();
		CuentaBancaria maria = new CuentaBancaria("maria fernanda ochoa","3012115588","Cra 1#1-1");
		CuentaBancaria elisa= new CuentaBancaria();
		CuentaBancaria edgar = new CuentaBancaria("edgar alonso mendez","3012115589","Cra 1#1-2",200000);
		edd.setNombreCliente("Edwin Ferney Barragan Muñoz");
		String mensaje = edd.retirar(1000000);
		System.out.println(mensaje);			
		edd.consignar(22000);
		System.out.println(edd.getSaldo());		
		System.out.println(edd.getDatosCliente());
		System.out.println(edd.getFechaCreacion());
		System.out.println();	
		
	}

}
