
public class PruebaAgenda {

  public static void main(String[] args) {

    Agenda agenda = new Agenda();

    // Crear contactos
    agenda.agregarContacto(
        new Contacto("Carlos Gomez", "3001234567", "carlos@email.com")
    );

    agenda.agregarContacto(
        new Contacto("Ana Perez", "3107654321", "ana@email.com")
    );

    agenda.agregarContacto(
        new Contacto("Beatriz Lopez", "3201234567", "beatriz@email.com")
    );

    // Crear grupos
    agenda.agregarGrupo("Trabajo");
    agenda.agregarGrupo("Amigos");

    // Intentar crear un grupo duplicado
    agenda.agregarGrupo("Trabajo");

    // Asociar contactos
    agenda.agregarContactoAGrupo("Carlos Gomez", "Trabajo");
    agenda.agregarContactoAGrupo("Ana Perez", "Trabajo");
    agenda.agregarContactoAGrupo("Ana Perez", "Amigos");
    agenda.agregarContactoAGrupo("Beatriz Lopez", "Amigos");

    // Listar grupos
    agenda.listarGrupos();

    // Mostrar miembros de cada grupo
    agenda.mostrarContactosPorGrupo("Trabajo");
    agenda.mostrarContactosPorGrupo("Amigos");

    // Probar las validaciones
    agenda.agregarContactoAGrupo("Pedro Lopez", "Trabajo");
    agenda.agregarContactoAGrupo("Carlos Gomez", "Familia");

    // Mostrar grupo vacío
    agenda.agregarGrupo("Familia");
    agenda.mostrarContactosPorGrupo("Familia");

    // Mostrar grupo inexistente
    agenda.mostrarContactosPorGrupo("Universidad");
  }
}
