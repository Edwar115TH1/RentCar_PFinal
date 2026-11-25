import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Utilidades {
    private AlmacenamientoDatos datos;

    public Utilidades(AlmacenamientoDatos datos){
        this.datos = datos;
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
        System.out.println("Seleccione una opción: ");
      
        int num = sc.nextInt();        
       return num; 
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
            System.out.print("Seleccione una opción: ");

            op = sc.nextInt();

            switch(op) {
                case 1:                    
                    System.out.println("Pagina en construccion 1");
                    break;

                case 2:                    
                    System.out.println("Pagina en construccion 2");
                    break;
                    
                case 3:                    
                    System.out.println("Pagina en construccion 3");
                    break;

                case 4:                    
                    System.out.println("Pagina en construccion 4");
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
    
    public boolean SubMenuGestionVehiculos(Scanner sc){
        int op;
        do {
            System.out.println("\n>>> 2. GESTIÓN DE VEHÍCULOS <<<");
            System.out.println("2.1 Registrar vehículo (Digite 1)");
            System.out.println("2.2 Modificar vehículo (Digite 2)");
            System.out.println("2.3 Eliminar vehículo (Digite 3)");
            System.out.println("2.4 Buscar vehículo (Digite 4)");
            System.out.println("2.5 Volver al menú principal (Digite 5)");
            System.out.print("Seleccione una opción: ");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Pagina en construccion 1");
                    break;
                case 2:
                    System.out.println("Pagina en construccion 2");
                    break;
                case 3:
                    System.out.println("Pagina en construccion 3");
                    break;
                case 4:
                    System.out.println("Pagina en construccion 4");
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

    public boolean SubMenuGestionContratos(Scanner sc){
        int op;
        do {
            System.out.println("\n>>> 3. GESTIÓN DE CONTRATOS DE RENTING <<<");
            System.out.println("3.1 Registrar nuevo contrato (Digite 1)");
            System.out.println("3.2 Modificar contrato (Digite 2)");
            System.out.println("3.3 Finalizar contrato / devolución (Digite 3)");
            System.out.println("3.4 Buscar contrato (Digite 4)");
            System.out.println("3.5 Volver al menú principal (Digite 5)");
            System.out.print("Seleccione una opción: ");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Pagina en construccion 1");
                    break;
                case 2:
                    System.out.println("Pagina en construccion 2");
                    break;
                case 3:
                    System.out.println("Pagina en construccion 3");
                    break;
                case 4:
                    System.out.println("Pagina en construccion 4");
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