package test;
//using NUnit.Framework;
//import static org.junit.Assert.*;
//import org.junit.Test;

import facturas.Item;

public class ItemTest {
	//@Test
	public void testCreacionCorrecta() {
		Item nuevoItem = new Item("borceguí 46", (float) 51.072 , 2);
		assert((nuevoItem.getNro()==1)&&(nuevoItem.getDescripcion()=="borceguí 46")&&(nuevoItem.getPrecio_unitario() ==(float) 51.072)&&(nuevoItem.getTotal_sin_impuesto()==2));
	}
	
//	public void testInicializacionIncorrecta() {
//		Item nuevoItem;
//		assertThrows(nuevoItem = new Item("borceguí 46", (float) 51.072 ,(int) (-1)));	
//	};
}
