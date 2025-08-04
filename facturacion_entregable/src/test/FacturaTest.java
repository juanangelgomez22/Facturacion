
package test;
import facturas.Item;
import facturas.StateCode;

import static org.junit.Assert.assertTrue;

import facturas.Factura;



public class FacturaTest {
	
	
	//@Test
	public void testCreacionCorrectaDeFacturaSinParametros() {
		Factura unafactura = new Factura();
		boolean condicion;
		condicion=unafactura.getNro_Factura() == 1;
		assertTrue("el test 1 pasa", condicion);
	}

	//@Test
	public void testAgregarItem() {
		Item nuevoItem = new Item("borceguí 46", (float) 51.072 , 2);
		Factura unafactura = new Factura();
		unafactura.agregarItem(nuevoItem);
		Item otroItem = new Item("zapatilla 38", (float) 17.336 , 1);
		unafactura.agregarItem(otroItem);
		int tam = unafactura.get_Cantidad_Items();
		assertTrue("la prueba 2 funciona",tam==2);
		//assert(tam == 2): "la prueba 2 funciona";
	}
	

	//@Test
	public void testGetNro_factura() {
	//	fail("Not yet implemented");
		Factura unafactura = new Factura();
		assertTrue ("la prueba 3 funciona",unafactura.getNro_Factura()==1);
	}

	//@Test
	public void testSetNro_factura_Correcto() {
		Factura unafactura = new Factura();
		unafactura.setNro_factura(10);
		assert (unafactura.getNro_Factura()==10) :"la prueba 4 funciona";
	};
	
	public void testSetNro_factura_inorrecto() {
		Factura unafactura = new Factura();			
		//assertThrows(unafactura.setNro_factura((int) (-1)));
		unafactura.setNro_factura((int) (-1));
		assert(unafactura.getNro_Factura()==1) :"la prueba 5 funciona";
	};

	//@Test
	public void testGetItems() {
		Factura unafactura = new Factura();
		Item nuevoItem = new Item("borceguí 46", (float) 51.072 , 2);
		unafactura.agregarItem(nuevoItem);	
		Item otroItem = new Item("zapatilla 38", (float) 17.336 , 1);
		unafactura.agregarItem(otroItem);
		assert(unafactura.getItems().size()==2):"El test 6 funciona";
	}


	//@Test
	public void testGetMonto_sin_impuesto() {
		Factura unafactura = new Factura();
		Item nuevoItem = new Item("borceguí 46", (float) 51.072 , 2);
		unafactura.agregarItem(nuevoItem);
		Item otroItem = new Item("zapatilla 38", (float) 17.336 , 1);
		unafactura.agregarItem(otroItem);
		float valor= (float) 119.48;
		assert(unafactura.getMonto_sin_impuesto()==valor) : "la prueba 7 funciona";
	}

	//@Test
	public void testSetMonto_sin_impuesto() {
		Factura unafactura = new Factura();
		unafactura.setMonto_sin_impuesto(1);
		assert(unafactura.getMonto_sin_impuesto()==1);
	}

	//@Test
	public void testGetCodigo_Estado() {
		Factura unafactura = new Factura();
		StateCode uncodigo = new StateCode();
		unafactura.setCodigo_Estado(uncodigo);
		assert((unafactura.getCodigo_Estado().getCodigo()=="UT")&&(unafactura.getCodigo_Estado().getTasa()==(float) 6.85));
		//fail("Not yet implemented");
	}

	//@Test
	public void testSetCodigo_Estado() {
		Factura unafactura = new Factura();
		StateCode uncodigo = new StateCode();
		String nuevoCodigo = "TX";
		uncodigo.setCodigo(nuevoCodigo);
		unafactura.setCodigo_Estado(uncodigo);
		assert((unafactura.getCodigo_Estado().getCodigo()=="TX")&&(unafactura.getCodigo_Estado().getTasa()== (float) 6.25));
		//fail("Not yet implemented");
	}

};
