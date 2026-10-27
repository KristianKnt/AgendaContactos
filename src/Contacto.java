public class Contacto {
  // atributos privados
  private String nombre;
  private String telefono;
  private String email;

  //constructor

  public Contacto(String nombre, String telefono, String email){
    this.nombre= nombre;
    this.telefono = telefono;
    this.email = email;
  }

  //getters

  public String getNombre() {
    return nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getEmail() {
    return email;
  }

  //setters

  // Setters
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // Representación textual del contacto
  @Override
  public String toString() {
    return nombre + " | Telefono: " + telefono
        + " | Email: " + email;
  }

}
