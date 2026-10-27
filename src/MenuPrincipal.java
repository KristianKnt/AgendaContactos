
import java.util.Scanner;

public class MenuPrincipal {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Agenda agenda = new Agenda();

    boolean continuar = true;

    while (continuar) {

      System.out.println("\n=== AGENDA DE CONTACTOS ===");
      System.out.println("1. Agregar contacto");
      System.out.println("2. Buscar contacto");
      System.out.println("3. Eliminar contacto");
      System.out.println("4. Listar contactos (orden alfabetico)");
      System.out.println("5. Listar historial (orden de insercion)");
      System.out.println("6. Agregar grupo");
      System.out.println("7. Agregar contacto a grupo");
      System.out.println("8. Listar grupos");
      System.out.println("9. Mostrar contactos por grupo");
      System.out.println("10. Salir");
      System.out.print("Elige una opcion: ");

      // Validar que la entrada sea un numero entero
      if (!scanner.hasNextInt()) {
        System.out.println(
            "Opcion invalida, intenta de nuevo"
        );
        scanner.nextLine();
        continue;
      }

      int opcion = scanner.nextInt();
      scanner.nextLine();

      switch (opcion) {

        case 1:
          System.out.println("\n--- AGREGAR CONTACTO ---");

          System.out.print("Nombre: ");
          String nombre = scanner.nextLine();

          System.out.print("Telefono: ");
          String telefono = scanner.nextLine();

          System.out.print("Email: ");
          String email = scanner.nextLine();

          Contacto contacto = new Contacto(
              nombre, telefono, email
          );

          agenda.agregarContacto(contacto);
          break;

        case 2:
          System.out.print("Nombre a buscar: ");
          String nombreBuscar = scanner.nextLine();

          Contacto encontrado =
              agenda.buscarContacto(nombreBuscar);

          if (encontrado != null) {
            System.out.println(encontrado);
          } else {
            System.out.println(
                "Contacto no encontrado: " + nombreBuscar
            );
          }
          break;

        case 3:
          System.out.print("Nombre a eliminar: ");
          String nombreEliminar = scanner.nextLine();

          boolean eliminado =
              agenda.eliminarContacto(nombreEliminar);

          if (eliminado) {
            System.out.println(
                "Contacto eliminado: " + nombreEliminar
            );
          } else {
            System.out.println(
                "Contacto no encontrado: " + nombreEliminar
            );
          }
          break;

        case 4:
          agenda.listarContactos();
          break;

        case 5:
          agenda.listarHistorial();
          break;

        case 6:
          System.out.print("Nombre del grupo: ");
          String nombreGrupo = scanner.nextLine();

          agenda.agregarGrupo(nombreGrupo);
          break;

        case 7:
          System.out.print("Nombre del contacto: ");
          String nombreContacto = scanner.nextLine();

          System.out.print("Nombre del grupo: ");
          String grupo = scanner.nextLine();

          agenda.agregarContactoAGrupo(
              nombreContacto, grupo
          );
          break;

        case 8:
          agenda.listarGrupos();
          break;

        case 9:
          System.out.print("Nombre del grupo: ");
          String grupoConsultar = scanner.nextLine();

          agenda.mostrarContactosPorGrupo(
              grupoConsultar
          );
          break;

        case 10:
          System.out.println("Saliendo de la agenda...");
          continuar = false;
          break;

        default:
          System.out.println(
              "Opcion invalida, intenta de nuevo"
          );
      }
    }

    scanner.close();
  }
}