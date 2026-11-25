// No se permite alquilar más de un vehículo por cliente al mismo tiempo.
public class ContratoRenting {
    private String idContrato;    //No modificable
    private String cedulaCliente; //No modificable
    private String placaVehiculo; //No modificable
    private String fechaInicio;   //Modificable
    private String fechaFin;      //Modificable
    private int totalDias;        //"Duracion" - Modificable
    private float valorTotal; 

    public ContratoRenting(){

    }

    public ContratoRenting(String idcontrato, String cedulacliente, String placavehiculo, String fechainicio, String fechafin, int totaldias, float valortotal){
        this.idContrato = idcontrato;
        this.cedulaCliente = cedulacliente;
        this.placaVehiculo = placavehiculo;
        this.fechaInicio = fechainicio;
        this.fechaFin = fechafin;
        this.totalDias = totaldias;
        this.valorTotal = valortotal;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTotalDias() {
        return totalDias;
    }

    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}