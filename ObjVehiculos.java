public class ObjVehiculos {
    private String placa; // sin caracteres especiales
    private String marca; // sin números ni símbolos
    private int modelo;
    private float preciodiario;
    private String estado; // disponible / alquilado.

    public ObjVehiculos(){

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public float getPreciodiario() {
        return preciodiario;
    }

    public void setPreciodiario(float preciodiario) {
        this.preciodiario = preciodiario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}