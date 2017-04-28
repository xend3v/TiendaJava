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
		btnCrear.setBounds(35, 38, 89, 23);
		contentPane.add(btnCrear);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(35, 72, 89, 23);
		contentPane.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(35, 106, 89, 23);
		contentPane.add(btnEliminar);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(35, 138, 89, 23);
		contentPane.add(btnComprar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(35, 228, 89, 23);
		contentPane.add(btnSalir);
	}
}
