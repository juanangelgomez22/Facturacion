package facturas;
public class StateCode
{
    private String codigo;
    private float tasa;

    /**
     * @param c
     */
    //@SuppressWarnings("OverridableMethodCallInConstructor")
    //pre: codigo valido
    //post: devuelve una instancia con el codigo y la tasa fijadas
    public StateCode(String c)
    {
        float unatasa;
        switch(c.toUpperCase()) {
            case "UT" :
                unatasa = (float)6.85;
                this.setTasa(unatasa);
                break;
            case "NV":
                unatasa = (float) 8.00;
                this.setTasa(unatasa);
                break;
            case "TX":
            unatasa=(float)6.25;
                this.setTasa(unatasa);
                break;
            case "AL":
                unatasa=(float) 4;
                this.setTasa(unatasa);
            case "CA":
                unatasa=(float) 8.25;
                this.setTasa(unatasa);
                break;
            default:
                throw new IllegalArgumentException("argumento fuera de valor");
        };
    };

    @Override
    public String toString() {
        return "[codigo=" + codigo + ", tasa=" + tasa + "]";
    }

    //pre: instancia creada
    //post: devuelve el codigo de 2 letras que identifica al estado
    public String getCodigo() {
        return codigo;
    }

    //pre:instacia creada
    //cambia el codigo del estado, se asume que el codigo es valido
    public final void setCodigo(String uncodigo) {
        float unatasa;        
    	switch(uncodigo.toUpperCase()) {
    	case "UT" :
            unatasa = (float)6.85;
            this.setTasa(unatasa);
            this.codigo=uncodigo;
            break;
        case "NV":
            unatasa = (float) 8.00;
            this.setTasa(unatasa);
            this.codigo=uncodigo;
            break;
        case "TX":
        	unatasa=(float)6.25;
            this.setTasa(unatasa);
            this.codigo=uncodigo;
            break;
        case "AL":
            unatasa=(float) 4;
            this.setTasa(unatasa);
            this.codigo=uncodigo;
        case "CA":
            unatasa=(float) 8.25;
            this.setTasa(unatasa);
            this.codigo=uncodigo;
            break;
        default:
            throw new IllegalArgumentException("argumento fuera de valor");
    	};
    }

    //pre: instancia creada
    //post: devuelve la tasa de impuesto 
    public float getTasa() {
        return tasa;
    }

    //post: cambia el valor de la tasa
    private final void setTasa(float porcentaje) {
    	if (porcentaje > (float) 0)
    		this.tasa = porcentaje;
    	else
    		throw new IllegalArgumentException("porcentaje de impuesto no valido");
    }
    
    //pre: instancia creada
    //post: incializa la instancia con esos datos por default
    public StateCode()
    {
    	codigo="UT";
    	this.setTasa((float) 6.85);
    }
};