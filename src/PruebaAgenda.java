
public class PruebaAgenda {

  public static void main(String[] args) {

    Agenda agenda = new Agenda();

    Contacto carlos = new Contacto(
        "Carlos Gomez",
        "3001234567",
        "carlos@email.com"
    );

    Contacto ana = new Contacto(
        "Ana Perez",
        "3107654321",
        "ana@email.com"
    );

    agenda.agregarContacto(carlos);
    agenda.agregarContacto(ana);

    // Intentar registrar un nombre duplicado
    Contacto carlosDuplicado = new Contacto(
        "Carlos Gomez",
        "3111111111",
        "otro@email.com"
    );

    agenda.agregarContacto(carlosDuplicado);

    // Buscar un contacto existente
    System.out.println(
        agenda.buscarContacto("Ana Perez")
    );

    // Buscar un contacto inexistente
    System.out.println(
        agenda.buscarContacto("Pedro Lopez")
    );
  }
}
