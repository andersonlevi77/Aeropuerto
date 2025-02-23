package aerosur;

/**
 *
 * @author Anderson
 */
public class Tripulante {
    private String pasaporte;
    private String nombre;
    private String nacionalidad;
    private String puesto;

    // Constructor vacío
    public Tripulante() {}

    // Constructor con parámetros
    public Tripulante(String pasaporte, String nombre, String nacionalidad, String puesto) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.puesto = puesto;
    }

    // Getters y setters
    public String getPasaporte() { return pasaporte; }
    public void setPasaporte(String pasaporte) { this.pasaporte = pasaporte; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
}
