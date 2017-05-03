package SQLite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Producto;

public class GestorBBDD {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	ConexionSQLite  conex = new ConexionSQLite();
	public void crear(Producto p) {
		String sql;
		PreparedStatement ps;
		sql = "INSERT INTO PLANTACIONES VALUES(?, ?, ?, ?, ?, ?);";
		try {
		ps=conex.prepareStatement(sql);
		ps.setInt(1, p.getIdProducto());
		ps.setString(2, p.getNombrePro());
		ps.setFloat(3, p.getPrecioUnidad());
		ps.setString(4, sdf.format(p.getFechaCaducidad()) );
		ps.setInt(5, p.getStock());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminar(Producto p){
		String sql;
		PreparedStatement ps;
		sql = "Delete * from PRODUCTOS where IDProd=? and Nombre=?;";
		ps=conex.prepareStatement(sql);
		try {
		ps.setInt(1, p.getIdProducto());
		ps.setString(2, p.getNombrePro());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modificar(Producto p){
		String sql;
		PreparedStatement ps;
		sql = "Update PRODUCTOS set Nombre=?, Precio=?, FechaCaducidad=?, Stock=? WHERE IDProd=?;";
		ps=conex.prepareStatement(sql);
		try {
			ps.setString(1, p.getNombrePro());
			ps.setFloat(2, p.getPrecioUnidad());
			ps.setString(3, sdf.format(p.getFechaCaducidad()) );
			ps.setInt(4, p.getStock());
			ps.setInt(5, p.getIdProducto());
			ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public ArrayList<Producto> listarProductos(){
		String sql;
		ResultSet rs;
		sql = "Select * From PRODUCTOS;";
		rs=(ResultSet) conex.prepareStatement(sql);
		ArrayList<Producto> listado= new ArrayList<Producto>();
		try {
			Integer IDProd = ps.get
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		listado.add(sql);
		return listado;
	}
}
