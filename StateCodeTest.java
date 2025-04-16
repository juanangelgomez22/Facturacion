package test;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.*;

import facturas.StateCode;

public class StateCodeTest {

	//@Test
	public void testCorrectaInicializacionSinParametro() {
		StateCode uncodigo=new StateCode();
		assert((uncodigo.getCodigo()=="UT")&&(uncodigo.getTasa()==(float) 6.85));
	}

	public void testCorrectaInicializacionconParametroCorrecto() {
		StateCode uncodigo=new StateCode("TX");
		assert((uncodigo.getCodigo()=="TX")&&(uncodigo.getTasa()==(float) 6.25));
	}
	
	public void testCorrectoCambioDeCodigoValido() {
		String nuevoCodigo="NV";
		StateCode uncodigo = new StateCode();
		uncodigo.setCodigo(nuevoCodigo);
		assert((uncodigo.getCodigo()==nuevoCodigo)&&(uncodigo.getTasa()== (float) 8.00));
	}
	
//	public void testCorrectoCambioDeCodigoInvalido() {
//		String nuevoCodigo="JU";
//		StateCode uncodigo = new StateCode();
//		assertThrows(uncodigo.setCodigo(nuevoCodigo));
//	}
}
