package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Compras;
import model.ModeloRelleno;
import model.Producto;

public class GestorBBDD {
	private SimpleDateFormat sdft = new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	ConexionSQLite conex = new ConexionSQLite();

	public void crear(Producto p) {
		PreparedStatement ps;
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
		PreparedStatement ps;
		String sql = "Delete * from PRODUCTOS where IDProd=? and Nombre=?;";
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
	
	//mostrar todos los productos disponibles
	public ArrayList<Producto> listarProductos() {
		String sql = "Select * From PRODUCTOS;";
		ArrayList<Producto> listado = new ArrayList<Producto>();
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
				while (rs.next()){
					//Integer idProd = rs.getInt("IDProd");
					String nombre = rs.getString("Nombre");
					float precio = rs.getFloat("Precio");
					Date fechaCad = sdf.parse(rs.getString("FechaCaducidad"));
					Integer stock = rs.getInt("Stock");
					Producto prod = new Producto(nombre, precio, fechaCad, stock);
					listado.add(prod);
				}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listado;
	}
	
	//mostrar compras para añadir al carrito
	public ArrayList<Producto> listarCompra() {
		String sql = "Select * From PRODUCTOS;";
		ArrayList<Producto> listado =new ArrayList<Producto>();
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
				while (rs.next()){
					String nombre = rs.getString("Nombre");
					float precio = rs.getFloat("Precio");
					Integer stock = rs.getInt("Stock");
					//Producto prod = new Producto(nombre, precio,ModeloRelleno.FECHACADUCIDAD,stock);
					Producto prod = new Producto(nombre, precio, stock);
					listado.add(prod);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listado;
	}
	
	//mostrar historial de compras
	public ArrayList<Compras> listadoHistorial(){
		//String sql="SELECT IDCompra,PrecioTotal,FechaCompra  from COMPRAS ORDER BY FechaCompra;";
		String sql="SELECT * from COMPRAS ORDER BY FechaCompra;";
		ArrayList<Compras> listado = new ArrayList<Compras>();
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while (rs.next()){
				Integer idCompra = rs.getInt("IDCompra");
				float precio = rs.getFloat("PrecioTotal");
				Date fechaCompra = sdf.parse(rs.getString("FechaCompra"));
				Compras compra = new Compras(idCompra, precio, fechaCompra);
				listado.add(compra);
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listado;
	}
	
	//Meotodo para Añadir compras
	public void crearCompra(Compras c){
		PreparedStatement ps;
		String sql = "INSERT INTO COMPRAS (PrecioTotal, FechaCompra) VALUES(?, ?, ?);";
		try {
			ps = conex.prepareStatement(sql);
			ps.setFloat(1, c.getPrecioTotal());
			ps.setString(2, sdf.format(c.getFechaCompra()));
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error en GestorBBDD linea 28: " + e);
		}
	}
	
	public void detallesCompra(Compras c){
		PreparedStatement ps;
		String sql = "INSERT INTO DETALLES (FechaCompra, IDProducto, NombreProducto, PrecioProducto, CantidadProducto) VALUES(?,?,?, ?, ?);";
		try {
			ps = conex.prepareStatement(sql);
			ps.setString(1, sdft.format(c.getFechaCompra()));
			ps.setInt(2, c.getIdProducto());
			ps.setFloat(3, c.getPrecioTotal());
			ps.setString(4, sdf.format(c.getFechaCompra()));
			ps.setInt(5, c.getCantidadUnidad());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error en GestorBBDD linea 28: " + e);
		}
	}
	
	
	//metodo que devuelve la fecha actual
	public Date getFechaCompra(){
		Date hoy=new Date();
		return hoy;	
	}
	//Coger fechacompra[ID de detalles] para el metodo crearCarrito
		public String fechaProducto(String fecha) throws SQLException{ 
			String sql = "Select FechaCompra from COMPRAS where IDCompra='';";
			ResultSet rs;
			PreparedStatement ps = conex.prepareStatement(sql);;
			try {
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = ps.executeQuery();
			fecha = sdft.format(rs);
			return fecha;
		}
		
		//metodo para restar las cantidades compradas al stock
		public void restarCantidad(int cantidad, int IDprod){
			String sql = "Update PRODUCTOS SET Stock="+cantidad+" where IDProd="+IDprod+";";
			try {
				PreparedStatement ps = conex.prepareStatement(sql);
				int hecho = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
