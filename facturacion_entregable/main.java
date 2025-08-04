
import java.util.*;
import facturas.*;
public class main{
	public static int main()
	{
		boolean seguir_cantidad=true;
		boolean salir_descripcion=false;
		boolean salir_precio_unitario=false;
		boolean salir_cantidad_del_item = false;
		int cantidad_Items;
		Scanner entrada = new Scanner(System.in);
		while(seguir_cantidad)
		{
				System.out.print("ingrese la cantidad de items ");
				cantidad_Items = entrada.nextInt();
				if (cantidad_Items>=1)
					seguir_cantidad = false;
		};
		System.out.println("cantidad de elementos valida");
		Factura mi_Factura = new Factura();
		for (int indice = 0; indice <= cantidad_Items; indice ++)
		{
			String entrada_desc = entrada.next();
			while (!salir_descripcion)
			{
				System.out.println("Ingrese la descripcion del item");
				if ((entrada_desc!="")&&(entrada_desc!=" ")&&(entrada_desc.length()>=1))
					salir_descripcion=true;
			};
			System.out.println("descripcion valida");
			
			float entrada_precio_Uni = entrada.nextInt();
			while (!salir_precio_unitario)
			{
				System.out.print("Ingrese el precio unitatio del articulo " + entrada_desc);
				if (entrada_precio_Uni >(float) 0)
					salir_precio_unitario=true;
			};
			System.out.println("precio valido de " + entrada_desc);
			int entrada_cantidad_item = entrada.nextInt();
			while (!salir_cantidad_del_item)
			{
				System.out.print("Ingrese la cantidad del articulo " + entrada_desc);
				if (entrada_cantidad_item > 0)
					salir_precio_unitario=true;
			};
			System.out.println("cantidad de item valida de " + entrada_desc);
			Item nuevo_Item = new Item(entrada_desc,entrada_precio_Uni,entrada_cantidad_item);
			
			mi_Factura.agregarItem(nuevo_Item);
			float monto_a_pagar = mi_Factura.calcularFactura(); //aca el metodo setea un atributo de factura para guardar la cuenta 
			System.out.println("factura "+ mi_Factura.calcularFactura()+ " monto a pagar $ " + monto_a_pagar);
		};
		System.out.println("Subtotal de la compra "+ mi_factura.get_subtotal());
		System.out.println("Descuento aplicado" + mi_factura.get_descuento_aplicado());
		System.out.println("Impuesto" + mi_factura.getCodigo_Estado().getTasa());
		monto_de_descuento = mi_factura.get_subtotal()*(mi_factura.getCodigo_Estado().getTasa());
		System.out.println("Monto de descuento"+monto_de_descuento);
		System.out.println("Total: "+mi_factura.get_monto_a_pagar);
		return 0;
	};
};