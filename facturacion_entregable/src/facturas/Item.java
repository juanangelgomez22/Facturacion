package facturas;

public class Item{
	private int ultimonumero;
	private int nro;
    private String descripcion;
    private Float precio_unitario;
    private int cantidad;
    private float total_sin_impuesto;
    
    public Item(String descripcion, Float precio_unitario, int cantidad) {
    	if((cantidad>=1) && (descripcion!="") && (precio_unitario > (float) 0)){
			this.ultimonumero=0;
			this.nro = ultimonumero + 1 ;
			this.descripcion = descripcion;
			this.precio_unitario = precio_unitario;
			this.cantidad = cantidad;
			this.setTotal_sin_impuesto(this.calcularTotalItem());
			this.ultimonumero=nro;    		
    	}
    	else
    	{
    		throw new IllegalArgumentException("un parametro es incorrecto!!");
    	}

	};

	@Override
	public String toString() {
		return "Item [nro=" + nro + ", descripcion=" + descripcion + ", precio_unitario=" + precio_unitario
				+ ", cantidad=" + cantidad + "]";
	}

	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		if (nro>0)
		{
			this.nro = nro;
			this.ultimonumero=nro -1;
		}

	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(Float precio_unitario) {
		if (precio_unitario > (float) 0)
		{
			this.precio_unitario = precio_unitario;			
		}

	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float calcularTotalItem() {
		float total= precio_unitario * cantidad;
		return total;
	}

	public float getTotal_sin_impuesto() {
		return total_sin_impuesto;
	}

	public void setTotal_sin_impuesto(float total_sin_impuesto) {
		this.total_sin_impuesto = total_sin_impuesto;
	}
   
};