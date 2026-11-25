import java.util.ArrayList;
import java.util.List;

public class AlmacenamientoDatos {
    private List<ObjClientes> listaClientes;
    private List<ObjVehiculos> listaVehiculos;
    private List<ContratoRenting> listaContratos;

    // Creamos lo constructores Sobrecargado y normal
    public AlmacenamientoDatos() {
        this.listaClientes = new ArrayList<>();
        this.listaContratos = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
    }

    public AlmacenamientoDatos(List<ObjClientes> listaClientes, List<ContratoRenting> listaContratos, List<ObjVehiculos> listaVehiculos) {
        this.listaClientes = listaClientes;
        this.listaContratos = listaContratos;
        this.listaVehiculos = listaVehiculos;
    }

    //Metodos Getters para las consultas que haremos mas adelante.
    public List<ObjClientes> getListaClientes() {
            return listaClientes;
    }

    public List<ObjVehiculos> getlistaVehiculos(){
        return listaVehiculos;
    }

    public List<ContratoRenting> getlistaContratos(){
        return listaContratos;
    }
}