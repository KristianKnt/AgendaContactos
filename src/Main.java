//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    Contacto contacto = new Contacto(
        "Carlos Gomez",
        "3001234567",
        "carlos@email.com"
    );

    System.out.println(contacto);
    System.out.println(contacto.getNombre());

    contacto.setTelefono("3109876543");

    System.out.println(contacto);
  }
}