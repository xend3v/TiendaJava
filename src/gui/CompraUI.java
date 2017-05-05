package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import SQLite.GestorBBDD;
import model.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class CompraUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private GestorBBDD gbd;
	private JTextField textField;
	private DefaultTableModel modelo;
	private JList list;

	public CompraUI(GestorBBDD gbd) {
		this.gbd = gbd;
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

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(338, 20, 86, 25);
		contentPane.add(lblCantidad);

		JButton btnSalir = new JButton("Atras");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(374, 271, 89, 23);
		contentPane.add(btnSalir);

		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCarrito();
			}
		});
		btnNewButton.setBounds(338, 109, 86, 23);
		contentPane.add(btnNewButton);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(338, 56, 86, 42);
		contentPane.add(spinner);

		JLabel lblCarrito = new JLabel("Carrito:");
		lblCarrito.setBounds(33, 190, 46, 14);
		contentPane.add(lblCarrito);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprarCarrito();
			}
		});
		btnComprar.setBounds(374, 224, 86, 36);
		contentPane.add(btnComprar);
	
		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 25, 222, 158);
		contentPane.add(scrollPane);
		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setBounds(265, 249, 86, 45);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(265, 224, 86, 14);
		contentPane.add(lblPrecioTotal);
		
		list = new JList();
		list.setBounds(33, 215, 222, 79);
		contentPane.add(list);
		
		listado();

	}

	public void listado() {
		for (Producto p : gbd.listarCompra()) {
			modelo.addRow(new Object[] { p.getNombrePro(), p.getPrecioUnidad()});
			System.out.println("has terminado");
		}
	}
	public void addCarrito(ArrayList<Producto> lstProductos){
		
		
		
		/*DefaultListModel<Producto> dlm = new DefaultListModel<Producto>();
		for (Producto p : lstProductos) {
			dlm.addElement(p);
		}
		list.setModel(dlm);
		*/
	}
	public void comprarCarrito(){
		
	}
}
