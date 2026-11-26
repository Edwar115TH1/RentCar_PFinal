import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Exportarjson {

    private final Gson gson;

    public Exportarjson() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    
    //Informe general completo (Ordenado, agrupado y con totales)
    public String exportarInformeGeneral(AlmacenamientoDatos datos) {
        List<ContratoRenting> contratosActivos = new ArrayList<>();
        List<ContratoRenting> contratosFinalizados = new ArrayList<>();
        float totalIngresos = 0;

        // Agrupamos contratos activos y finalizados, y calculamos el total de ingresos
        for (ContratoRenting contrato : datos.getlistaContratos()) {
            totalIngresos += contrato.getValorTotal();

            if (esContratoActivo(contrato.getPlacaVehiculo(), datos.getlistaVehiculos())) {
                contratosActivos.add(contrato);
            } else {
                contratosFinalizados.add(contrato);
            }
        }

        // Estructura ordenada que Gson convertirá en JSON legible
        InformeRenting informe = new InformeRenting(datos.getListaClientes(),datos.getlistaVehiculos(),contratosActivos,contratosFinalizados,totalIngresos);

        String jsonGenerado = gson.toJson(informe);

        try (FileWriter writer = new FileWriter("informe_general_renting.json")) {
            writer.write(jsonGenerado);
            return "Informe exportado correctamente a 'informe_general_renting.json'.\n" +
                   "Total de ingresos calculados: $" + String.format("%.2f", totalIngresos) + "\n\n" +
                   "--- VISTA PREVIA DEL INFORME JSON ---\n" + jsonGenerado;
        } catch (IOException e) {
            return "X_X Error al exportar el archivo JSON: " + e.getMessage();
        }
    }

   
    // 2. Metodos Sobrecargados por tipo (Cliente, Vehículo, Contrato)
    // Sobrecarga 1: Imprimir/Exportar información de un Cliente
    public String imprimirInformacion(ObjClientes cliente) {
        if (cliente == null) {
            return "X_X El cliente no existe.";
        }
        String jsonCliente = gson.toJson(cliente);
        guardarArchivoIndividual("cliente_" + cliente.getCedula() + ".json", jsonCliente);
        return " >>> INFORMACIÓN DEL CLIENTE (JSON) <<< \n" + jsonCliente;
    }

    // Sobrecarga 2: Imprimir/Exportar información de un Vehículo (Sedán o SUV)
    public String imprimirInformacion(ObjVehiculos vehiculo) {
        if (vehiculo == null) {
            return "X_X El vehículo no existe.";
        }
        String tipo = (vehiculo instanceof ObjCarroSedan) ? "SEDÁN" : "CAMIONETA SUV";
        String jsonVehiculo = gson.toJson(vehiculo);
        guardarArchivoIndividual("vehiculo_" + vehiculo.getPlaca() + ".json", jsonVehiculo);
        return " >>> INFORMACIÓN DEL VEHÍCULO [" + tipo + "] (JSON) <<< \n" + jsonVehiculo;
    }

    // Sobrecarga 3: Imprimir/Exportar información de un Contrato
    public String imprimirInformacion(ContratoRenting contrato) {
        if (contrato == null) {
            return "X_X El contrato no existe.";
        }
        String jsonContrato = gson.toJson(contrato);
        guardarArchivoIndividual("contrato_" + contrato.getIdContrato() + ".json", jsonContrato);
        return " >>> INFORMACIÓN DEL CONTRATO (JSON) <<< \n" + jsonContrato;
    }
    
    //Metodos Auxiliares
    private boolean esContratoActivo(String placaVehiculo, List<ObjVehiculos> listaVehiculos) {
        for (ObjVehiculos v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placaVehiculo)) {
                return v.getEstado().equalsIgnoreCase("alquilado");
            }
        }
        return false;
    }

    private boolean guardarArchivoIndividual(String nombreArchivo, String contenidoJson) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(contenidoJson);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Clase interna POO para estructurar el JSON final de forma limpia y ordenada
    private static class InformeRenting {
        private List<ObjClientes> clientesRegistrados;
        private List<ObjVehiculos> vehiculosRegistrados;
        private List<ContratoRenting> contratosActivos;
        private List<ContratoRenting> contratosFinalizados;
        private float totalIngresosRenting;

        public InformeRenting(List<ObjClientes> clientesRegistrados,
                              List<ObjVehiculos> vehiculosRegistrados,
                              List<ContratoRenting> contratosActivos,
                              List<ContratoRenting> contratosFinalizados,
                              float totalIngresosRenting) {
            this.clientesRegistrados = clientesRegistrados;
            this.vehiculosRegistrados = vehiculosRegistrados;
            this.contratosActivos = contratosActivos;
            this.contratosFinalizados = contratosFinalizados;
            this.totalIngresosRenting = totalIngresosRenting;
        }
    }
}