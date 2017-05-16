package model;

//import java.util.ArrayList;
import java.util.Date;

public class Compras {
	private int idCompra;
	private int idProducto;
	
	private String nombreProducto;
	private float precioUnidad;
	private float precioTotal;
	private int cantidadUnidad;
	private Date fechaCompra;
	private int Stock;
	//private ArrayList<Compras> listCompra = new ArrayList<Compras>();
	
	//Constructora para tabla compras sql
		public Compras (String nombreProducto, float precioUnidad, float precioTotal, int cantidadUnidad, Date fechaCompra){
			//this.idCompra=idCompra;
			//this.idProducto=idProducto;
			this.nombreProducto=nombreProducto;
			this.precioUnidad=precioUnidad;
			this.precioTotal=precioTotal;
			this.cantidadUnidad=cantidadUnidad;
			this.fechaCompra=fechaCompra;
		}
		//constructora para mostrar compras
		 public Compras(int idCompra, float precioTotal,Date fechaCompra){
			 this.idCompra=idCompra;
			 this.precioTotal=precioTotal;
			 this.fechaCompra=fechaCompra;		 
		 }
		 //constructora para mostrar lista de compra
		 public Compras (String nombreProd, float precioUnidad){
			 this.nombreProducto = nombreProd;
			 this.precioUnidad = precioUnidad;
		 }
		
	//metodos Getters and Setters	 
	public int getIdCompra() {
			return idCompra;
		}
		public void setIdCompra(int idCompra) {
			this.idCompra = idCompra;
		}
		
	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public float getPrecioUnidad() {
		return precioUnidad;
	}


	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}


	public float getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}


	public int getCantidadUnidad() {
		return cantidadUnidad;
	}


	public void setCantidadUnidad(int cantidadUnidad) {
		this.cantidadUnidad = cantidadUnidad;
	}


	public Date getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	@Override
	public String toString(){
		return "Nombre: " + nombreProducto + " || Precio: " + precioUnidad +"€";
	}

	
}
