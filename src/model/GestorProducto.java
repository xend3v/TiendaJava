package model;

import java.util.Date;

import SQLite.ConexionSQLite;
import SQLite.GestorBBDD;

public class GestorProducto {
	private GestorBBDD gbd = new GestorBBDD();

	public void crear(Producto p) {
		Producto prod = new Producto(p.getNombrePro(), p.getPrecioUnidad(),
				p.getFechaCaducidad(), p.getStock());
		;
		gbd.crear(prod);
	}


}
