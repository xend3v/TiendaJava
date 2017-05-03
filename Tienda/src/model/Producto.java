package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Producto {
	private int idProducto;
	private String nombrePro;
	private int stock;
	private float precioUnidad;
	private Date fechaCaducidad;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	private ArrayList<Producto> listCompra = new ArrayList<Producto>();
	private ArrayList<Producto> listProductos = new ArrayList<Producto>();

	// Constructora para mostrar la lista de compra
	public Producto(String nombrePro, int stock, float precioUnidad) {
		this.nombrePro = nombrePro;
		this.stock = stock;
		this.precioUnidad = precioUnidad;
	}

	// Constructora que muestra todos los atributos de producto
	public Producto(int idProducto, String nombrePro, int stock, float precioUnidad, Date fechaCaducidad) {
		this.idProducto = idProducto;
		this.nombrePro = nombrePro;
		this.stock = stock;
		this.precioUnidad = precioUnidad;
		this.fechaCaducidad = fechaCaducidad;
	}

	/*
	 * public ArrayList <Producto> listProductoCompra(){ Producto listaCompra =
	 * new Producto (nombrePro, stock, precioUnidad);
	 * listCompra.add(listaCompra); return listCompra; } public ArrayList
	 * <Producto> listaProductos(){ Producto listaProd = new Producto
	 * (idProducto, nombrePro, stock, precioUnidad, fechaCaducidad);
	 * listProductos.add(listaProd); return listProductos; }
	 */
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombrePro() {
		return nombrePro;
	}

	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	// Mostrar lista de compra
	@Override
	public String toString() {
		return nombrePro + ":" + stock + ":" + precioUnidad;
	}

	// Comprobar que no se inserten productos con mismo ID y nombre
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Producto) {
			Producto prod = (Producto) obj;
			if (idProducto == prod.getIdProducto() && nombrePro.equals(prod.getNombrePro())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
