package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SQLite.GestorBBDD;
import model.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearProductoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textStock;
	private JTextField textFechaCad;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private GestorBBDD gbd;
	/**
	 * Create the frame.
	 * @param gbd 
	 */
	public CrearProductoUI(GestorBBDD gbd) {
		this.gbd = gbd;
		setTitle("A\u00D1ADIR PRODUCTO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 347, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreDelProducto = new JLabel("Nombre del producto:");
		lblNombreDelProducto.setBounds(20, 30, 130, 14);
		contentPane.add(lblNombreDelProducto);

		textNombre = new JTextField();
		textNombre.setBounds(160, 27, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(20, 74, 130, 14);
		contentPane.add(lblPrecio);

		JLabel lblCantidadEnStock = new JLabel("Cantidad en stock:");
		lblCantidadEnStock.setBounds(20, 118, 130, 14);
		contentPane.add(lblCantidadEnStock);

		JLabel lblFechaDeCaducidad = new JLabel("Fecha de caducidad: ");
		lblFechaDeCaducidad.setBounds(20, 162, 130, 14);
		contentPane.add(lblFechaDeCaducidad);

		textPrecio = new JTextField();
		textPrecio.setBounds(160, 71, 86, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);

		textStock = new JTextField();
		textStock.setBounds(160, 115, 86, 20);
		contentPane.add(textStock);
		textStock.setColumns(10);

		textFechaCad = new JTextField();
		textFechaCad.setBounds(160, 159, 86, 20);
		contentPane.add(textFechaCad);
		textFechaCad.setColumns(10);

		JButton btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addProducto();
			}
		});
		btnAdd.setBounds(30, 206, 89, 23);
		contentPane.add(btnAdd);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(160, 206, 89, 23);
		contentPane.add(btnAtras);
	}

	public void addProducto() {
		String nombre = textNombre.getText();
		Float precio = Float.valueOf(textPrecio.getText());
		Date fechaCad= null;
		try {
			fechaCad = sdf.parse(textFechaCad.getText());
		} catch (ParseException e) {
			System.out.println("Parse exception de date: " + e);
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		Integer stock = Integer.parseInt(textStock.getText());
		Producto addProducto= new Producto(nombre, precio, fechaCad, stock);
		gbd.crear(addProducto);
		JOptionPane.showMessageDialog(this,"Se ha añadido un nuevo producto.");
		dispose();
	}
}
