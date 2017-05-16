package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModeloRelleno {
	/*
	public static final String NOMBRE_PRODUCTO_RELLENO = "";
	public static final int STOCK = 0;
	public static final Date FECHACADUCIDAD = convertirEnFecha("01/01/1960");
	public static final Date FECHACOMPRA = null;
	public static final int IDCOMPRA = 0;
	*/
	public static final SimpleDateFormat sdfSoloFecha = new SimpleDateFormat("yyyy/MM/dd");

	
	public static Date convertirEnFecha(String fecha) {
		try {
			return sdfSoloFecha.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String deFechaAString(Date date) {
		return sdfSoloFecha.format(date);
	}
}
