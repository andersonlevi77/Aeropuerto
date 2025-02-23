package aerosur;
import aerosur.Pasajero;
import aerosur.Tripulante;
import java.time.LocalDateTime;
import java.util.List;

public class Vuelo {
    private String numeroVuelo;
    private String lineaAerea;
    private String origen;
    private String destino;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaIngreso;
    private List<Tripulante> tripulacion;
    private List<Pasajero> pasajeros;

    // Constructor vacío
    public Vuelo() {}

    // Constructor con parámetros
    public Vuelo(String numeroVuelo, String lineaAerea, String origen, String destino,
                 LocalDateTime fechaSalida, LocalDateTime fechaIngreso,
                 List<Tripulante> tripulacion, List<Pasajero> pasajeros) {
        this.numeroVuelo = numeroVuelo;
        this.lineaAerea = lineaAerea;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaIngreso = fechaIngreso;
        this.tripulacion = tripulacion;
        this.pasajeros = pasajeros;
    }

    // Getters y setters
    public String getNumeroVuelo() { return numeroVuelo; }
    public void setNumeroVuelo(String numeroVuelo) { this.numeroVuelo = numeroVuelo; }

    public String getLineaAerea() { return lineaAerea; }
    public void setLineaAerea(String lineaAerea) { this.lineaAerea = lineaAerea; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public LocalDateTime getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDateTime fechaSalida) { this.fechaSalida = fechaSalida; }

    public LocalDateTime getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDateTime fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public List<Tripulante> getTripulacion() { return tripulacion; }
    public void setTripulacion(List<Tripulante> tripulacion) { this.tripulacion = tripulacion; }

    public List<Pasajero> getPasajeros() { return pasajeros; }
    public void setPasajeros(List<Pasajero> pasajeros) { this.pasajeros = pasajeros; }
}
