import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Validaciones {

    public int validarEnteroPositivo(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        String entrada = sc.nextLine().trim();

        if (entrada.isEmpty()) {
            System.out.println("X_X Error: El campo no puede estar vacío.");
            return validarEnteroPositivo(sc, mensaje);
        }

        try {
            int numero = Integer.parseInt(entrada);
            if (numero <= 0) {
                System.out.println("X_X Error: El número debe ser mayor a cero (positivo).");
                return validarEnteroPositivo(sc, mensaje);
            }
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("X_X Error: Debe ingresar un número entero válido (sin letras ni símbolos).");
            return validarEnteroPositivo(sc, mensaje);
        }
    }

    public float validarFloatPositivo(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        String entrada = sc.nextLine().trim();

        if (entrada.isEmpty()) {
            System.out.println("X_X Error: El campo no puede estar vacío.");
            return validarFloatPositivo(sc, mensaje);
        }

        try {
            float numero = Float.parseFloat(entrada);
            if (numero <= 0) {
                System.out.println("X_X Error: El valor debe ser positivo (mayor a 0).");
                return validarFloatPositivo(sc, mensaje);
            }
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("X_X Error: Debe ingresar un valor numérico válido.");
            return validarFloatPositivo(sc, mensaje);
        }
    }

    public String validarTextoSinEspeciales(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        String texto = sc.nextLine().trim();

        if (texto.isEmpty()) {
            System.out.println("X_X Error: El campo no puede estar vacío.");
            return validarTextoSinEspeciales(sc, mensaje);
        }

        if (!texto.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9\\s-]+$")) {
            System.out.println("X_X Error: No se permiten caracteres especiales (@, #, $, %, !, etc.).");
            return validarTextoSinEspeciales(sc, mensaje);
        }

        return texto;
    }

    public String validarSoloLetras(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        String texto = sc.nextLine().trim();

        if (texto.isEmpty()) {
            System.out.println("X_X Error: El campo no puede estar vacío.");
            return validarSoloLetras(sc, mensaje);
        }

        if (!texto.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            System.out.println("X_X Error: Este campo solo admite letras (sin números ni caracteres especiales).");
            return validarSoloLetras(sc, mensaje);
        }

        return texto;
    }

    public String validarSoloNumerosTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        String texto = sc.nextLine().trim();

        if (texto.isEmpty()) {
            System.out.println("X_X Error: El campo no puede estar vacío.");
            return validarSoloNumerosTexto(sc, mensaje);
        }

        if (!texto.matches("^[0-9]+$")) {
            System.out.println("X_X Error: Debe ingresar únicamente dígitos numéricos positivos.");
            return validarSoloNumerosTexto(sc, mensaje);
        }

        return texto;
    }

    public String validarOpcionPermitida(Scanner sc, String mensaje, String... opcionesValidas) {
        String entrada = validarTextoSinEspeciales(sc, mensaje).toLowerCase();

        for (String opcion : opcionesValidas) {
            if (entrada.equalsIgnoreCase(opcion)) {
                return opcion.toLowerCase();
            }
        }

        System.out.println("X_X Error: Opción no válida. Valores permitidos: " + String.join(", ", opcionesValidas));
        return validarOpcionPermitida(sc, mensaje, opcionesValidas);
    }

    public String validarFecha(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        String entrada = sc.nextLine().trim();

        if (entrada.isEmpty()) {
            System.out.println("X_X Error: La fecha no puede estar vacía.");
            return validarFecha(sc, mensaje);
        }

        try {
            LocalDate fecha = LocalDate.parse(entrada);
            return fecha.toString();
        } catch (DateTimeParseException e) {
            System.out.println("X_X Error: Formato inválido o fecha inexistente. Use el formato numérico AAAA-MM-DD (ej. 2026-11-25).");
            return validarFecha(sc, mensaje);
        }
    }

    public int calcularDiasEntreFechas(String fechaInicio, String fechaFin) {
        try {
            LocalDate inicio = LocalDate.parse(fechaInicio);
            LocalDate fin = LocalDate.parse(fechaFin);
            return (int) ChronoUnit.DAYS.between(inicio, fin);
        } catch (DateTimeParseException e) {
            return -1;
        }
    }
}