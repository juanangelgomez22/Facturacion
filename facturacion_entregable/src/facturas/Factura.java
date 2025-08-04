package facturas;
import java.util.ArrayList;
//import org.junit.jupiter.api;
public class Factura
{
    private int nro_anterior;
    private int nro_factura;
    private java.util.ArrayList<facturas.Item> items;
    private float monto_sin_impuesto;
    private StateCode codigo_Estado;
    private int cantidad_Items;
    private float monto_a_pagar;
    private float descuento_aplicado;
    private float subtotal;	

    //post: crea una factura sin items cargados e inicializa el nro en 1
    public Factura()
    {
        nro_anterior=0;
        items=new ArrayList<facturas.Item>();
        nro_factura=nro_anterior + 1;
        monto_sin_impuesto=0;
        nro_anterior=nro_factura;
    };

    //pre: nro de factura pasado es positivo
    //post: crea una factura con el nro pasado y sin items cargados
    public Factura(int unnumero)
    {
    	if (unnumero >= 1)
    	{
    		nro_anterior=unnumero-1;
    		items=new ArrayList<facturas.Item>();
    		nro_factura=unnumero;
    		monto_sin_impuesto=0; 
            nro_anterior=nro_factura;
    	}
    	else
    	{
    		 throw new IllegalArgumentException("los nros de factura son positivos!!");
    	};
    };
   
    //pre: item ya creado e inicializado correctamente
    //post: agrega el item a la factura
    public void agregarItem(Item unitem)
    {
    	if (unitem!=null)
    	{
    		items.add(unitem);
    		setCantidad_Items(getCantidad_Items()+1);
    	}
    	else
    	{
    		throw new IllegalArgumentException("argumento fuera de valor");
    	};
    };


	//pre: factura creada
	//post: cambia internamente el nro de factura, solo es accesivle desde la clase factura
	//@SuppressWarnings("unused")
	public void setNro_factura(int nro_factura) {
		if (nro_factura>0)
		{
			this.nro_factura = nro_factura;
			this.nro_anterior = nro_factura - 1;			
		}
		else
			throw new IllegalArgumentException("no hay nro de factura negativo");
	}

	//pre:factura creada y lista de items no vacia
	//post: devuelve la lista de items cargados en la factura
	public java.util.List<Item> getItems() {
		return items;
	}

	
	//post: devuelve el monto bruto de la factura
	public float getMonto_sin_impuesto() {
		return monto_sin_impuesto;
	}

	//pre: factura creada
	//post: cambia internamente el monto bruto, solo es accesivle desde la clase factura
//	@SuppressWarnings("unused")
	public final void setMonto_sin_impuesto(float monto_sin_impuesto) {
		this.monto_sin_impuesto = monto_sin_impuesto;
	}



	@Override
	public String toString() {
		return "Factura [nro_factura=" + nro_factura + ", items=" + items.toString() + ", monto_sin_impuesto=" + monto_sin_impuesto
				+ ", codigo_Estado=" + codigo_Estado.toString() + ", cantidad_Items=" + cantidad_Items + ", monto_a_pagar="
				+ monto_a_pagar + "]";
	}

	//pre: factura creada, con al menos 1 elemento, codigo cargado correctamente
	//post: calcula el monto a pagar
	public float calcularFactura() 
	{
		float subtotal=0;		
		if(getCantidad_Items()>=1)
		{
			for (int indice=0;indice<this.getCantidad_Items();indice++)
			{
				Item itemActual=this.getItems().get(indice);
				subtotal+=itemActual.calcularTotalItem();
				//indice+=1;
			}
			this.subtotal=subtotal;
			monto_sin_impuesto=subtotal;
			//aplico_Descuento
			aplicar_Descuento(subtotal);
			monto_a_pagar=monto_sin_impuesto + this.aplicar_Impuesto(subtotal);
			return monto_a_pagar;			
		}
		else
			//se asume factura vacia
			return 0;
	};

	@SuppressWarnings("unused")
	private final int getNro_anterior() {
		return nro_anterior;
	}
	
	//pre; factura creada y codigo valido
	//poat: devuelve el objeto con el codigo del estado y el valor de la tasa
	public StateCode getCodigo_Estado() {
		return codigo_Estado;
	}

	//pre; factura creada y codigo pasado es valido
	//poat: cambia el objeto con el codigo del estado y el valor de la tasa pasados
//	private final void setCodigo_Estado(String un_codigo_Estado) {
//		this.codigo_Estado = new StateCode(un_codigo_Estado);
//	}

	//pre; factura creada y parametro cargado correctamente
	//poat: cambia el objeto almacenado con el objeto pasado
	//@SuppressWarnings("unused")
	public final void setCodigo_Estado(StateCode un_codigo_Estado) {
		this.codigo_Estado = un_codigo_Estado;
	}
	
	//pre: factura creada
	//post: devuelve la cantidad de items de la factura
	public int getCantidad_Items() {
		return cantidad_Items;
	}

	//poat;cambia la cantidad de items cargadas en la factura, solo es accesible desde la clase factura
	private final void setCantidad_Items(final int cantidad_Items) {
		this.cantidad_Items = cantidad_Items;
	}
	
	//pre: instancia creada y con items cargados
	//post: calcula y aplica el descuento tabulado segun el subtotal de la factura
	public void aplicar_Descuento(float subtotal)
	{
		if (subtotal<=1000)
		{
			monto_sin_impuesto=(float) (monto_sin_impuesto * 1);//aplico el 0% de descuento
			this.descuento_aplicado= (float) 0;
		}
		else 
		{
			if ((subtotal > ((float) 1000)) && (subtotal <= ((float) 5000)))
			{
				descuento_aplicado=(float) (subtotal * 0.03);
				monto_sin_impuesto=(float) (monto_sin_impuesto * 0.97);//aplico el 3% de descuento
			
			} 
			else 
			{
				if ((subtotal > ((float) 5000)) && (subtotal <= ((float) 7000)))
				{
					descuento_aplicado=(float) (subtotal * 0.05);
					monto_sin_impuesto=(float) (monto_sin_impuesto * 0.95);//aplico el 5% de descuento
				
				}
				else 
				{
					if ((subtotal > ((float) 7000)) && (subtotal <= ((float) 10000)))
					{
						descuento_aplicado=(float) (subtotal * 0.07);
						monto_sin_impuesto=(float) (monto_sin_impuesto * 0.93);//aplico el 7% de descuento
					}
					else 
					{
						if ((subtotal > ((float) 10000)) && (subtotal <= ((float) 50000)))
						{
							descuento_aplicado=(float) (subtotal * 0.10);
							monto_sin_impuesto=(float) (monto_sin_impuesto * 0.90);//aplico el 10% de descuento
						}
						else
						{
							if ((subtotal > ((float) 50000)))
							{
								descuento_aplicado=(float) (subtotal * 0.15);
								monto_sin_impuesto=(float) (monto_sin_impuesto * 0.85);//aplico el 15% de descuento
							};
						};
					};
				};
			};
		};
	};
	
	//pre: factura creada y con uno o mas items
	//post:calcula el monto del impuesto que tiene que pagar al estado
	public float aplicar_Impuesto(float subtotal)
	{
		return subtotal*this.getCodigo_Estado().getTasa();
	};
	
	//pre: instancia creada
	//post: devuelve la cantidad de elementos almacenados en la lista de items
	public int get_Cantidad_Items()
	{
		int cantidad=this.getItems().size();
		return cantidad;
	};

	//Pre: instancia creada
	//post: devuelve el nro de factura
	public int getNro_Factura()
	{
		return this.nro_factura;
	}

	//Pre: Instancia Creada y no vacia la lista de items 
	//Post: devuelve el descuento que se aplico en la factura
	public float get_descuento_aplicado()
	{
		return descuento_aplicado;
	};

	//PRE: instancia creada y lista de items no vacia
	//post: devuelve el subtotal de la factura (cantidad de items * precio unitario)
	public float get_subtotal()
	{	
		return this.subtotal;
	}

	//Pre: instancia creada y no vacia
	//post: devuelve el monto a pagar con los descuentos aplicados
	public float get_monto_a_pagar()
	{
		return monto_a_pagar;
	}
}; 	