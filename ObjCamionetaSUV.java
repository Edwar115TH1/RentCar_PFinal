public class ObjCamionetaSUV extends ObjVehiculos {
    String traccion; //4x2, 4x4
    float capacidadmaletero; //En litros

    public ObjCamionetaSUV(){
        super();
    }
    
    public ObjCamionetaSUV(String placa, String marca, int modelo, float precioDiario, String estado, String traccion, float capacidadMaletero){
        super();
        setPlaca(placa);
        setMarca(marca);
        setModelo(modelo);
        setPreciodiario(precioDiario);
        setEstado(estado);        
        this.traccion = traccion;
        this.capacidadmaletero = capacidadMaletero;
        
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public float getCapacidadmaletero() {
        return capacidadmaletero;
    }

    public void setCapacidadmaletero(float capacidadmaletero) {
        this.capacidadmaletero = capacidadmaletero;
    }
    
}