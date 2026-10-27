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



}
