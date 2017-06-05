package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import manager.GestorEntrada;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class EntradaUI extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxUsuario;
	private GestorEntrada gp=new GestorEntrada();
	private JPasswordField textPassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntradaUI frame = new EntradaUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EntradaUI() {
		setTitle("Identificacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 26, 54, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 78, 69, 14);
		contentPane.add(lblPassword);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(124, 75, 120, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		comboBoxUsuario = new JComboBox();
    	comboBoxUsuario.setBounds(124, 23, 120, 20);
		contentPane.add(comboBoxUsuario);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnClickAceptar();
			}
		});
		btnAceptar.setBounds(10, 153, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickCancelar();
			}
		});
		btnCancelar.setBounds(207, 153, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaUsuarios();
			}
		});
		btnUsuarios.setBounds(108, 153, 89, 23);
		contentPane.add(btnUsuarios);
	
		//actualizar usuarios
		actualizarComboBox();	
	}
	
	// muestra los usuarios
		private void actualizarComboBox() {
			comboBoxUsuario.setModel(gp.getUsuarios());
		}
		
		private void btnClickAceptar(){
			String valorPass = new String(textPassword.getPassword());
			if (comboBoxUsuario.getSelectedIndex()>0 && !valorPass.equals("")){
				//Del usuario solo selecciona el codigo
					String codigo=((Usuario)comboBoxUsuario.getSelectedItem()).getCod();
					//valor inicial del contador de visitas
					Usuario user=new Usuario(codigo,valorPass,0);
					//comprobar si el usuario existe
					if(gp.CompruebaUsuario(user)){
						//machacamos el usuario anterior para actualizar el contador de visitas
						user=(Usuario)comboBoxUsuario.getSelectedItem();
						//contador de visitas
						gp.incVisitas(user);
						BienvenidoUI frmWelcome = new BienvenidoUI(user);
						frmWelcome.setVisible(true);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Este usuario no existe...");
						return;
					}
				}else{
					JOptionPane.showMessageDialog(null,"Debes introducir todo tus datos...");
				}		
		}
		
		//llamar a la ventana usuarios
		public void ventanaUsuarios(){
			UsuariosUI frmUsuarios=new UsuariosUI(gp);
			frmUsuarios.setVisible(true);
		}
		
		private void btnClickCancelar(){
			String[] opciones = { "Si", "No" };
			int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Estas seguro de cancelar?",
					"Mensaje de Confirmacion", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
					opciones, 0);
			
			if (eleccion == 0) {
				System.exit(0);	
			}
		}
}
