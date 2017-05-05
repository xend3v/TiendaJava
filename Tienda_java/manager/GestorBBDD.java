package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.ModeloRelleno;
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
			System.out.println("Error en GestorBBDD linea 28: " + e);
		}
	}

	public void eliminar(Producto p) {
		String sql;
		PreparedStatement ps;
		sql = "Delete * from PRODUCTOS where IDProd=? and Nombre=?;";
		try {
			ps = conex.prepareStatement(sql);
			ps.setInt(1, p.getIdProducto());
			ps.setString(2, p.getNombrePro());
			ps.executeQuery();
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
		ResultSet rs = null;
		sql = "Select * From PRODUCTOS;";
		ArrayList<Producto> listado = new ArrayList<Producto>();
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			Integer idProd = rs.getInt("IDProd");
			String nombre = rs.getString("Nombre");
			float precio = rs.getFloat("Precio");
			Date fechaCad = sdf.parse(rs.getString("FechaCaducidad"));
			Integer stock = rs.getInt("Stock");

			Producto prod = new Producto(nombre, precio, fechaCad, stock);
			listado.add(prod);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listado;
	}

	public ArrayList<Producto> listarCompra() {
		String sql;
		ResultSet rs = null;
		sql = "Select * From PRODUCTOS;";
		ArrayList<Producto> listado =new ArrayList<Producto>();
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			String nombre = rs.getString("Nombre");
			float precio = rs.getFloat("Precio");
			Integer stock = rs.getInt("Stock");

			Producto prod = new Producto(nombre, precio,ModeloRelleno.FECHACADUCIDAD,stock);
			listado.add(prod);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listado;
	}
	
	public ArrayList<Producto> listadoHistorial(){
		String sql="SELECT IDCompra,Precio,FechaCompra  from COMPRAR ORDER BY FechaCompra;";
		ResultSet rs = null;
		ArrayList<Producto> listado = new ArrayList<Producto>();;
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			Integer idCompra = rs.getInt("IDCompra");
			float precio = rs.getFloat("PrecioTotal");
			Date fechaCompra = sdf.parse(rs.getString("FechaCompra"));

			Producto compra = new Producto(idCompra, precio, fechaCompra);
			listado.add(compra);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listado;
	}
	
	
}
