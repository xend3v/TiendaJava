package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;

import SQLite.GestorBBDD;
import model.Producto;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

public class ListadoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textStock;
	private JTextField textPrecio;
	private JTextField textFechaCad;
	private GestorBBDD gbd;
	private JList list;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the frame.
	 */
	public ListadoUI(GestorBBDD gbd) {
		this.gbd = gbd;
		setTitle("MODIFICAR PRODUCTO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		list = new JList();
		list.setBounds(10, 11, 201, 213);
		contentPane.add(list);

		textNombre = new JTextField();
		textNombre.setBounds(338, 11, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textStock = new JTextField();
		textStock.setBounds(338, 42, 86, 20);
		contentPane.add(textStock);
		textStock.setColumns(10);

		textPrecio = new JTextField();
		textPrecio.setBounds(338, 73, 86, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);

		textFechaCad = new JTextField();
		textFechaCad.setBounds(338, 104, 86, 20);
		contentPane.add(textFechaCad);
		textFechaCad.setColumns(10);

		JLabel lblNombreProd = new JLabel("Nombre:");
		lblNombreProd.setBounds(221, 12, 107, 14);
		contentPane.add(lblNombreProd);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(221, 45, 107, 14);
		contentPane.add(lblStock);

		JLabel lblPrecioUnid = new JLabel("Precio Unidad:");
		lblPrecioUnid.setBounds(221, 76, 107, 14);
		contentPane.add(lblPrecioUnid);

		JLabel lblFechaCaducidad = new JLabel("Fecha Caducidad:");
		lblFechaCaducidad.setBounds(221, 107, 107, 14);
		contentPane.add(lblFechaCaducidad);

		// DESPUES DE INICIALIZAR TODOS LOS COMPONENTES, AQUÍ VAN LOS LISTENERS

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarProd();
			}
		});
		btnModificar.setBounds(221, 145, 107, 23);
		contentPane.add(btnModificar);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtrs.setBounds(335, 179, 89, 23);
		contentPane.add(btnAtrs);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProd();
			}
		});
		btnEliminar.setBounds(221, 179, 107, 23);
		contentPane.add(btnEliminar);
		listado(gbd.listarProductos());

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (list.getSelectedIndex() >= 0) {
						datosLista((Producto) list.getSelectedValue());
					}
				}
			}
		});
	}

	public void listado(ArrayList<Producto> lstProductos) {
		DefaultListModel<Producto> dlm = new DefaultListModel<Producto>();
		for (Producto p : lstProductos) {
			dlm.addElement(p);
		}
		list.setModel(dlm);
	}

	public void modificarProd() {
		
		
	}

	public void eliminarProd() {

	}

	public void datosLista(Producto p) {
		textNombre.setText(p.getNombrePro());
		textStock.setText(Integer.toString(p.getStock()));
		textPrecio.setText(Float.toString(p.getPrecioUnidad()));
		textFechaCad.setText(sdf.format(p.getFechaCaducidad()));

	}

}
