package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class TiendaUI extends JFrame {

	private JPanel contentPane;
	private CrearProductoUI cp = new CrearProductoUI();
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				preguntarSalir();
			}
		});
		setTitle("TuTienda V.0.0.1");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 250, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCrear();
			}
		});
		btnCrear.setBounds(45, 11, 150, 23);
		contentPane.add(btnCrear);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnListado();
			}
		});
		btnListado.setBounds(45, 45, 150, 23);
		contentPane.add(btnListado);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnComprar();
			}
		});
		btnComprar.setBounds(45, 79, 150, 23);
		contentPane.add(btnComprar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preguntarSalir();
			}
		});
		btnSalir.setBounds(45, 147, 150, 23);
		contentPane.add(btnSalir);
		
		JButton btnHistorial = new JButton("Historial Compras");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnHistorial();
			}
		});
		btnHistorial.setBounds(45, 113, 150, 23);
		contentPane.add(btnHistorial);
		
	}
	
	private void btnCrear() {
		CrearProductoUI frmCrear = new CrearProductoUI();
		frmCrear.setVisible(true);
	}
	
	private void btnListado() {
		ListadoUI frmListado = new ListadoUI();
		frmListado.setVisible(true);
	}
	
	private void btnComprar(){
		CompraUI frmComprar = new CompraUI();
		frmComprar.setVisible(true);
	}
	
	private void btnHistorial(){
		HistorialUI frmHistorial = new HistorialUI();
		frmHistorial.setVisible(true);
	}
	
	public void preguntarSalir(){
		int salir = JOptionPane.showOptionDialog(null, "Deseea salir del programa", "Cerrar sesion",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null, null, null);
	      if (salir==JOptionPane.YES_OPTION){
	    	  System.exit(0);
	      }
	}
}
