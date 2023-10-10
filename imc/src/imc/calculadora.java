package imc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPulgadas;
	private JTextField txtCentimetros;
	private JTextField txtLibras;
	private JTextField txtKilogramos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora frame = new calculadora();
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
	public calculadora() {
		setTitle("Calculadora IMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Para calcular su índice de masa corporal,<br>ingrese su estatura y peso.</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(45, 11, 300, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema inglés");
		lblNewLabel_1.setBounds(32, 86, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sistema métrico");
		lblNewLabel_1_1.setBounds(222, 86, 123, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estatura");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(34, 133, 65, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Estatura");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(222, 133, 65, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("en pulgadas:");
		lblNewLabel_3.setBounds(32, 182, 106, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("en centímetros:");
		lblNewLabel_3_1.setBounds(222, 182, 106, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txtPulgadas = new JTextField();
		txtPulgadas.setBounds(30, 221, 86, 20);
		contentPane.add(txtPulgadas);
		txtPulgadas.setColumns(10);
		
		txtCentimetros = new JTextField();
		txtCentimetros.setColumns(10);
		txtCentimetros.setBounds(222, 221, 86, 20);
		contentPane.add(txtCentimetros);
		
		JLabel lblNewLabel_2_2 = new JLabel("Peso");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_2.setBounds(32, 287, 65, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Peso");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_2_1.setBounds(222, 287, 65, 14);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("en libras:");
		lblNewLabel_3_2.setBounds(30, 327, 106, 14);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("en kilogramos:");
		lblNewLabel_3_2_1.setBounds(222, 327, 106, 14);
		contentPane.add(lblNewLabel_3_2_1);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(110, 503, 106, 14);
		contentPane.add(lblResultado);
		
		txtLibras = new JTextField();
		txtLibras.setColumns(10);
		txtLibras.setBounds(32, 352, 86, 20);
		contentPane.add(txtLibras);
		
		txtKilogramos = new JTextField();
		txtKilogramos.setColumns(10);
		txtKilogramos.setBounds(224, 352, 86, 20);
		contentPane.add(txtKilogramos);		
		
		JButton btnSistemaIngles = new JButton("Calcular");
		btnSistemaIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
										
				
				double pulgadas = Double.parseDouble(txtPulgadas.getText()) ;
				double libras = Double.parseDouble(txtLibras.getText());
				
				double[] valoresConvertidos = convertirDatos(pulgadas,libras);
				
				double resultado = calcularImc(valoresConvertidos[1],valoresConvertidos[0]);
				lblResultado.setText(String.valueOf(resultado));
			}
		});
		btnSistemaIngles.setBounds(30, 434, 89, 23);
		contentPane.add(btnSistemaIngles);
		
		JButton btnSistemaMetrico = new JButton("Calcular");
		btnSistemaMetrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double metros= (Double.parseDouble(txtCentimetros.getText()))/100 ;
				double kilogramos = Double.parseDouble(txtKilogramos.getText());
								
				double resultado = calcularImc(kilogramos,metros);
				lblResultado.setText(String.valueOf(resultado));
			}
		});
		btnSistemaMetrico.setBounds(214, 434, 89, 23);
		contentPane.add(btnSistemaMetrico);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("en resultado:");
		lblNewLabel_3_2_2.setBounds(35, 503, 65, 14);
		contentPane.add(lblNewLabel_3_2_2);				
		
	}
	
	private double[] convertirDatos(double pulgadas, double libras) {
		double[] datosConvertidos = new double[2];
		datosConvertidos[0] = pulgadas * 2.54;
		datosConvertidos[1] = libras * 0.453592;
		return 	datosConvertidos;
	}
	
	private double calcularImc(double peso, double estatura) {
		
		return peso/(estatura*estatura);
		
	}
}
