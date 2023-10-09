package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ejercicios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtValorA;
	private JTextField txtValorB;
	private JTextField txtValorC;
	private JLabel lblTotal;
	private JLabel lblValorA;
	private JLabel lblValorB;
	private JLabel lblValorC;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicios frame = new ejercicios();
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
	public ejercicios() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 664);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Resolver una ecuación de segundo grado completa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 39, 329, 14);
		getContentPane().add(lblNewLabel);
		
		lblValorA = new JLabel("Valor a");
		lblValorA.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblValorA.setBounds(22, 83, 44, 14);
		getContentPane().add(lblValorA);
		
		txtValorA = new JTextField();
		txtValorA.setBounds(76, 81, 86, 20);
		getContentPane().add(txtValorA);
		txtValorA.setColumns(10);
		
		lblTotal = new JLabel("");
		lblValorB = new JLabel("Valor b");
		lblValorB.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblValorB.setBounds(22, 152, 44, 14);
		getContentPane().add(lblValorB);
		
		txtValorB = new JTextField();
		txtValorB.setColumns(10);
		txtValorB.setBounds(76, 150, 86, 20);
		getContentPane().add(txtValorB);
		
		lblValorC = new JLabel("Valor c");
		lblValorC.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblValorC.setBounds(22, 230, 44, 14);
		getContentPane().add(lblValorC);
		
		txtValorC = new JTextField();
		txtValorC.setColumns(10);
		txtValorC.setBounds(76, 228, 86, 20);
		getContentPane().add(txtValorC);

		lblTotal = new JLabel("Valor a");
		lblTotal.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblTotal.setBounds(10, 356, 296, 224);
		getContentPane().add(lblTotal);
		lblTotal.setVisible(false);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Double.parseDouble(txtValorA.getText());
				double b = Double.parseDouble(txtValorB.getText());
				double c = Double.parseDouble(txtValorC.getText());
				double D;
				double x1;
				double x2;
				
				D = (Math.pow(b, 2)) - (4 * a * c);
				
				if(a==0) {
					
					lblTotal.setText("No es posible realizar la operacion, el valor de A no puede ser cero");
				}
				else {
					if(D >= 0){
						
						x1 = (-b + Math.sqrt(D))/(2*a);
						//cambiar formato numérico
						//https://www.getdevkit.com/devgpt
				        String r1 = String.format("%.2f", x1);
						x2 = (-b - Math.sqrt(D))/(2*a);
						String r2 = String.format("%.2f", x2);
						
						String mensaje;
						//Se adiciona código HTML para formatear el texto: agregar salto de linea<br>
						//https://www.lawebdelprogramador.com/foros/Java/937289-Salto-de-linea-del-TextArea.html
						mensaje = "<html><body>la primera raiz es:" + r1;
						mensaje += "<br>la segunda raiz es:" + r2 + "</body></html>";

						lblTotal.setText(mensaje);
						
										
					}
					else{
						lblTotal.setText("No es posible calcular las raiz, se genera un numero imaginario");
					}	
				}	
				lblTotal.setVisible(true);
			}
		});
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnCalcular.setBounds(10, 291, 315, 23);
		getContentPane().add(btnCalcular);
		

	}
}
