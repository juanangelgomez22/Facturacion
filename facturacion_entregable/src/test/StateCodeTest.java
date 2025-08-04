
package test;

//import org.junit.Test;

import static org.junit.Assert.assertTrue;

import facturas.StateCode;

public class StateCodeTest {

	//@Test
	public void testCorrectaInicializacionSinParametro() {
		StateCode uncodigo=new StateCode();
	    //assert uncodigo.getCodigo()=="UT" : "el parametro de codgo de estado es correcto";
		assertTrue("inicializacio correcta de estado", uncodigo.getCodigo()=="UT");
		assertTrue("tasa correcta", uncodigo.getTasa()==(float) 6.85) ;
	
		System.out.println("el test 1 de correcta inicializacion vacio funciona");
	}

	//@Test
	public void testCorrectaInicializacionconParametroCorrecto() {
		StateCode uncodigo=new StateCode("TX");
		assert uncodigo.getCodigo()=="TX" : "el parametro de codigo de estado es correcto";
		assert uncodigo.getTasa()==(float) 6.25: "tasa correcta";
		//assert((uncodigo.getCodigo()=="TX")&&(uncodigo.getTasa()==(float) 6.25));
		System.out.println("el test 2 de correcta inicializacion con parametro correcto funciona");
	}
	
	//@Test
	public void testCorrectoCambioDeCodigoValido() {
		String nuevoCodigo="NV";
		StateCode uncodigo = new StateCode();
		uncodigo.setCodigo(nuevoCodigo);
		assert uncodigo.getCodigo()==nuevoCodigo : "el parametro de codigo de estado es correcto";
		assert uncodigo.getTasa()==(float) 8.00: "tasa correcta";
		//assert((uncodigo.getCodigo()==nuevoCodigo)&&(uncodigo.getTasa()== (float) 8.00));
		System.out.println("el test 3 de correcta inicializacion vacio funciona");
	}
}
