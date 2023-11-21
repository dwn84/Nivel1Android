package controlador;
import java.sql.Connection;

import controlador.conexionDB;
import modelo.Evento;

public class EventoController {
	
	public boolean guardarEvento(String nombre, String tipoEvento, String fecha, String horaInicio,
			String horaFinal, String lugar, String boleteria, String estado) {
		
		boolean respuestaControlador = true;
		
		conexionDB baseDatos = new conexionDB();
		Connection conexionactiva = baseDatos.abrirBaseDatos();
		
		if(conexionactiva!=null) {
			Evento miEvento = new Evento(nombre,tipoEvento,fecha,horaInicio,
					 horaFinal,  lugar,  boleteria,  estado);
			boolean respuestaModelo = miEvento.agregarEvento(conexionactiva);
			if (respuestaModelo==true) {
				return respuestaControlador;
			}else {
				respuestaControlador = false;
				return respuestaControlador;
			}
		}
		else {
			respuestaControlador = false;
			return respuestaControlador;			
		}
		
	}
	
	public void actualizarEvento() {}
	public void EliminarEvento() {}
	public void mostrarEventos() {}
	public void buscarEvento() {}
	

}
