package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import manager.GestorBBDD;
import model.Compras;
import model.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class CompraUI extends JFrame {

	private JPanel contentPane;
	private GestorBBDD gbd;
	private JTextField textPrecioTotal;
	private DefaultTableModel modelo;
	private JList list;
	private JList listaCompra;
	private JSpinner spinner;

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

		JButton btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carrito();
				addCarrito();
			}
		});
		btnAdd.setBounds(338, 109, 86, 23);
		contentPane.add(btnAdd);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(338, 56, 86, 42);
		contentPane.add(spinner);

		JLabel lblCarrito = new JLabel("Carrito:");
		lblCarrito.setBounds(33, 190, 46, 14);
		contentPane.add(lblCarrito);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// comprarCarrito();
			}
		});
		btnComprar.setBounds(374, 224, 86, 36);
		contentPane.add(btnComprar);

		textPrecioTotal = new JTextField();
		textPrecioTotal.setEditable(false);
		textPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textPrecioTotal.setBounds(265, 249, 86, 45);
		contentPane.add(textPrecioTotal);
		textPrecioTotal.setColumns(10);

		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(265, 224, 86, 14);
		contentPane.add(lblPrecioTotal);

		list = new JList();
		list.setBounds(33, 215, 222, 79);
		contentPane.add(list);

		listaCompra = new JList();
		listaCompra.setBounds(32, 24, 223, 140);
		contentPane.add(listaCompra);

		listado(gbd.listarCompra());
		listaCompra.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (list.getSelectedIndex() >= 0) {
						//datosLista((Producto) list.getSelectedValue());
						//Coger datos del seleccionado en la lista de la compra
						datosCompra();//Sin hacer
					}
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	public void listado(ArrayList<Compras> lstCompras) {
		DefaultListModel<Compras> dlm = new DefaultListModel<Compras>();
		for (Compras c : lstCompras) {
			dlm.addElement(c);
		}
		listaCompra.setModel(dlm);
	}
	//Del Jlist del listado de compra al Jlist del carrito y un return para enviar los datos al GestorBBDD
	private ArrayList<Compras> addCarrito() {
		ArrayList<Compras> ProductosComprados = new ArrayList<Compras>();
		
		
		return ProductosComprados;
	
	//Preparar el carrito para añadir al gestor de BBDD
	}
	public void carrito() {
		// pedir los productos al gestor
		// addCarrito(gbd.listarProductos());
	}
	// llamar al metodo comprar para insertar en la bbdd de compras
	public void comprarCarrito(double suma) {
		gbd.crearCompra(suma);//Sin terminar
		gbd.crearCarrito();//Sin terminar
		JOptionPane.showMessageDialog(this, "Haz realizado una compra.");
		dispose();
	}
	private void datosCompra() {
		
		
	}
}
