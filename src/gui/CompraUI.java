package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
	private JTable tProductos;
	private JSpinner spinner;
	private GestorBBDD gbd;
	private JTextField textPrecioTotal;
	private DefaultTableModel modelo;
	private DefaultTableModel modelo2;
	private ArrayList<Producto> lstProductos = new ArrayList<Producto>();
	private JTable tCarrito;

	public CompraUI(GestorBBDD gbd) {
		this.gbd = gbd;
		setTitle("COMPRAR");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 551, 419);
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
		btnSalir.setBounds(436, 335, 89, 23);
		contentPane.add(btnSalir);

		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carrito();
				setPrecioTotal();
				spinner.setValue(1);
			}
		});
		btnNewButton.setBounds(338, 109, 86, 23);
		contentPane.add(btnNewButton);

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
				comprar();
				//restarProductos(p);
				//comprarCarrito();
				
			}
		});
		btnComprar.setBounds(415, 257, 86, 36);
		contentPane.add(btnComprar);

		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 25, 254, 158);
		contentPane.add(scrollPane);
		tProductos = new JTable(modelo);
		scrollPane.setViewportView(tProductos);

		// table.getValueAt(número de fila,número de columna);

		textPrecioTotal = new JTextField();
		textPrecioTotal.setEditable(false);
		textPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textPrecioTotal.setBounds(319, 249, 86, 45);
		contentPane.add(textPrecioTotal);
		textPrecioTotal.setColumns(10);

		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(319, 224, 86, 14);
		contentPane.add(lblPrecioTotal);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 215, 254, 143);
		contentPane.add(scrollPane_1);

		tCarrito = new JTable(modelo2);
		scrollPane_1.setViewportView(tCarrito);
		tCarrito.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Precio", "Cantidad" }));
		// listado de productos
		listado();
		// pedir las plantaciones al gestor plantaciones
		// listado(gp.getPlantaciones());

	}

	public void listado() {
		for (Producto p : gbd.listarProductos()) {
			modelo.addRow(new Object[] { p.getNombrePro(), p.getPrecioUnidad() });
			// System.out.println("has terminado");
		}
	}

	// mostrar producto seleccionados
	public void carrito(Compras c, Producto p) {
		// obtener producto seleccinado del Jtable
		DefaultTableModel tm = (DefaultTableModel) tProductos.getModel();

		String nombre = (String) (tm.getValueAt(tProductos.getSelectedRow(), 0));
		float precio = (Float) tm.getValueAt(tProductos.getSelectedRow(), 1);
		int cantidadUnidad = (Integer) spinner.getModel().getValue();

		Object[] data = new Object[] { nombre, precio, cantidadUnidad };
		modelo2 = (DefaultTableModel) tCarrito.getModel();
		// comprobar si el producto existe en el carrito
		boolean enc = false;
		for (int i = 0; i < modelo2.getRowCount(); i++) {
			if (modelo2.getValueAt(i, 0).equals(nombre)) {
				// existe el producto en el carrito
				enc = true;
				int cantAnterior = (Integer) modelo2.getValueAt(i, 2);
				int cantTotal = cantAnterior + cantidadUnidad;
				modelo2.setValueAt(cantTotal, i, 2);
				break;
			}
		}
		// comprobar si el producto no está en el carrito
		if (enc == false) {
			modelo2.addRow(data);
		}
		
		
		
	}

	public void setPrecioTotal() {
		int filas = modelo2.getRowCount();
		filas -= 1;
		double precioTotal = 0;
		for (int i = 0; i <= (filas); i++) {
			double precioProductoTotal = Double.parseDouble(modelo2.getValueAt(i, 1).toString())
					* Double.parseDouble(modelo2.getValueAt(i, 2).toString());
			precioTotal = precioProductoTotal + precioTotal;
		}
		
		textPrecioTotal.setText(String.format("%.2f", precioTotal) + "€");
	}

	public void compras(Compras c, Producto p) {
		/*
		 * DefaultListModel<Producto> dlm = new DefaultListModel<Producto>();
		 * for (Producto p : lstProductos){ dlm.addElement(p); }
		 * list.setModel(dlm);
		*/
		
		int idCompra = c.getIdCompra();
		float precioTotal = Float.parseFloat((textPrecioTotal.getText()));
		Date fechaCompra = c.getFechaCompra();
		//Clase Compras		
		String nombreProducto = p.getNombrePro();
		float precioUnidad = c.getPrecioUnidad();
		int cantidadComprada = c.getCantidadUnidad();
		
		
		// Clase Producto
		int idProducto = p.getIdProducto();
		String nombrePro = p.getNombrePro();
		float precioProducto = p.getPrecioUnidad();
		Date fechaCaducidad = p.getFechaCaducidad();
		int stock = p.getStock();
		
		
	}

	public void comprar() {
		String txtPrecio=textPrecioTotal.getText();
		//quitar el €
		txtPrecio=txtPrecio.substring(0, txtPrecio.length()-1);
		//cambiar las comas por puntos
		txtPrecio=txtPrecio.replaceAll(",", ".");
		Float suma = Float.parseFloat(txtPrecio);
		//redondear a dos decimales
		DecimalFormat f = new DecimalFormat("##.00");
		txtPrecio=f.format(suma);
		txtPrecio=txtPrecio.replaceAll(",", ".");

		gbd.crearCompra(Float.parseFloat(txtPrecio));
	}
	public void detalles(Producto p, Compras c) throws SQLException{
		String fecha = "empty";
		fecha = gbd.fechaProducto(fecha);
		for (Producto pr : lstProductos){
			int id = pr.getIdProducto();
			String nombreP = pr.getNombrePro();
			float precio = pr.getPrecioUnidad();
			int cantPr = c.getCantidadUnidad();
			gbd.crearCarrito(fecha, id, nombreP, precio, cantPr);
		}
	}
	public void restarProductos(Producto p) {
		DefaultTableModel tm = (DefaultTableModel) tProductos.getModel();
		String nombre = (String) (tm.getValueAt(tProductos.getSelectedRow(), 0));
		for (int i = 0; i < modelo2.getRowCount(); i++) {
			if (modelo2.getValueAt(i, 0).equals(nombre)) {
				int idProducto = p.getIdProducto();
				Object cantidadComprada = modelo2.getValueAt(i, 2);
				gbd.restarCantidad((int) cantidadComprada, idProducto);
			}
		}
	}
}
