package servicios;

import models.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BocadilloServicio {
    private static ArrayList<Bocadillo> listaBocadillos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static List<Bocadillo> listarTodos() {
        return listaBocadillos;
    }
    public static Bocadillo buscarBocadillo(int id) {
        for (Bocadillo b : listaBocadillos) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }


    public static void insertarBocadillo(Bocadillo bocadillo) {
        listaBocadillos.add(bocadillo);
    }

    public static void eliminarBocadillo(int id) {
        for (int i = 0; i < listaBocadillos.size(); i++) {
            Bocadillo b = listaBocadillos.get(i);
            if (b.getId() == id) {
                listaBocadillos.remove(i);
                System.out.println("Bocadillo eliminado.");
                return;
            }
        }
        System.out.println("No se encontró ningún bocadillo con ese ID.");
    }
    public static void modificarBocadillo(int id) {
        Bocadillo b = buscarBocadillo(id);
        if (b == null) {
            System.out.println("No se encontró ningún bocadillo con ese ID.");
            return;
        }

        System.out.println("Modificando el bocadillo : " + b);

        System.out.print("Nuevo nombre: ");
        b.setNombre(scanner.nextLine());

        System.out.print("Nueva descripción: ");
        b.setDescrip(scanner.nextLine());

        System.out.print("Nueva ciudad popular: ");
        b.setCiudadPopular(scanner.nextLine());

        System.out.print("Nuevos ingredientes (coma separados): ");
        b.setIngredientes(scanner.nextLine().split(",\\s*"));

        System.out.print("Nuevos alérgenos (coma separados): ");
        b.setAlergenos(scanner.nextLine().split(",\\s*"));

        System.out.print("Nuevo precio: ");
        b.setPrecio(Double.parseDouble(scanner.nextLine()));

        System.out.print("¿Es caliente? (sí/no): ");
        String calienteStr = scanner.nextLine().toLowerCase();
        b.setCaliente(calienteStr.equals("sí") || calienteStr.equals("si"));

        System.out.println("Bocadillo modificado correctamente.");
    }



    public static void gestionarBocadillosAdmin() {
        while (true) {
            System.out.println("\n--- Gestión de Bocadillos ---");
            System.out.println("1. Ver bocadillos");
            System.out.println("2. Buscar bocadillos");
            System.out.println("3. Añadir bocadillo");
            System.out.println("4. Eliminar bocadillo");
            System.out.println("5. Modificar bocadillo");
            System.out.println("6. Volver");
            System.out.print("Seleccione opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    List<Bocadillo> lista = listarTodos();
                    if (lista.isEmpty()) {
                        System.out.println("No hay bocadillos.");
                    } else {
                        for (Bocadillo b : lista) {
                            System.out.println(b);
                        }
                    }
                case "2":
                    System.out.print("ID del bocadillo a buscar: ");
                    int idBuscar = Integer.parseInt(scanner.nextLine());
                     Bocadillo encontrado = buscarBocadillo(idBuscar);
                     if (encontrado != null) {
                    System.out.println("Bocadillo encontrado:\n" + encontrado);
                      } else {
                    System.out.println("No se encontró ningún bocadillo con ese ID.");
                      }
                    break;

                case "3":
                    System.out.print("ID: ");
                    String idTexto = scanner.nextLine();
                    int id = Integer.parseInt(idTexto);
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ciudad Popular: ");
                    String ciudad = scanner.nextLine();
                    System.out.print("Ingredientes: ");
                    String ingredientesTexto = scanner.nextLine();
                    String[] ingredientes = ingredientesTexto.split(", ");
                    System.out.print("Alérgenos: ");
                    String alergenosTexto = scanner.nextLine();
                    String[] alergenos = alergenosTexto.split(", ");
                    System.out.print("Precio: ");
                    String precioTexto = scanner.nextLine();
                    double precio = Double.parseDouble(precioTexto);
                    System.out.print("¿Es caliente? (sí/no): ");
                    String calienteStr = scanner.nextLine().toLowerCase();
                    boolean caliente = calienteStr.equals("sí") || calienteStr.equals("si");

                    Bocadillo nuevo = new Bocadillo(id, nombre, descripcion, ciudad, LocalDate.now(), ingredientes,  alergenos, precio, caliente);
                    insertarBocadillo(nuevo);
                    System.out.println("Bocadillo añadido.");
                    break;

                case "4":
                    System.out.print("ID del bocadillo a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    int idNumerico = Integer.parseInt(idEliminar);
                    eliminarBocadillo(idNumerico);
                    System.out.println("Bocadillo eliminado.");
                    break;
                case "5":
                    System.out.print("ID del bocadillo a modificar: ");
                    int idModificar = Integer.parseInt(scanner.nextLine());
                    modificarBocadillo(idModificar);
                    break;


                case "6":
                    System.out.println("Volviendo al menú anterior...");
                    return;

                default:
                    System.out.println("Opción no válida.");

            }
        }
    }

   public static void volcarBocadillos() {
        try {
            FileOutputStream fos = new FileOutputStream("src/persistencia/Bocadillo.dat", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new Bocadillo(
                    1,
                    "Bocadillo de Jamón",
                    "Clásico bocadillo español con jamón serrano.",
                    "Madrid",
                    LocalDate.now(),
                    new String[]{"Pan", "Jamón serrano", "Tomate", "Aceite de oliva"},
                    new String[]{"Gluten"},
                    3.50,
                    false
            ));
            oos.writeObject(new Bocadillo(
                    2,
                    "Bocadillo Vegetal",
                    "Fresco y saludable, ideal para vegetarianos.",
                    "Barcelona",
                    LocalDate.now(),
                    new String[]{"Pan integral", "Lechuga", "Tomate", "Huevo duro", "Mayonesa"},
                    new String[]{"Gluten", "Huevo"},
                    4.20,
                    false
            ));
            oos.writeObject(new Bocadillo(
                    3,
                    "Bocadillo de Lomo con Queso",
                    "Lomo caliente con queso fundido.",
                    "Valencia",
                    LocalDate.now(),
                    new String[]{"Pan", "Lomo de cerdo", "Queso manchego"},
                    new String[]{"Gluten", "Lácteos"},
                    4.80,
                    true
            ));
            oos.writeObject(new Bocadillo(
                    4,
                    "Bocadillo de Tortilla",
                    "Tortilla de patata casera en pan crujiente.",
                    "Sevilla",
                    LocalDate.now(),
                    new String[]{"Pan", "Tortilla de patata"},
                    new String[]{"Gluten", "Huevo"},
                    3.90,
                    true
            ));
            oos.writeObject(new Bocadillo(
                    5,
                    "Bocadillo de Atún",
                    "Ligero y sabroso, con atún y aceitunas.",
                    "Bilbao",
                    LocalDate.now(),
                    new String[]{"Pan", "Atún", "Aceitunas", "Lechuga", "Mahonesa"},
                    new String[]{"Gluten", "Pescado", "Huevo"},
                    4.00,
                    false
            ));
            oos.writeObject(new Bocadillo(
                    1,
                    "Bocadillo de Nutella",
                    "Pan tierno con crema de cacao.",
                    "Alicante",
                    LocalDate.now(),
                    new String[]{"Pan", "Nutella"},
                    new String[]{"Gluten", "Frutos secos", "Lácteos"},
                    2.20,
                    false
            ));

            oos.writeObject(new Bocadillo(
                    2,
                    "Bocadillo Serrano",
                    "Jamón serrano con tomate y aceite.",
                    "Elche",
                    LocalDate.of(2025, 5, 15),
                    new String[]{"Pan", "Jamón Serrano", "Tomate", "Aceite"},
                    new String[]{"Gluten"},
                    3.20,
                    false
            ));

            oos.writeObject(new Bocadillo(
                    3,
                    "Bocadillo de Tortilla Española",
                    "Clásico de tortilla de patatas casera.",
                    "Madrid",
                    LocalDate.of(2025, 5, 10),
                    new String[]{"Pan", "Tortilla de Patatas"},
                    new String[]{"Gluten", "Huevo"},
                    3.50,
                    true
            ));

            oos.writeObject(new Bocadillo(
                    4,
                    "Bocadillo de Bacon y Queso",
                    "Bacon crujiente con queso fundido.",
                    "Murcia",
                    LocalDate.now().minusDays(1),
                    new String[]{"Pan", "Bacon", "Queso"},
                    new String[]{"Gluten", "Lácteos"},
                    3.60,
                    true
            ));

            oos.writeObject(new Bocadillo(
                    5,
                    "Bocadillo de Atún",
                    "Ligero y sabroso, con atún y aceitunas.",
                    "Bilbao",
                    LocalDate.of(2025, 5, 20),
                    new String[]{"Pan", "Atún", "Aceitunas", "Lechuga", "Mahonesa"},
                    new String[]{"Gluten", "Pescado", "Huevo"},
                    4.00,
                    false
            ));

            oos.writeObject(new Bocadillo(
                    6,
                    "Bocadillo de Magra con Tomate",
                    "Carne de magra con tomate frito.",
                    "Almoradí",
                    LocalDate.now(),
                    new String[]{"Pan", "Magra", "Tomate frito"},
                    new String[]{"Gluten"},
                    3.40,
                    true
            ));

            oos.writeObject(new Bocadillo(
                    7,
                    "Bocadillo de York y Queso",
                    "Jamón de york con queso fundido.",
                    "Valencia",
                    LocalDate.of(2025, 5, 18),
                    new String[]{"Pan", "Jamón York", "Queso"},
                    new String[]{"Gluten", "Lácteos"},
                    3.00,
                    true
            ));

            oos.writeObject(new Bocadillo(
                    8,
                    "Bocadillo de Salchichón",
                    "Salchichón ibérico con un toque de aceite.",
                    "Cartagena",
                    LocalDate.now().minusDays(2),
                    new String[]{"Pan", "Salchichón", "Aceite"},
                    new String[]{"Gluten"},
                    2.80,
                    false
            ));

            oos.writeObject(new Bocadillo(
                    9,
                    "Bocadillo de Tomate y Aceite",
                    "Sencillo y saludable con tomate natural.",
                    "Granada",
                    LocalDate.of(2025, 5, 12),
                    new String[]{"Pan", "Tomate", "Aceite de oliva"},
                    new String[]{"Gluten"},
                    2.30,
                    false
            ));

            oos.writeObject(new Bocadillo(
                    10,
                    "Bocadillo de Queso Azul",
                    "Queso azul con nueces y miel.",
                    "Barcelona",
                    LocalDate.now(),
                    new String[]{"Pan", "Queso Azul", "Nueces", "Miel"},
                    new String[]{"Gluten", "Lácteos", "Frutos secos"},
                    4.50,
                    true
            ));


            fos.close();
            oos.flush();
            oos.close();

        } catch (EOFException e) {
            e.getMessage();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }

    }

    public static ArrayList<Bocadillo> obtenerBocadillos() {
        try {
            FileInputStream fis = new FileInputStream("src/persistencia/Bocadillo.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Bocadillo b;
            while (true) {
                b = (Bocadillo) ois.readObject();
                listaBocadillos.add(b);
            }
        } catch (FileNotFoundException | EOFException e) {
            //System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaBocadillos;
    }

}
