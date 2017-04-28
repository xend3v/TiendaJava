package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TiendaUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TiendaUI frame = new TiendaUI();
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
	public TiendaUI() {
		setTitle("TIENDA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 186, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(35, 34, 89, 23);
		contentPane.add(btnCrear);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(35, 102, 89, 23);
		contentPane.add(btnComprar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(35, 205, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnListado = new JButton("Listado");
		btnListado.setBounds(35, 68, 89, 23);
		contentPane.add(btnListado);
	}
}
