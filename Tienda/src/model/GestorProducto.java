package model;

import java.util.Date;

import SQLite.ConexionSQLite;
import SQLite.GestorBBDD;

public class GestorProducto {
	private GestorBBDD gbd = new GestorBBDD();

	public void crear(Producto p) {
		Producto prod = new Producto(p.getIdProducto(), p.getNombrePro(), p.getStock(), p.getPrecioUnidad(),
				p.getFechaCaducidad());
		;
		gbd.crear(prod);
	}

	public void eliminar(Producto p) {
		
	}

}
