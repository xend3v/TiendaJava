package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import SQLite.GestorBBDD;
import model.ModeloRelleno;
import model.Producto;
import model.Compras;

public class HistorialUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private GestorBBDD gbd;
	private static final int VALOR = 99;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public HistorialUI(GestorBBDD gbd) {
		this.gbd = gbd;
		setTitle("Historial de Compras");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 472, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 436, 206);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "IdCompra", "Cantidad", "Precio Total", "Fecha de Compra" }));
		//mostrar historial compras
		tablaFilas(table);
		scrollPane.setViewportView(table);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(165, 228, 89, 23);
		contentPane.add(btnVolver);
	}

	private void tablaFilas(JTable tabla)
	{
		ArrayList<Compras> listado = gbd.listadoHistorial();
	// se crea un modelo para la tabla, el nombre de la variable de la tabla es: tabla
	DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
	//para agregar valores en la fila
		for(Compras cursor_compra: listado){ 
			Object[] datos_compra = new Object[]{cursor_compra.getIdCompra(), 
					cursor_compra.getPrecioTotal(), 
					ModeloRelleno.deFechaAString(cursor_compra.getFechaCompra())};
			modelo.addRow(datos_compra);
		}
		table.setModel(modelo);
	}

}
