import java.util.Scanner; // Importamos los recursos para utilizar el Scaner
public class Menu {
    
    public static void main(String[] args) { // Unica Clase Principal
        Scanner SC = new Scanner(System.in); // creamos el objeto de la clase Scaner que usaremos.
        Utilidades u = new Utilidades();
        boolean seguir = true;
        while (seguir) {
            switch(u.menuPpal(SC)) {
                case 1:
                    u.SubMenuGestionClientes(SC);
                    break;

                case 2:
                    u.SubMenuGestionVehiculos(SC);
                    break;

                case 3:
                    u.SubMenuGestionContratos(SC);
                    break;

                case 4:
                    System.out.println("pagina en mantenimiento");
                    break;

                case 5:
                    seguir = false;
                    break;

                default:
                    System.out.println("\nEsta opcion no esta disponible por favor valide");
                    break;
            }
        }
    }
}