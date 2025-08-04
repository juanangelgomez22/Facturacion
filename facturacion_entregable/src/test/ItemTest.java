
package test;
import static org.junit.Assert.assertTrue;
import facturas.Item;

public class ItemTest {
	//@Test
	public void testCreacionCorrecta() {
		Item nuevoItem = new Item("borceguí 46", (float) 51.072 , 2);
		assert((nuevoItem.getNro()==1)&&(nuevoItem.getDescripcion()=="borceguí 46")&&(nuevoItem.getPrecio_unitario() ==(float) 51.072)&&(nuevoItem.getCantidad()==2));
	}
	
	public void testCorrectoCalculoTotalItem() {
		Item nuevoItem = new Item("borceguí 46", (float) 51.072 , 2);
		float resultado =(float) 102.144;
		float calculo = nuevoItem.getPrecio_unitario()*nuevoItem.getCantidad();
		assertTrue("el test 2 funciona",resultado == calculo);
	};
}
