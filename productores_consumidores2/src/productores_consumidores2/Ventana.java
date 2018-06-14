package productores_consumidores2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Window.Type;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	protected Pila contenedor;
	protected Thread[] consumidores = new Thread[3];
	private static Thread [] productor = new Thread[3];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setType(Type.UTILITY);
		setTitle("Productores y Consumidores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		JScrollPane textArea_j = new JScrollPane(textArea_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		textArea_j.setBounds(17, 290, 226, 203);
		contentPane.add(textArea_j);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(253, 311, 312, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		contenedor = new Pila(textField_1);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productor[1] = new Thread(new Productor(contenedor, 1, textArea_1));
	        	productor[1].start();
			}
		});
		btnIniciar.setBounds(10, 137, 89, 23);
		contentPane.add(btnIniciar);
		
		JButton btnParar = new JButton("Parar");
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productor[1].stop();
			}
		});
		btnParar.setBounds(109, 137, 89, 23);
		contentPane.add(btnParar);
		
		JButton button = new JButton("Iniciar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productor[2] = new Thread(new Productor(contenedor, 2, textArea_1));
	        	productor[2].start();
			}
		});
		button.setBounds(10, 229, 89, 23);
		contentPane.add(button);
		
		JButton btnParar_1 = new JButton("Parar");
		btnParar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productor[2].stop();
			}
		});
		btnParar_1.setBounds(109, 229, 89, 23);
		contentPane.add(btnParar_1);
		
		JButton btnParar_2 = new JButton("Parar");
		btnParar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consumidores[1].stop();
			}
		});
		btnParar_2.setBounds(476, 137, 89, 23);
		contentPane.add(btnParar_2);
		
		JButton button_2 = new JButton("Iniciar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					consumidores[1] = new Thread(new Consumidor(contenedor, 1, textArea_1));
		           consumidores[1].start();
			}
		});
		button_2.setBounds(377, 137, 89, 23);
		contentPane.add(button_2);
		
		JButton button_1 = new JButton("Iniciar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consumidores[2] = new Thread(new Consumidor(contenedor, 2, textArea_1));
		           consumidores[2].start();
			}
		});
		button_1.setBounds(377, 229, 89, 23);
		contentPane.add(button_1);
		
		JButton btnParar_3 = new JButton("Parar");
		btnParar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consumidores[2].stop();
			}
		});
		btnParar_3.setBounds(476, 229, 89, 23);
		contentPane.add(btnParar_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 555, 20);
		contentPane.add(separator);
		
		
		JLabel lblMovimientoDeLetras = new JLabel("Movimiento de Letras");
		lblMovimientoDeLetras.setBounds(20, 271, 152, 14);
		contentPane.add(lblMovimientoDeLetras);
		
		JLabel lblBuffer = new JLabel("Buffer");
		lblBuffer.setBounds(253, 286, 58, 20);
		contentPane.add(lblBuffer);
		
		JLabel lblProductor = new JLabel("Productor 1");
		lblProductor.setBounds(17, 103, 68, 14);
		contentPane.add(lblProductor);
		
		JLabel lblProductor_1 = new JLabel("Productor 2");
		lblProductor_1.setBounds(17, 204, 68, 14);
		contentPane.add(lblProductor_1);
		
		JLabel lblConsumidor = new JLabel("Consumidor 1");
		lblConsumidor.setBounds(377, 103, 68, 14);
		contentPane.add(lblConsumidor);
		
		JLabel lblConsumidor_1 = new JLabel("Consumidor 2");
		lblConsumidor_1.setBounds(377, 204, 68, 14);
		contentPane.add(lblConsumidor_1);
		
		JLabel lblFernandoReinosoRevilla = new JLabel("Fernando Reinoso Revilla     5to Semestre");
		lblFernandoReinosoRevilla.setBounds(253, 388, 312, 14);
		contentPane.add(lblFernandoReinosoRevilla);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero limite de datos en el Buffer:");
		lblIngreseElNumero.setBounds(17, 19, 312, 23);
		contentPane.add(lblIngreseElNumero);
	}
}
