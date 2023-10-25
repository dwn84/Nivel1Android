import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;



public class Tabla extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final double i = 0.05;
	private JPanel contentPane;
	private JTextField txtValorPrestamo;
	private JTextField txtMeses;	
	private JTable tblDatos;
	private boolean validarDinero;
	private boolean validarMeses;	
	private JButton btnCalcular;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla frame = new Tabla();					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tabla() {		
		
		validarDinero = false;
		validarMeses = false;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Simulador de préstamo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(36, 22, 331, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor del préstamo");
		lblNewLabel_1.setBounds(46, 84, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad de meses");
		lblNewLabel_1_1.setBounds(46, 173, 137, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Interes");
		lblNewLabel_1_1_1.setBounds(46, 236, 137, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblAdvertenciaValor = new JLabel("Monto Minimo:1.000.000- Monto Maximo:500.000.000");
		lblAdvertenciaValor.setBounds(45, 126, 281, 14);
		contentPane.add(lblAdvertenciaValor);
		
		txtValorPrestamo = new JTextField();
		txtValorPrestamo.addKeyListener(new KeyAdapter() {			
			@Override
			public void keyTyped(KeyEvent e) {				
				validarDinero = validarTextField(e, lblAdvertenciaValor, txtValorPrestamo,10000,500000000);
				cambiarEstadoBoton(validarDinero, validarMeses);
			}
			@Override
			public void keyPressed(KeyEvent e) {				
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					String valorAnterior = txtValorPrestamo.getText();					
					if (!valorAnterior.isEmpty()) {
		                String valorNuevo = valorAnterior.substring(0, valorAnterior.length() - 1);
		                if(!valorNuevo.isEmpty()) {
		                	validarDinero = validarValores(valorNuevo, lblAdvertenciaValor,txtValorPrestamo,10000,500000000);
		                	cambiarEstadoBoton(validarDinero, validarMeses);
		                }		                					
					}
				}
				
			}
		});

		txtValorPrestamo.setBounds(164, 81, 86, 20);
		contentPane.add(txtValorPrestamo);
		txtValorPrestamo.setColumns(10);
		
		JLabel lblElijeUnPlazo = new JLabel("Elije un plazo desde 4 y hasta 12 meses ");
		lblElijeUnPlazo.setBounds(45, 211, 281, 14);
		contentPane.add(lblElijeUnPlazo);
		
		txtMeses = new JTextField();
		txtMeses.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validarMeses = validarTextField(e, lblElijeUnPlazo, txtMeses,4,12);
				cambiarEstadoBoton(validarDinero, validarMeses);
			}
			//Se ha duplicado código, no es la solución mas eficiente pero funciona
			//se tiene deuda tecnica: https://asana.com/es/resources/technical-debt
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					String valorAnterior = txtMeses.getText();					
					if (!valorAnterior.isEmpty()) {
		                String valorNuevo = valorAnterior.substring(0, valorAnterior.length() - 1);
		                if(!valorNuevo.isEmpty()) {
		                	validarMeses = validarValores(valorNuevo, lblElijeUnPlazo, txtMeses,4,12);
		                	cambiarEstadoBoton(validarDinero, validarMeses);
		                }		                					
					}
				}
			}
		});
		txtMeses.setBounds(164, 170, 86, 20);
		contentPane.add(txtMeses);
		txtMeses.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("5%");
		lblNewLabel_2.setBounds(164, 236, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		btnCalcular = new JButton("Simular");		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calcular el valor de la mensualidad del préstamo
				//https://heroku-cforemoto-blog-strapi.s3.us-west-2.amazonaws.com/amortizacion_y_fondos_5_0216_423ebf0bdc.jpeg
				double A = Double.parseDouble(txtValorPrestamo.getText());
				int n = Integer.parseInt(txtMeses.getText());
				double cuota = (A*i)/(1-Math.pow((1+i),-n));

				//casting de datos
				DefaultTableModel modeloTablaDatos = (DefaultTableModel) tblDatos.getModel();
			}
		});
		btnCalcular.setEnabled(false);
		btnCalcular.setBounds(338, 80, 162, 23);
		contentPane.add(btnCalcular);
		
		// Crear el modelo de datos con las columnas
	/*
		DefaultTableModel  model = new DefaultTableModel();
		
        model.addColumn("Periodo");
        model.addColumn("Cuota");
        model.addColumn("Interes");
        model.addColumn("Amortizacion");
        model.addColumn("Saldo");
        
        Object[] fila = {1, 3333, 33333,333,33333};
        model.addRow(fila);   
*/
        
        
		tblDatos = new JTable();
		tblDatos.setModel(new javax.swing.table.DefaultTableModel(
									new String [][] {
										{"Periodo", 
											"Cuota", 
											"Interes", 
											"Amortizacion", 
											"Saldo"},										
									},				
									new String [] {
												"Periodo", 
												"Cuota", 
												"Interes", 
												"Amortizacion", 
												"Saldo",
												
												})
						);
		tblDatos.setBounds(36, 291, 384, 249);
		contentPane.add(tblDatos);
		
		
		
		
		
		
	}
	private boolean validarTextField(KeyEvent e, JLabel etiqueta, JTextField cuadroTexto, int min, int max) {
		boolean validacionTexto = true;
		char c = e.getKeyChar();				
        if (Character.isDigit(c)) {
        	
        	String valorAnterior = cuadroTexto.getText();
        	String valorNuevo = "";            
        	
            valorNuevo = valorAnterior + c;
        	 
            validacionTexto = validarValores(valorNuevo, etiqueta, cuadroTexto, min, max);
        			        	
        	//JOptionPane.showMessageDialog(null, "Se ha presionado un numero");    
        }else{
        	validacionTexto = false;
        	e.consume();//Cancela el evento de recibir un dato
        	//JOptionPane.showMessageDialog(null, "Se ha ingresado una letra");
        }
        return validacionTexto;
		
	}
	
	private void cambiarEstadoBoton(boolean validacionDinero, boolean validacionMeses) {
		boolean validacion = validacionDinero && validacionMeses;
		if(validacion) {
			btnCalcular.setEnabled(true);
		}else {
			btnCalcular.setEnabled(false);
		}
		
	}
	
	private boolean validarValores(String valorNuevo, JLabel etiqueta, JTextField cuadroTexto, int min, int max) {
		boolean validacion = true;
		double dato = Double.parseDouble(valorNuevo);
    	etiqueta.setForeground(Color.RED);
    	if(dato<min) {
    		etiqueta.setText("El mínimo es " + min);  
    		validacion = false;
    	}else if(dato>max) {
    		etiqueta.setText("El máximo es " + max);
    		validacion = false;
    	}else {
    		etiqueta.setText("Monto Minimo: " + min + " - Monto Maximo: " + max);
    		etiqueta.setForeground(Color.BLACK);
    	}
    	return validacion;
    	
	}
}
