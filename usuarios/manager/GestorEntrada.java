package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import model.GestorBdSqlite;
import model.Usuario;

public class GestorEntrada implements IGestorEntrada {
	GestorBdSqlite gbd = new GestorBdSqlite();
	private DefaultComboBoxModel<Usuario> modelo=new DefaultComboBoxModel<Usuario>();
	
	//metodo constructor vacio
	public GestorEntrada(){

	}
	
	public boolean CompruebaUsuario(Usuario u){
		String sql = "SELECT * FROM USUARIOS WHERE Codigo=? AND Password=?;";
		
		try {	
			PreparedStatement ps=gbd.prepareStatement(sql);
			ps.setString(1, u.getCod());
			ps.setString(2, u.getPassword());
			
			// pedir a la bd todos los usuarios
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			 System.out.println("Error en la ejecución:" + e.getErrorCode() + " " + e.getMessage());
		}
		return true;
		
	}
	
	public DefaultComboBoxModel<Usuario>getUsuarios(){
		String sql = "SELECT * FROM USUARIOS";
		//borrar todos los elemntos del modelo
		modelo.removeAllElements();
		
		modelo.addElement(new Usuario("(Seleccionar)","",0));
		try {	
			PreparedStatement ps=gbd.prepareStatement(sql);
			// pedir a la bd todos las contactos
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String codigo = rs.getString("Codigo");
				String password = rs.getString("Password");
				int contVisitas = rs.getInt("Visitas");
				// crear usuario
				Usuario u = new Usuario(codigo,password,contVisitas);
							
				//añadir el usuario al comboBox
				modelo.addElement(u);
			}
		} catch (SQLException e) {
			 System.out.println("Error en la ejecución:" + e.getErrorCode() + " " + e.getMessage());
		}
		return modelo;	
	}
	
	//metodo que devuelve todos los usuarios
		public ArrayList<Usuario> listaUsuarios() {
			 ArrayList<Usuario> lista=new ArrayList<Usuario>();
			String sql = "SELECT * FROM USUARIOS";
				try {	
					PreparedStatement ps=gbd.prepareStatement(sql);
					// pedir a la bd todos los usuarios
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						String codigo = rs.getString("Codigo");
						String password = rs.getString("Password");
						int visitas = rs.getInt("Visitas");
						// crear usuario
						Usuario u = new Usuario(codigo, password, visitas);
						// añadir el usuario al arraylist
						lista.add(u);
					}
				} catch (SQLException e) {
					 System.out.println("Error en la ejecución:" + e.getErrorCode() + " " + e.getMessage());
				}
				return lista;	
		}
	
	//metodo incrementa visitas
	public void incVisitas(Usuario u){
		try{
			PreparedStatement ps;
			//llamar al metodo para incrementar las visitas
			u.incContVisitas();
			
			String sql = "UPDATE USUARIOS SET Visitas=? WHERE Codigo=? AND Password=?;";
			ps=gbd.prepareStatement(sql);
			ps.setInt(1,u.getContVisitas());
			ps.setString(2,u.getCod());
			ps.setString(3,u.getPassword());
			ps.executeUpdate();
			}catch (SQLException e) {
				 System.out.println("Error en la ejecución:" + e.getErrorCode() + " " + e.getMessage());
			}	 	
	}
	
	//añadir usuario
	public void addUsuarios(Usuario u){
		try{
			PreparedStatement ps;
			String sql="INSERT INTO USUARIOS VALUES(?,?,?);";
		
			ps=gbd.prepareStatement(sql);
			ps.setString(1, u.getCod());
			ps.setString(2, u.getPassword());
			ps.setInt(3, 0);
			ps.executeUpdate();
			}catch (SQLException e) {
				 System.out.println("Error en la ejecución:" + e.getErrorCode() + " " + e.getMessage());
			}	 
	}
	
	public void updateUsuario(Usuario u, int indice){
		try{
			PreparedStatement ps;
			//coger el usuario pasado por parametro
			//Usuario user=modelo.getElementAt(indice);
			Usuario user=listaUsuarios().get(indice);
			String sql = "UPDATE USUARIOS SET Codigo=?, Password=? WHERE Codigo=? AND Password=?;";
			ps=gbd.prepareStatement(sql);
			ps.setString(1,u.getCod());
			ps.setString(2,u.getPassword());
			ps.setString(3,user.getCod());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();
		}catch (SQLException e) {
			 System.out.println("Error en la ejecución:" + e.getErrorCode() + " " + e.getMessage());
		}	 	
	}
	
	//borrar un usuario
	public void deleteUsuario(int indice){
		try{
			PreparedStatement ps;
			Usuario u=listaUsuarios().get(indice);
			String sql = "DELETE FROM USUARIOS WHERE Codigo=?;";
			ps=gbd.prepareStatement(sql);
			ps.setString(1,u.getCod());
			//ps.setString(2,u.getPassword());
			ps.executeUpdate();
			}catch(SQLException e){
				 System.out.println("Error en la ejecución:" + e.getErrorCode() + " " + e.getMessage());
			}
	}
	
}
