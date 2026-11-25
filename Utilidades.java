import java.util.Scanner;


public class Utilidades {
    
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

    public boolean  SubMenuGestionClientes(Scanner sc){
      int op = 0;
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
        int op = 0;
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
        int op = 0;
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
}