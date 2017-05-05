package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoUI frame = new ListadoUI();
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
	public ListadoUI() {
		setTitle("LISTADO DE  PRODUCTOS");
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

		JList list = new JList();
		list.setBounds(10, 11, 201, 213);
		contentPane.add(list);

		textField_1 = new JTextField();
		textField_1.setBounds(338, 11, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(338, 42, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(338, 73, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(338, 104, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

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

		JButton btnModificar = new JButton("Modificar");
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
		btnEliminar.setBounds(221, 179, 107, 23);
		contentPane.add(btnEliminar);
	}
}
