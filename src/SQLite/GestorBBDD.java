package SQLite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Producto;

public class GestorBBDD {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	ConexionSQLite conex = new ConexionSQLite();

	public void crear(Producto p) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO PRODUCTOS (Nombre, Precio, FechaCaducidad, Stock) VALUES(?, ?, ?, ?);";
		try {
			ps = conex.prepareStatement(sql);
			ps.setString(1, p.getNombrePro());
			ps.setFloat(2, p.getPrecioUnidad());
			ps.setString(3, sdf.format(p.getFechaCaducidad()));
			ps.setInt(4, p.getStock());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminar(Producto p) {
		try {
			String sql;
			PreparedStatement ps;
			sql = "Delete from PRODUCTOS where IDProd=? and Nombre=?;";
			ps = conex.prepareStatement(sql);
			ps.setInt(1, p.getIdProducto());
			ps.setString(2, p.getNombrePro());
			int cant_borradas = ps.executeUpdate();
			
			if(cant_borradas==1){
				JOptionPane.showMessageDialog(null, "Se ha borrado "+ p.getNombrePro());
			}
			else{
				JOptionPane.showMessageDialog(null,"No se ha podido borrar.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificar(Producto p) {
		String sql;
		PreparedStatement ps;
		sql = "Update PRODUCTOS set Nombre=?, Precio=?, FechaCaducidad=?, Stock=? WHERE IDProd=?;";

		try {
			ps = conex.prepareStatement(sql);
			ps.setString(1, p.getNombrePro());
			ps.setFloat(2, p.getPrecioUnidad());
			ps.setString(3, sdf.format(p.getFechaCaducidad()));
			ps.setInt(4, p.getStock());
			ps.setInt(5, p.getIdProducto());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Producto> listarProductos() {
		String sql;
		sql = "Select * From PRODUCTOS;";
		ArrayList<Producto> listado = new ArrayList<Producto>();
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer idProd = rs.getInt("IDProd");
				String nombre = rs.getString("Nombre");
				float precio = rs.getFloat("Precio");
				Date fechaCad = sdf.parse(rs.getString("FechaCaducidad"));
				Integer stock = rs.getInt("Stock");

				Producto prod = new Producto(idProd, nombre, precio, fechaCad, stock);
				listado.add(prod);
			}
			rs.close();
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listado;
	}

	public ArrayList<Producto> listarCompra() {
		String sql;
		sql = "Select * From PRODUCTOS;";
		ArrayList<Producto> listado = null;
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listado = new ArrayList<Producto>();
				String nombre = rs.getString("Nombre");
				float precio = rs.getFloat("Precio");
				Integer stock = rs.getInt("Stock");
				Producto prod = new Producto(nombre, stock, precio);
				listado.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listado;
	}
}
