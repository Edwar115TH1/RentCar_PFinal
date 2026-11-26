public class ObjCarroSedan extends ObjVehiculos{
    private String tipocombustible; //gasolina, diésel o eléctrico
    private String transmision; //automática o manual
    
    public ObjCarroSedan(){ // Creamos el contrucor de la clase objCarroSedan y llamamos al metodo Super para poder heredar todos los atributos desde sus Sets
        super();
    }

    //Sobrecargamos el contructor para tener mas "flexibilidad"
    public ObjCarroSedan(String placa, String marca, int modelo, float preciodiario, String estado, String tipocombustible, String transmision){
        super();
        setPlaca(placa);
        setMarca(marca);
        setModelo(modelo);
        setPreciodiario(preciodiario);
        setEstado(estado);

        this.tipocombustible = tipocombustible;
        this.transmision = transmision;

    }

    public String getTipocombustible() {
        return tipocombustible;
    }

    public void setTipocombustible(String tipocombustible) {
        this.tipocombustible = tipocombustible;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    
}