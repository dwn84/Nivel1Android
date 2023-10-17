import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tabla extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValorPrestamo;
	private JTextField txtMeses;

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
				char c = e.getKeyChar();				
		        if (Character.isDigit(c)) {
		        	String valorAnterior = txtValorPrestamo.getText();
		        	String valorNuevo = valorAnterior + c;
		        	double prestamo = Double.parseDouble(valorNuevo);
		        	if(prestamo<1000000) {
		        		lblAdvertenciaValor.setText("El mínimo es 1000000");
		        		lblAdvertenciaValor.setForeground(Color.RED);
		        	}else if(prestamo>500000000) {
		        		lblAdvertenciaValor.setText("El máximo es 500000000");
		        		lblAdvertenciaValor.setForeground(Color.RED);
		        	}else {
		        		lblAdvertenciaValor.setText("Monto Minimo:1.000.000- Monto Maximo:500.000.000 ");
		        		lblAdvertenciaValor.setForeground(Color.BLACK);
		        	}		        	
		        	//JOptionPane.showMessageDialog(null, "Se ha presionado un numero");    
		        }else{
		        	e.consume();//Cancela el evento de recibir un dato
		        	//JOptionPane.showMessageDialog(null, "Se ha ingresado una letra");
		        }
		        	
			}
		});

		txtValorPrestamo.setBounds(164, 81, 86, 20);
		contentPane.add(txtValorPrestamo);
		txtValorPrestamo.setColumns(10);
		
		txtMeses = new JTextField();
		txtMeses.setBounds(164, 170, 86, 20);
		contentPane.add(txtMeses);
		txtMeses.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("5%");
		lblNewLabel_2.setBounds(164, 236, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCalcular = new JButton("Calcular");		
		btnCalcular.setEnabled(false);
		btnCalcular.setBounds(338, 80, 162, 23);
		contentPane.add(btnCalcular);
		
		JLabel lblElijeUnPlazo = new JLabel("Elije un plazo desde 4 y hasta 12 meses ");
		lblElijeUnPlazo.setBounds(45, 211, 281, 14);
		contentPane.add(lblElijeUnPlazo);
		
		
	}
}
