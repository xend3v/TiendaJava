package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import manager.GestorEntrada;
import model.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BienvenidoUI extends JFrame {

	private JPanel contentPane;
	private Usuario u;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public BienvenidoUI(Usuario u ){
		setTitle("Welcome");
		//actualizamos el usuario pasado por parametro
			this.u=u;
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalir();
			}
		});
		btnSalir.setBounds(60, 186, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel labelUsuario = new JLabel("Bienvenido "+u.getCod());
		labelUsuario.setBounds(52, 24, 110, 69);
		contentPane.add(labelUsuario);
		
		JLabel labelVisitas = new JLabel("Nos has visitado "+u.getContVisitas());
		labelVisitas.setBounds(41, 104, 122, 65);
		contentPane.add(labelVisitas);
	}
	
	private void btnSalir(){
		String[] opciones = { "Si", "No" };
		int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Estas seguro de salir",
				"Mensaje de Confirmacion", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				opciones, 0);
		
		if (eleccion == 0) {
			System.exit(0);	
		}
	}
}
