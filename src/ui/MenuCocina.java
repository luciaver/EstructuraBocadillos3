package ui;

import java.util.Scanner;

public class MenuCocina {

    public static void menu() {
        String seleccionCocina;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("====================================");
            System.out.println("=          MENÚ COCINA             =");
            System.out.println("====================================");
            System.out.println("1. Listar bocadillos");
            System.out.println("2. Consultar pedidos");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            seleccionCocina = entrada.nextLine();

            switch (seleccionCocina) {
                case "1":
                    System.out.println("Listando bocadillos...");
                    break;
                case "2":
                    System.out.println("Consultando pedidos...");
                    break;
                case "3":
                    System.out.println("Saliendo del menú de cocina...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!seleccionCocina.equals("3"));

        entrada.close();
    }
}
