import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilidades {
    private AlmacenamientoDatos datos;
    private Validaciones val;

    public Utilidades(AlmacenamientoDatos datos){
        this.datos = datos;
        this.val = new Validaciones();
    }

    public int menuPpal(Scanner sc){
        System.out.println("\n>>>>>> Bienvenido/a <<<<<<");
        System.out.println(">> SISTEMA DE RENTING DE AUTOS <<");
        System.out.println("¿Que deseas realizar?");
        System.out.println("1. Gestión de clientes");
        System.out.println("2. Gestión de vehiculos");
        System.out.println("3. Gestión de contratos");
        System.out.println("4. Imprimir informe general");
        System.out.println("5. Salir del sistema");

        return val.validarEnteroPositivo(sc, "Seleccione una opción: ");
    }

    public boolean SubMenuGestionClientes(Scanner sc){
      int op;
        do {
            System.out.println("\n>>> 1. GESTIÓN DE CLIENTES <<<");
            System.out.println("1.1 Registrar cliente (Digite 1)");
            System.out.println("1.2 Modificar cliente (Digite 2)");
            System.out.println("1.3 Eliminar cliente (Digite 3)");
            System.out.println("1.4 Buscar cliente (Digite 4)");
            System.out.println("1.5 Volver al menú principal (Digite 5)");

            op = val.validarEnteroPositivo(sc, "Seleccione una opción: ");

            switch(op) {
                case 1:                    
                    System.out.println(registrarCliente(sc));
                    break;
                case 2:                    
                    System.out.println(modificarCliente(sc));
                    break;                    
                case 3:                    
                    System.out.println(eliminarCliente(sc));
                    break;
                case 4:                    
                    System.out.println(buscarCliente(sc));
                    break;
                case 5:
                    System.out.println("\nVolviendo al menú principal...");
                    break;
                default:
                    System.out.println("\nX_X Opción inválida. X_X");
            }
        } while (op != 5);
        return true;    
    }
    
    public ObjClientes buscarClientePorCedula(String cedula) {
        for (ObjClientes c : datos.getListaClientes()) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                return c;
            }
        }
        return null;
    }
    
    private String registrarCliente(Scanner sc) {
        System.out.println("\n >>> REGISTRAR NUEVO CLIENTE <<< ");
        String cedula = val.validarSoloNumerosTexto(sc, "Ingrese la cédula: ");

        // Validamos que no exista un cliente con la misma cédula
        if (buscarClientePorCedula(cedula) != null) {
            return "Mensaje: !!!Ya existe un cliente registrado con la cédula " + cedula + ".";
        }

        String nombre = val.validarSoloLetras(sc, "Ingrese el nombre: ");
        String apellido = val.validarSoloLetras(sc, "Ingrese el apellido: ");
        String telefono = val.validarSoloNumerosTexto(sc, "Ingrese el teléfono: ");
        String direccion = val.validarTextoSinEspeciales(sc, "Ingrese la dirección: ");
        String licencia = val.validarTextoSinEspeciales(sc, "Ingrese el número de licencia de conducción: ");

        ObjClientes nuevoCliente = new ObjClientes(cedula, nombre, apellido, telefono, direccion, licencia);

        if (AgregarCliente(nuevoCliente)) {
            return "Correcto >> Cliente " + nombre + " " + apellido + " registrado exitosamente.";
        }
        return "Mensaje: X_X No se pudo registrar el cliente.";
    }

    private String modificarCliente(Scanner sc) {
        System.out.println("\n >>> MODIFICAR CLIENTE <<< ");
        String cedula = val.validarSoloNumerosTexto(sc, "Ingrese la cédula del cliente a modificar: ");

        ObjClientes cliente = buscarClientePorCedula(cedula);
        if (cliente == null) {
            return "Mensaje >> X_X No se encontró ningún cliente con la cédula " + cedula + ".";
        }

        System.out.println("Cliente encontrado: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("(Nota: La cédula no es modificable)");

        cliente.setNombre(val.validarSoloLetras(sc, "Nuevo nombre |actual: " + cliente.getNombre() + "|: "));
        cliente.setApellido(val.validarSoloLetras(sc, "Nuevo apellido |actual: " + cliente.getApellido() + "|: "));
        cliente.setTelefono(val.validarSoloNumerosTexto(sc, "Nuevo teléfono |actual: " + cliente.getTelefono() + "|: "));
        cliente.setDireccion(val.validarTextoSinEspeciales(sc, "Nueva dirección |actual: " + cliente.getDireccion() + "|: "));
        cliente.setLicencia_Coduccion(val.validarTextoSinEspeciales(sc, "Nueva licencia |actual: " + cliente.getLicencia_Coduccion() + "|: "));

        return ">> Datos del cliente actualizados correctamente.";
    }

    private String eliminarCliente(Scanner sc) {
        System.out.println("\n >>> ELIMINAR CLIENTE <<< ");
        String cedula = val.validarSoloNumerosTexto(sc, "Ingrese la cédula del cliente a eliminar: ");

        // Reutilizamos el método EliminarCliente que además borra los contratos asociados.
        if (EliminarCliente(cedula)) {
            return ">> Cliente con cédula " + cedula + " (y sus contratos asociados) eliminado exitosamente.";
        }
        return "Mensaje >> X_X No se encontró ningún cliente con la cédula " + cedula + ".";
    }

    private String buscarCliente(Scanner sc) {
        System.out.println("\n >>> BUSCAR CLIENTE <<<");
        String cedula = val.validarSoloNumerosTexto(sc, "Ingrese la cédula del cliente a buscar: ");

        ObjClientes c = buscarClientePorCedula(cedula);
        if (c == null) {
            return "X_X No se encontró ningún cliente con la cédula " + cedula + ".";
        }

        return "\n--- DATOS DEL CLIENTE ---\n" +
               "Cedula:    " + c.getCedula() + "\n" +
               "Nombre:    " + c.getNombre() + " " + c.getApellido() + "\n" +
               "Teléfono:  " + c.getTelefono() + "\n" +
               "Dirección: " + c.getDireccion() + "\n" +
               "Licencia:  " + c.getLicencia_Coduccion();
    }

    public boolean SubMenuGestionVehiculos(Scanner sc){
        int op;
        do {
            System.out.println("\n>>> 2. GESTIÓN DE VEHÍCULOS <<<");
            System.out.println("2.1 Registrar vehículo (Digite 1)");
            System.out.println("2.2 Modificar vehículo (Digite 2)");
            System.out.println("2.3 Eliminar vehículo (Digite 3)");
            System.out.println("2.4 Buscar vehículo (Digite 4)");
            System.out.println("2.5 Volver al menú principal (Digite 5)");

            op = val.validarEnteroPositivo(sc, "Seleccione una opción: ");

            switch (op) {
                case 1:
                    System.out.println(registrarVehiculo(sc));
                    break;
                case 2:
                    System.out.println(modificarVehiculo(sc));
                    break;
                case 3:
                    System.out.println(eliminarVehiculo(sc));
                    break;
                case 4:
                    System.out.println(buscarVehiculo(sc));
                    break;
                case 5:
                    System.out.println("\n Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("\nX_X Opción inválida. X_X");
            }
        } while (op != 5);
        return true;
    }

    private String registrarVehiculo(Scanner sc) {
        System.out.println("\n >>> REGISTRAR NUEVO VEHÍCULO <<<");
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Carro Sedán");
        System.out.println("2. Camioneta SUV");

        int tipo = val.validarEnteroPositivo(sc, "Opción: ");
        if (tipo != 1 && tipo != 2) {
            return "X_X Tipo de vehículo no válido. Debe ser 1 (Sedán) o 2 (SUV).";
        }

        String placa = val.validarTextoSinEspeciales(sc, "Ingrese la placa: ").toUpperCase();

        if (buscarVehiculoPorPlaca(placa) != null) {
            return "X_X Error: Ya existe un vehículo registrado con la placa " + placa + ".";
        }

        String marca = val.validarSoloLetras(sc, "Ingrese la marca: ");
        int modelo = val.validarEnteroPositivo(sc, "Ingrese el modelo (año): ");
        float precioDiario = val.validarFloatPositivo(sc, "Ingrese el precio diario: ");

        String estado = "disponible"; // si el vehiculo es nuevo = a disponible ;)
        ObjVehiculos nuevoVehiculo = null;

        if (tipo == 1) {
            String combustible = val.validarOpcionPermitida(sc, "Tipo de combustible (gasolina, diesel, electrico): ",
                    "gasolina", "diesel", "diésel", "electrico", "eléctrico");
            String transmision = val.validarOpcionPermitida(sc, "Transmisión (automatica, manual): ",
                    "automatica", "automática", "manual");

            nuevoVehiculo = new ObjCarroSedan(placa, marca, modelo, precioDiario, estado, combustible, transmision);
        } else {
            String traccion = val.validarOpcionPermitida(sc, "Tracción (4x2, 4x4): ", "4x2", "4x4");
            float maletero = val.validarFloatPositivo(sc, "Capacidad del maletero (en litros): ");

            nuevoVehiculo = new ObjCamionetaSUV(placa, marca, modelo, precioDiario, estado, traccion, maletero);
        }

        if (AgregarVehiculo(nuevoVehiculo)) {
            return "Vehículo con placa " + placa + " registrado exitosamente.";
        }
        return "X_X No se pudo registrar el vehículo.";
    }

    private String modificarVehiculo(Scanner sc) {
        System.out.println("\n >>> MODIFICAR VEHÍCULO <<<");
        String placa = val.validarTextoSinEspeciales(sc, "Ingrese la placa del vehículo a modificar: ").toUpperCase();

        ObjVehiculos v = buscarVehiculoPorPlaca(placa);
        if (v == null) {
            return "X_X No se encontró ningún vehículo con la placa " + placa + ".";
        }

        System.out.println("Vehículo encontrado: " + v.getMarca() + " (" + v.getModelo() + ")");
        System.out.println("(Nota: La placa no es modificable)");

        v.setMarca(val.validarSoloLetras(sc, "Nueva marca (actual: " + v.getMarca() + "): "));
        v.setModelo(val.validarEnteroPositivo(sc, "Nuevo modelo (actual: " + v.getModelo() + "): "));
        v.setPreciodiario(val.validarFloatPositivo(sc, "Nuevo precio diario (actual: " + v.getPreciodiario() + "): "));
        v.setEstado(val.validarOpcionPermitida(sc, "Nuevo estado [disponible / alquilado] (actual: " + v.getEstado() + "): ",
                "disponible", "alquilado"));

        if (v instanceof ObjCarroSedan) {
            ObjCarroSedan sedan = (ObjCarroSedan) v;
            sedan.setTipocombustible(val.validarOpcionPermitida(sc, "Nuevo combustible (actual: " + sedan.getTipocombustible() + "): ",
                    "gasolina", "diesel", "diésel", "electrico", "eléctrico"));
            sedan.setTransmision(val.validarOpcionPermitida(sc, "Nueva transmisión (actual: " + sedan.getTransmision() + "): ",
                    "automatica", "automática", "manual"));
        } else if (v instanceof ObjCamionetaSUV) {
            ObjCamionetaSUV suv = (ObjCamionetaSUV) v;
            suv.setTraccion(val.validarOpcionPermitida(sc, "Nueva tracción (actual: " + suv.getTraccion() + "): ", "4x2", "4x4"));
            suv.setCapacidadmaletero(val.validarFloatPositivo(sc, "Nueva capacidad maletero (actual: " + suv.getCapacidadmaletero() + "): "));
        }

        return "Datos del vehículo actualizados correctamente.";
    }

    private String eliminarVehiculo(Scanner sc) {
        System.out.println("\n>>> ELIMINAR VEHÍCULO <<<");
        String placa = val.validarTextoSinEspeciales(sc, "Ingrese la placa del vehículo a eliminar: ").toUpperCase();

        if (eliminarVehiculo(placa)) {
            return "X_X Vehículo con placa " + placa + " (y sus contratos asociados) eliminado exitosamente.";
        }
        return "X_X No se encontró ningún vehículo con la placa " + placa + ".";
    }

    private String buscarVehiculo(Scanner sc) {
        System.out.println("\n>>> BUSCAR VEHÍCULO <<<");
        String placa = val.validarTextoSinEspeciales(sc, "Ingrese la placa del vehículo a buscar: ").toUpperCase();

        ObjVehiculos v = buscarVehiculoPorPlaca(placa);
        if (v == null) {
            return "X_X No se encontró ningún vehículo con la placa " + placa + ".";
        }

        String infoBase = "\n>>> DATOS DEL VEHÍCULO <<<\n" +
                          "Placa:         " + v.getPlaca() + "\n" +
                          "Marca:         " + v.getMarca() + "\n" +
                          "Modelo:        " + v.getModelo() + "\n" +
                          "Precio Diario: $" + v.getPreciodiario() + "\n" +
                          "Estado:        " + v.getEstado() + "\n";

        if (v instanceof ObjCarroSedan) {
            ObjCarroSedan sedan = (ObjCarroSedan) v;
            return infoBase +
                   "Tipo:          Carro Sedán\n" +
                   "Combustible:   " + sedan.getTipocombustible() + "\n" +
                   "Transmisión:   " + sedan.getTransmision();
        } else if (v instanceof ObjCamionetaSUV) {
            ObjCamionetaSUV suv = (ObjCamionetaSUV) v;
            return infoBase +
                   "Tipo:          Camioneta SUV\n" +
                   "Tracción:      " + suv.getTraccion() + "\n" +
                   "Maletero:      " + suv.getCapacidadmaletero() + " L";
        }
        return infoBase;
    }

    public ObjVehiculos buscarVehiculoPorPlaca(String placa) {
        for (ObjVehiculos v : datos.getlistaVehiculos()) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public boolean SubMenuGestionContratos(Scanner sc){
        int op;
        do {
            System.out.println("\n>>> 3. GESTIÓN DE CONTRATOS DE RENTING <<<");
            System.out.println("3.1 Registrar nuevo contrato (Digite 1)");
            System.out.println("3.2 Modificar contrato (Digite 2)");
            System.out.println("3.3 Finalizar contrato / devolución (Digite 3)");
            System.out.println("3.4 Buscar contrato (Digite 4)");
            System.out.println("3.5 Volver al menú principal (Digite 5)");

            op = val.validarEnteroPositivo(sc, "Seleccione una opción: ");

            switch (op) {
                case 1:
                    System.out.println(registrarContrato(sc));
                    break;
                case 2:
                    System.out.println(modificarContrato(sc));
                    break;
                case 3:
                    System.out.println(finalizarContrato(sc));
                    break;
                case 4:
                    System.out.println(buscarContrato(sc));
                    break;
                case 5:
                    System.out.println("\n Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("\nX_X Opción inválida. X_X");
            }
        } while (op != 5);
        return true;
    }

    private String registrarContrato(Scanner sc) {
        System.out.println("\n >>> REGISTRAR NUEVO CONTRATO <<<");
        String idContrato = val.validarTextoSinEspeciales(sc, "Ingrese el ID del contrato: ").toUpperCase();

        if (buscarContratoPorId(idContrato) != null) {
            return "X_X Error: Ya existe un contrato registrado con el ID " + idContrato + ".";
        }

        String cedula = val.validarSoloNumerosTexto(sc, "Ingrese la cédula del cliente: ");

        ObjClientes cliente = buscarClientePorCedula(cedula);
        if (cliente == null) {
            return "X_X Error: No existe ningún cliente con la cédula " + cedula + ".";
        }

        // Regla HU4: No se permite alquilar más de un vehículo por cliente al mismo tiempo
        if (clienteTieneContratoActivo(cedula)) {
            return "X_X Error: El cliente " + cliente.getNombre() + " ya tiene un vehículo alquilado actualmente.";
        }

        String placa = val.validarTextoSinEspeciales(sc, "Ingrese la placa del vehículo: ").toUpperCase();

        ObjVehiculos vehiculo = buscarVehiculoPorPlaca(placa);
        if (vehiculo == null) {
            return "X_X Error: No existe ningún vehículo con la placa " + placa + ".";
        }

        if (!vehiculo.getEstado().equalsIgnoreCase("disponible")) {
            return "X_X Error: El vehículo con placa " + placa + " no está disponible (Estado: " + vehiculo.getEstado() + ").";
        }

        String fechaInicio = val.validarFecha(sc, "Ingrese la fecha de inicio (AAAA-MM-DD, ej. 2026-11-25): ");
        String fechaFin = val.validarFecha(sc, "Ingrese la fecha de fin (AAAA-MM-DD, ej. 2026-11-30): ");

        int totalDias = val.calcularDiasEntreFechas(fechaInicio, fechaFin);
        if (totalDias <= 0) {
            return "X_X Error: La fecha de fin debe ser posterior a la fecha de inicio (mínimo 1 día de alquiler).";
        }

        float valorTotal = totalDias * vehiculo.getPreciodiario();

        ContratoRenting nuevoContrato = new ContratoRenting(idContrato, cedula, placa, fechaInicio, fechaFin, totalDias, valorTotal);

        if (AgregarContrato(nuevoContrato)) {
            vehiculo.setEstado("alquilado"); // Actualiza estado del vehículo
            return String.format("Correcto >> Contrato %s registrado exitosamente. Total días: %d | Valor total: $%.2f",idContrato, totalDias, valorTotal);
        }
        return "X_X No se pudo registrar el contrato.";
    }

    private String modificarContrato(Scanner sc) {
        System.out.println("\n >>> MODIFICAR CONTRATO <<<");
        String idContrato = val.validarTextoSinEspeciales(sc, "Ingrese el ID del contrato a modificar: ").toUpperCase();

        ContratoRenting contrato = buscarContratoPorId(idContrato);
        if (contrato == null) {
            return "X_X No se encontró ningún contrato con el ID " + idContrato + ".";
        }

        ObjVehiculos vehiculo = buscarVehiculoPorPlaca(contrato.getPlacaVehiculo());
        if (vehiculo == null || !vehiculo.getEstado().equalsIgnoreCase("alquilado")) {
            return "X_X No se puede modificar un contrato que ya fue finalizado.";
        }

        System.out.println("Contrato encontrado (Cliente: " + contrato.getCedulaCliente() + " | Placa: " + contrato.getPlacaVehiculo() + ")");
        System.out.println("(Nota: ID, Cédula y Placa no son modificables)");

        String nuevaFechaInicio = val.validarFecha(sc, "Nueva fecha de inicio (AAAA-MM-DD | actual: " + contrato.getFechaInicio() + "): ");
        String nuevaFechaFin = val.validarFecha(sc, "Nueva fecha de fin (AAAA-MM-DD | actual: " + contrato.getFechaFin() + "): ");

        int nuevosDias = val.calcularDiasEntreFechas(nuevaFechaInicio, nuevaFechaFin);
        if (nuevosDias <= 0) {
            return "X_X Error: La fecha de fin debe ser posterior a la fecha de inicio. No se actualizaron los datos.";
        }

        contrato.setFechaInicio(nuevaFechaInicio);
        contrato.setFechaFin(nuevaFechaFin);
        contrato.setTotalDias(nuevosDias);

        float nuevoValor = nuevosDias * vehiculo.getPreciodiario();
        contrato.setValorTotal(nuevoValor);

        return String.format("Contrato actualizado. Nuevo total de días: %d | Nuevo valor total: $%.2f", nuevosDias, nuevoValor);
    }

    private String finalizarContrato(Scanner sc) {
        System.out.println("\n >>> FINALIZAR CONTRATO (DEVOLUCIÓN DE VEHÍCULO) <<<");
        String idContrato = val.validarTextoSinEspeciales(sc, "Ingrese el ID del contrato a finalizar: ").toUpperCase();

        ContratoRenting contrato = buscarContratoPorId(idContrato);
        if (contrato == null) {
            return "X_X No se encontró ningún contrato con el ID " + idContrato + ".";
        }

        ObjVehiculos vehiculo = buscarVehiculoPorPlaca(contrato.getPlacaVehiculo());
        if (vehiculo == null || vehiculo.getEstado().equalsIgnoreCase("disponible")) {
            return "X_X Este contrato ya había sido finalizado anteriormente.";
        }

        // Liberamos el vehículo dejándolo disponible y mantiene el contrato en el historial como finalizado
        vehiculo.setEstado("disponible");

        return String.format("Contrato %s finalizado. El vehículo %s vuelve a estar DISPONIBLE. Total cobrado: $%.2f",
                idContrato, contrato.getPlacaVehiculo(), contrato.getValorTotal());
    }

    private String buscarContrato(Scanner sc) {
        System.out.println("\n >>> BUSCAR CONTRATO <<<");
        String idContrato = val.validarTextoSinEspeciales(sc, "Ingrese el ID del contrato a buscar: ").toUpperCase();

        ContratoRenting c = buscarContratoPorId(idContrato);
        if (c == null) {
            return "X_X No se encontró ningún contrato con el ID " + idContrato + ".";
        }

        ObjVehiculos v = buscarVehiculoPorPlaca(c.getPlacaVehiculo());
        String estadoContrato = (v != null && v.getEstado().equalsIgnoreCase("alquilado")) ? "ACTIVO" : "FINALIZADO";

        return "\n >>> DATOS DEL CONTRATO <<<\n" +
               "ID Contrato:    " + c.getIdContrato() + "\n" +
               "Estado:         " + estadoContrato + "\n" +
               "Cédula Cliente: " + c.getCedulaCliente() + "\n" +
               "Placa Vehículo: " + c.getPlacaVehiculo() + "\n" +
               "Fecha Inicio:   " + c.getFechaInicio() + "\n" +
               "Fecha Fin:      " + c.getFechaFin() + "\n" +
               "Total Días:     " + c.getTotalDias() + "\n" +
               String.format("Valor Total:    $%.2f", c.getValorTotal());
    }

    public ContratoRenting buscarContratoPorId(String idContrato) {
        for (ContratoRenting c : datos.getlistaContratos()) {
            if (c.getIdContrato().equalsIgnoreCase(idContrato)) {
                return c;
            }
        }
        return null;
    }

    private boolean clienteTieneContratoActivo(String cedula) {
        for (ContratoRenting c : datos.getlistaContratos()) {
            if (c.getCedulaCliente().equalsIgnoreCase(cedula)) {
                ObjVehiculos v = buscarVehiculoPorPlaca(c.getPlacaVehiculo());
                if (v != null && v.getEstado().equalsIgnoreCase("alquilado")) {
                    return true;
                }
            }
        }
        return false;
    }

//Creación de cliente, Vehiculo y contrato (Dinamicos)
    public boolean AgregarCliente(ObjClientes Cliente) {
        if (Cliente == null) {
            return false;
        }
        return datos.getListaClientes().add(Cliente);
    }

    public boolean AgregarVehiculo(ObjVehiculos vehiculo) {
        if (vehiculo == null) {
            return false;
        }
        return datos.getlistaVehiculos().add(vehiculo);
    }

    public boolean AgregarContrato(ContratoRenting contratoRenting) {
        if (contratoRenting == null) {
            return false;
        }
        return datos.getlistaContratos().add(contratoRenting);
    }

    //Elminación de Cliente, Vehiculo y contraro (Aqui debemos Sincronizar)
    public boolean EliminarCliente(String cedula) {
        ObjClientes clienteAeliminar = null;

        for (ObjClientes c : datos.getListaClientes()) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                clienteAeliminar = c;
                break;
            }
        }
        if (clienteAeliminar != null) {
            datos.getListaClientes().remove(clienteAeliminar);
            eliminarContratoXCliente(cedula);
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculo(String placa) {
        ObjVehiculos vehiculoAeliminar = null;

        for (ObjVehiculos v : datos.getlistaVehiculos()) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoAeliminar = v;
                break;
            }
        }

        if (vehiculoAeliminar != null) {
            datos.getlistaVehiculos().remove(vehiculoAeliminar);
            eliminarContratoXVehiculo(placa);
            return true;
        }
        return false;
    }

    public boolean eliminarContrato(String idContrado) {
        ContratoRenting contratoAeliminar = null;

        for (ContratoRenting contrato : datos.getlistaContratos()) {
            if (contrato.getIdContrato().equalsIgnoreCase(idContrado)) {
                contratoAeliminar = contrato;
                break;
            }
        }

        if (contratoAeliminar != null) {
            liberarVehiculo(contratoAeliminar.getPlacaVehiculo());
            datos.getlistaContratos().remove(contratoAeliminar);
            return true;
        }
        return false;
    }

    public int eliminarContratoXCliente(String cedulaCliente) {
        List<ContratoRenting> contratoAelimimnar = new ArrayList<>();

        for (ContratoRenting contrato : datos.getlistaContratos()) {
            if (contrato.getCedulaCliente().equalsIgnoreCase(cedulaCliente)) {
                liberarVehiculo(contrato.getPlacaVehiculo());
                contratoAelimimnar.add(contrato);
            }
        }
        datos.getlistaContratos().removeAll(contratoAelimimnar);
        return contratoAelimimnar.size();
    }

    public int eliminarContratoXVehiculo(String placaVehiculo) {
        List<ContratoRenting> contratoAeliminar = new ArrayList<>();

        for (ContratoRenting contrato : datos.getlistaContratos()) {
            if (contrato.getPlacaVehiculo().equalsIgnoreCase(placaVehiculo)) {
                contratoAeliminar.add(contrato);
            }
        }
        datos.getlistaContratos().removeAll(contratoAeliminar);
        return contratoAeliminar.size();
    }

    private boolean liberarVehiculo(String placa) {
        for (ObjVehiculos v : datos.getlistaVehiculos()) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                v.setEstado("disponible");
                return true;
            }
        }
        return false;
    }
}