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
	private JTextField textField;
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
		setTitle("MODIFICAR PRODUCTO");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setBounds(10, 11, 201, 213);
		contentPane.add(list);

		textField = new JTextField();
		textField.setBounds(338, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(338, 58, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(338, 97, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(338, 136, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(338, 175, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblIdProducto = new JLabel("ID Producto:");
		lblIdProducto.setBounds(242, 24, 86, 14);
		contentPane.add(lblIdProducto);

		JLabel lblNombreProd = new JLabel("Nombre:");
		lblNombreProd.setBounds(242, 62, 86, 14);
		contentPane.add(lblNombreProd);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(242, 100, 86, 14);
		contentPane.add(lblStock);

		JLabel lblPrecioUnid = new JLabel("Precio Unid:");
		lblPrecioUnid.setBounds(242, 138, 86, 14);
		contentPane.add(lblPrecioUnid);

		JLabel lblFechaCaducidad = new JLabel("Fecha Caducidad");
		lblFechaCaducidad.setBounds(242, 176, 86, 14);
		contentPane.add(lblFechaCaducidad);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(239, 214, 86, 23);
		contentPane.add(btnModificar);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAtrs.setBounds(335, 214, 89, 23);
		contentPane.add(btnAtrs);
	}
}
