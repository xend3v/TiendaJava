package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModeloRelleno {

	public static final String NOMBRE_PRODUCTO_RELLENO = "";
	public static final int STOCK=0;
	public static final Date FECHACADUCIDAD= convertirEnFecha("01/01/1960");
	public static final Date FECHACOMPRA=null;
	public static final int IDPRODUCTO=0;
	
	public static Date convertirEnFecha(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				
		try {
			return sdf.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
