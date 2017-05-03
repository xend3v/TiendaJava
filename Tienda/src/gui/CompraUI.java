package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompraUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraUI frame = new CompraUI();
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
	public CompraUI() {
		setTitle("COMPRAR");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 486, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(297, 54, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(299, 25, 71, 14);
		contentPane.add(lblProducto);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(297, 85, 46, 14);
		contentPane.add(lblPrecio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(297, 110, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(297, 141, 71, 14);
		contentPane.add(lblCantidad);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(371, 290, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setBounds(272, 215, 71, 23);
		contentPane.add(btnNewButton);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(297, 166, 86, 20);
		contentPane.add(spinner);
		
		JList list = new JList();
		list.setBounds(33, 24, 222, 137);
		contentPane.add(list);
		
		textField_2 = new JTextField();
		textField_2.setBounds(33, 215, 222, 79);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCarrito = new JLabel("Carrito:");
		lblCarrito.setBounds(33, 190, 46, 14);
		contentPane.add(lblCarrito);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(272, 243, 86, 23);
		contentPane.add(btnComprar);
	}
}
