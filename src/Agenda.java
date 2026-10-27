import java.util.*;

public class Agenda {

  private Map<String, Contacto> contactos;

  private Set<String> grupos;

  private Map<String, Set<String>> contactosPorGrupo;

  private List<Contacto> historial;

  //constructor
  public Agenda(){
    contactos = new TreeMap<>();
    grupos = new TreeSet<>();
    contactosPorGrupo = new TreeMap<>();
    historial = new ArrayList<>();
  }

  public void agregarContacto(Contacto c){
    String nombre  = c.getNombre();

    // validamos que el nombre no exista
    if(contactos.containsKey(nombre)){
      System.out.println("Error : Ya existe un contacto con el nombre '"+ nombre +"'");
      return;
    }
    // Agregar al mapa y al historial
    contactos.put(nombre, c);
    historial.add(c);

    System.out.println("Contacto Agregado : "+nombre);
  }


  public Contacto buscarContacto(String nombre) {
    return contactos.get(nombre);
  }



  public void listarContactos() {

    System.out.println(
        "\n--- LISTA DE CONTACTOS (orden alfabetico) ---"
    );

    if (contactos.isEmpty()) {
      System.out.println("No hay contactos registrados");
      return;
    }

    for (Contacto contacto : contactos.values()) {
      System.out.println(contacto);
    }
  }



  public void listarHistorial() {

    System.out.println(
        "\n--- HISTORIAL (orden de insercion) ---"
    );

    if (historial.isEmpty()) {
      System.out.println("El historial esta vacio");
      return;
    }

    for (Contacto contacto : historial) {
      System.out.println(contacto);
    }
  }

  public boolean eliminarContacto(String nombre) {

    // Comprobar si el contacto existe
    if (!contactos.containsKey(nombre)) {
      return false;
    }

    // Eliminar del mapa
    contactos.remove(nombre);

    // Eliminar del historial
    historial.removeIf(
        contacto -> contacto.getNombre().equals(nombre)
    );

    // Eliminar el nombre de todos los grupos
    for (Set<String> nombresContactos : contactosPorGrupo.values()) {
      nombresContactos.remove(nombre);
    }

    return true;
  }


  public void agregarGrupo(String nombreGrupo) {

    if (grupos.contains(nombreGrupo)) {
      System.out.println(
          "Error: El grupo '" + nombreGrupo + "' ya existe"
      );
      return;
    }

    grupos.add(nombreGrupo);
    contactosPorGrupo.put(nombreGrupo, new TreeSet<>());

    System.out.println("Grupo '" + nombreGrupo + "' creado");
  }

  public void agregarContactoAGrupo(
      String nombreContacto, String nombreGrupo) {

    // Validar que exista el contacto
    if (!contactos.containsKey(nombreContacto)) {
      System.out.println(
          "Error: El contacto '" + nombreContacto + "' no existe"
      );
      return;
    }

    // Validar que exista el grupo
    if (!grupos.contains(nombreGrupo)) {
      System.out.println(
          "Error: El grupo '" + nombreGrupo + "' no existe"
      );
      return;
    }

    // Obtener el conjunto de contactos del grupo
    Set<String> nombresContactos =
        contactosPorGrupo.get(nombreGrupo);

    // Agregar el nombre al grupo
    boolean agregado = nombresContactos.add(nombreContacto);

    if (agregado) {
      System.out.println(
          "Contacto agregado al grupo '" + nombreGrupo + "'"
      );
    } else {
      System.out.println(
          "El contacto '" + nombreContacto
              + "' ya pertenece al grupo '" + nombreGrupo + "'"
      );
    }
  }




  public void listarGrupos() {

    System.out.println("\n--- LISTA DE GRUPOS ---");

    if (grupos.isEmpty()) {
      System.out.println("No hay grupos registrados");
      return;
    }

    for (String grupo : grupos) {
      System.out.println("- " + grupo);
    }
  }



  public void mostrarContactosPorGrupo(String nombreGrupo) {

    // Validar que el grupo exista
    if (!grupos.contains(nombreGrupo)) {
      System.out.println(
          "Error: El grupo '" + nombreGrupo + "' no existe"
      );
      return;
    }

    // Obtener los nombres de los contactos del grupo
    Set<String> nombresContactos =
        contactosPorGrupo.get(nombreGrupo);

    // Comprobar si el grupo esta vacio
    if (nombresContactos.isEmpty()) {
      System.out.println(
          "El grupo '" + nombreGrupo + "' no tiene contactos"
      );
      return;
    }

    System.out.println("\nContactos en '" + nombreGrupo + "':");

    // Buscar y mostrar los objetos Contacto
    for (String nombre : nombresContactos) {
      Contacto contacto = contactos.get(nombre);

      if (contacto != null) {
        System.out.println("- " + contacto);
      }
    }
  }



}
