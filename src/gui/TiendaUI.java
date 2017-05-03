package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SQLite.GestorBBDD;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TiendaUI extends JFrame {

	private JPanel contentPane;
	private GestorBBDD gbd = new GestorBBDD();
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 190, 295);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				preguntarSalir();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(40, 31, 89, 23);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCrear();
			}
		});
		contentPane.add(btnCrear);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(40, 99, 89, 23);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnComprar();
			}
		});
		contentPane.add(btnComprar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(40, 199, 89, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preguntarSalir();
			}
		});
		contentPane.add(btnSalir);

		JButton btnListado = new JButton("Listado");
		btnListado.setBounds(40, 65, 89, 23);
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnListado();
			}
		});
		contentPane.add(btnListado);
		
	}

	private void btnCrear() {
		CrearProductoUI frmCrear = new CrearProductoUI(gbd);
		frmCrear.setVisible(true);
	}

	private void btnListado() {
		ListadoUI frmListado = new ListadoUI(gbd);
		frmListado.setVisible(true);
	}

	private void btnComprar() {
		CompraUI frmComprar = new CompraUI(gbd);
		frmComprar.setVisible(true);
	}

	public void preguntarSalir() {
		int salir = JOptionPane.showOptionDialog(null, "Deseea salir del programa", "Cerrar sesion",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		if (salir == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
