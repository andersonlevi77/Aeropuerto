package aerosur;

/**
 *
 * @author Anderson
 */
public class Pasajero {
    private String pasaporte;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private int asiento;

    // Constructor vacío
    public Pasajero() {}

    // Constructor con parámetros
    public Pasajero(String pasaporte, String nombre, String apellido, String nacionalidad, int asiento) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.asiento = asiento;
    }

    // Getters y setters
    public String getPasaporte() { return pasaporte; }
    public void setPasaporte(String pasaporte) { this.pasaporte = pasaporte; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public int getAsiento() { return asiento; }
    public void setAsiento(int asiento) { this.asiento = asiento; }
}
