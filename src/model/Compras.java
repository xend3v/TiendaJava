package model;

import java.util.ArrayList;
import java.util.Date;

public class Compras {
	private int idCompra;
	private int IdProducto;
	private String nombreProducto;
	private float precioUnidad;
	private float precioTotal;
	private int cantidadUnidad;
	private int cantidadTotal;
	private Date fechaCompra;
	private ArrayList<Compras> listCompra = new ArrayList<Compras>();
	
	//Constructora para tabla compras sql
		public Compras (String nombreProducto,int idProducto, float precioUnidad, float precioTotal, int cantidadUnidad, int cantidadTotal, Date fechaCompra){
			//this.idCompra=idCompra;
			this.IdProducto=idProducto;
			this.nombreProducto=nombreProducto;
			this.precioUnidad=precioUnidad;
			this.precioTotal=precioTotal;
			this.cantidadUnidad=cantidadUnidad;
			this.cantidadTotal=cantidadTotal;
			this.fechaCompra=fechaCompra;
		}
		
		//constructora para mostrar compras
		 public Compras(int idCompra, float precioTotal,Date fechaCompra){
			 this.idCompra=idCompra;
			 this.precioTotal=precioTotal;
			 this.fechaCompra=fechaCompra;		 
		 }
		 
		 //constructora para añadir compras
		 public Compras(String nombre, float precio, int cantidad){
			 this.nombreProducto=nombre;
			 this.precioUnidad=precio;
			 this.cantidadUnidad=cantidad;		 
		 }
		
	//metodos Getters and Setters	 
		 
	public int getIdProducto() {
			return IdProducto;
	}
	
	public void setIdProducto(int idProducto) {
			IdProducto = idProducto;
	}
	 	 
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

	public int getCantidadTotal() {
		return cantidadTotal;
	}
	
	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	
	
	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}	
}
