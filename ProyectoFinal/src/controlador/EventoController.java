package controlador;
import java.sql.Connection;

import controlador.conexionDB;
import modelo.Evento;

public class EventoController {
	
	public void guardarEvento(String nombre, String tipoEvento, String fecha, String horaInicio,
			String horaFinal, String lugar, String boleteria, String estado) {
		
		conexionDB baseDatos = new conexionDB();
		Connection conexionactiva = baseDatos.abrirBaseDatos();
		
		if(baseDatos!=null) {
			Evento miEvento = new Evento(nombre,tipoEvento,fecha,horaInicio,
					 horaFinal,  lugar,  boleteria,  estado);
			miEvento.agregarEvento(conexionactiva);
			
		}
		
	}

}
