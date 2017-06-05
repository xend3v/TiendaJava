package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import manager.GestorEntrada;
import model.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class UsuariosUI extends JFrame {

	private JPanel contentPane;
	private JTable tableUsuarios;
	private JTextField textUsuario;
	private JTextField textVisitas;
	private JPasswordField textPassword;
	private GestorEntrada gp;

	public UsuariosUI(GestorEntrada gp) {
		this.gp=gp;
		
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNuevoUsuario();
			}
		});
		btnNuevo.setBounds(21, 228, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				btnGuardarUsuario();
				}catch(NumberFormatException error2){
					 JOptionPane.showMessageDialog(null, "Debes completar todo el formulario correctamente!!");
				}
			}
		});
		btnGuardar.setBounds(171, 228, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					btnEliminarUsuario();
				}catch(NumberFormatException error){
					 JOptionPane.showMessageDialog(null, "Selecciona un usuario para eliminar");
				}
			}
		});
		btnEliminar.setBounds(320, 228, 89, 23);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 195, 174);
		contentPane.add(scrollPane);
		
		tableUsuarios = new JTable();
		tableUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccionarDatos();
			}
		});
		tableUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Password", "Visitas"
			}
		));
		//mostrar usuarios
		tablaFilas(tableUsuarios);
		scrollPane.setViewportView(tableUsuarios);
		
		JLabel lblCodigo = new JLabel("Usuario:");
		lblCodigo.setBounds(228, 24, 64, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(228, 77, 64, 14);
		contentPane.add(lblPassword);
		
		JLabel lblVisitas = new JLabel("Visitas:");
		lblVisitas.setBounds(228, 130, 46, 14);
		contentPane.add(lblVisitas);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(323, 21, 86, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textVisitas = new JTextField();
		textVisitas.setEditable(false);
		textVisitas.setBounds(323, 127, 86, 20);
		contentPane.add(textVisitas);
		textVisitas.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(324, 74, 85, 20);
		contentPane.add(textPassword);
	}
	
	
	private void tablaFilas(JTable tabla){
		ArrayList<Usuario> listado = gp.listaUsuarios();
		//se crea un modelo para la tabla, el nombre de la variable de la tabla es: tabla
		DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
		//para agregar valores en la fila
		for(Usuario cursor_user:listado){ 
			Object[] datos_user = new Object[]{cursor_user.getCod(),cursor_user.getPassword(),cursor_user.getContVisitas()};
			modelo.addRow(datos_user);
		}
		tableUsuarios.setModel(modelo);
	}
	
	private void seleccionarDatos(){
		// obtener producto seleccinado del Jtable	
		int filaseleccionada;
		 try{
				     
			 filaseleccionada= tableUsuarios.getSelectedRow();
				         
			 if (filaseleccionada==-1){
				         
				 JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

			 }else{

				  DefaultTableModel modelotabla=(DefaultTableModel) tableUsuarios.getModel();
				           
				  String codigo=(String)modelotabla.getValueAt(filaseleccionada, 0);
				  String password=(String)modelotabla.getValueAt(filaseleccionada, 1);
				  int visitas=(Integer) modelotabla.getValueAt(filaseleccionada, 2);
				  
				  
				  textUsuario.setText(codigo);
				  textVisitas.setText(Integer.toString(visitas));
				  textPassword.setText(password);
				  }

			}catch (HeadlessException ex){

				    JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
			}     				       							
	}
	
	//metodo que vacia las cajas de texto
	private void btnNuevoUsuario(){
		//vaciar las cajas de texto
		textUsuario.setText("");
		textPassword.setText("");
		textVisitas.setText("");
		//colocar el cursor en el usuario
		textUsuario.requestFocus();
	}
	
	
	private void btnGuardarUsuario() throws NumberFormatException{
		//obtener los valores de las cajas
				String usuario=textUsuario.getText();
				String valorPass=new String(textPassword.getPassword());
				//int visitas=Integer.parseInt(textVisitas.getText());
				
				//crear contacto
				Usuario u=new Usuario(usuario, valorPass, 0);
				if(!u.equals("")){
				//comprobar si existe el usuario
				if(gp.CompruebaUsuario(u)){
					int indice=gp.listaUsuarios().indexOf(u);
					gp.updateUsuario(u, indice);
					JOptionPane.showMessageDialog(null,"Se ha modificado correctamente...");
					
				}else{
					//llamar al metodo addContacto
					gp.addUsuarios(u);
					JOptionPane.showMessageDialog(null,"Se ha creado un nuevo usuario...");
					textVisitas.setText(Integer.toString(u.getContVisitas()));
				}
				//actualizar listado usuarios
				tablaFilas(tableUsuarios);
				}else{
					JOptionPane.showMessageDialog(null,"Selecciona usuario...");
				}
	}
	
	
	private void btnEliminarUsuario() throws NumberFormatException{
		
		//obtener los valores de las cajas
		String usuario=textUsuario.getText();
		String valorPass=new String(textPassword.getPassword());
		int visitas=Integer.parseInt(textVisitas.getText());
		
		String[] opciones = { "Si", "No" };
		int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Estas seguro de eliminar este usuario?",
				"Mensaje de Confirmacion", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				opciones, 0);
		
		if (eleccion == 0) {
			//crear usuario
			Usuario u=new Usuario(usuario, valorPass, visitas);
			//obtener el indice del usuario
			int index=gp.listaUsuarios().indexOf(u);
			
			//llamar al metodo del gestor para borrar
			gp.deleteUsuario(index);
			
			//actualizar listado usuarios
			tablaFilas(tableUsuarios);
		}
	}
	
	
	
	
}
