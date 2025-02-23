package aerosur;
import aerosur.Pasajero;
import aerosur.Tripulante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class VueloDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/AeroSurDB"; // Nuevo nombre de la base de datos
    private static final String USER = "root";
    private static final String PASSWORD = "anderson";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
     // Método para probar la conexión a la base de datos
    public void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos: " + e.getMessage());
        }
    }
public void guardarVuelo(Vuelo vuelo) {
    String sqlVuelo = "INSERT INTO Vuelos (numeroVuelo, lineaAerea, origen, destino, fechaSalida, fechaIngreso) VALUES (?, ?, ?, ?, ?, ?)";
    String sqlTripulacion = "INSERT INTO Tripulacion (pasaporte, nombre, nacionalidad, puesto, numeroVuelo) VALUES (?, ?, ?, ?, ?)";
    String sqlPasajero = "INSERT INTO Pasajeros (pasaporte, nombre, apellido, nacionalidad, asiento, numeroVuelo) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = getConnection()) {
        try (PreparedStatement stmtVuelo = conn.prepareStatement(sqlVuelo)) {
            stmtVuelo.setString(1, vuelo.getNumeroVuelo());
            stmtVuelo.setString(2, vuelo.getLineaAerea());
            stmtVuelo.setString(3, vuelo.getOrigen());
            stmtVuelo.setString(4, vuelo.getDestino());
            stmtVuelo.setObject(5, vuelo.getFechaSalida());
            stmtVuelo.setObject(6, vuelo.getFechaIngreso());
            stmtVuelo.executeUpdate();
        }

        for (Tripulante tripulante : vuelo.getTripulacion()) {
    try (PreparedStatement stmtTripulacion = conn.prepareStatement(sqlTripulacion)) {
        stmtTripulacion.setString(1, tripulante.getPasaporte());
        stmtTripulacion.setString(2, tripulante.getNombre());
        stmtTripulacion.setString(3, tripulante.getNacionalidad());
        stmtTripulacion.setString(4, tripulante.getPuesto()); // Asegurarse de que el puesto se inserte correctamente
        stmtTripulacion.setString(5, vuelo.getNumeroVuelo());
        stmtTripulacion.executeUpdate();
    }
}
        for (Pasajero pasajero : vuelo.getPasajeros()) {
            if (pasajero.getPasaporte() == null || pasajero.getPasaporte().isEmpty()) {
                throw new IllegalArgumentException("El pasaporte de cada pasajero debe estar completo.");
            }
            try (PreparedStatement stmtPasajero = conn.prepareStatement(sqlPasajero)) {
                stmtPasajero.setString(1, pasajero.getPasaporte());
                stmtPasajero.setString(2, pasajero.getNombre());
                stmtPasajero.setString(3, pasajero.getApellido());
                stmtPasajero.setString(4, pasajero.getNacionalidad());
                stmtPasajero.setInt(5, pasajero.getAsiento());
                stmtPasajero.setString(6, vuelo.getNumeroVuelo());
                stmtPasajero.executeUpdate();
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public boolean verificarPasaporteExistente(String pasaporte) {
    String sql = "SELECT COUNT(*) FROM tripulacion WHERE pasaporte = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AeroSurDB","root", "anderson");
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, pasaporte);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Si el conteo es mayor a 0, el pasaporte ya existe
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


public boolean verificarPasaporteConNombreTripulacion(String pasaporte, String nombre) {
    String sql = "SELECT nombre FROM tripulacion WHERE pasaporte = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AeroSurDB", "root", "anderson");
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, pasaporte);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            String nombreRegistrado = rs.getString("nombre");
            return nombreRegistrado.equalsIgnoreCase(nombre); // Solo permite si el nombre coincide
        } else {
            // Permitir el registro si el pasaporte no existe
            return true;
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // En caso de error, evitar el registro
}
public boolean verificarPasaporteConNombrePasajeros(String pasaporte, String nombre) {
    String sql = "SELECT nombre FROM pasajeros WHERE pasaporte = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AeroSurDB", "root", "anderson");
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, pasaporte);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            String nombreRegistrado = rs.getString("nombre");
            return nombreRegistrado.equalsIgnoreCase(nombre); // Solo permite si el nombre coincide
        } else {
            // Permitir el registro si el pasaporte no existe
            return true;
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // En caso de error, evitar el registro
}




    // Método para buscar un vuelo por número de vuelo
    public Vuelo buscarVueloPorNumero(String numeroVuelo) {
        Vuelo vuelo = null;
        String sqlVuelo = "SELECT * FROM Vuelos WHERE numeroVuelo = ?";
        String sqlTripulacion = "SELECT * FROM Tripulacion WHERE numeroVuelo = ?";
        String sqlPasajeros = "SELECT * FROM Pasajeros WHERE numeroVuelo = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmtVuelo = conn.prepareStatement(sqlVuelo);
             PreparedStatement stmtTripulacion = conn.prepareStatement(sqlTripulacion);
             PreparedStatement stmtPasajeros = conn.prepareStatement(sqlPasajeros)) {

            stmtVuelo.setString(1, numeroVuelo);
            ResultSet rsVuelo = stmtVuelo.executeQuery();

            if (rsVuelo.next()) {
                vuelo = new Vuelo();
                vuelo.setNumeroVuelo(rsVuelo.getString("numeroVuelo"));
                vuelo.setLineaAerea(rsVuelo.getString("lineaAerea"));
                vuelo.setOrigen(rsVuelo.getString("origen"));
                vuelo.setDestino(rsVuelo.getString("destino"));
                vuelo.setFechaSalida(rsVuelo.getTimestamp("fechaSalida").toLocalDateTime());
                vuelo.setFechaIngreso(rsVuelo.getTimestamp("fechaIngreso").toLocalDateTime());

                // Obtener la tripulación
                stmtTripulacion.setString(1, numeroVuelo);
                ResultSet rsTripulacion = stmtTripulacion.executeQuery();
                List<Tripulante> tripulacion = new ArrayList<>();
                while (rsTripulacion.next()) {
                    Tripulante tripulante = new Tripulante();
                    tripulante.setPasaporte(rsTripulacion.getString("pasaporte"));
                    tripulante.setNombre(rsTripulacion.getString("nombre"));
                    tripulante.setNacionalidad(rsTripulacion.getString("nacionalidad"));
                    tripulante.setPuesto(rsTripulacion.getString("puesto"));
                    tripulacion.add(tripulante);
                }
                vuelo.setTripulacion(tripulacion);

                // Obtener los pasajeros
                stmtPasajeros.setString(1, numeroVuelo);
                ResultSet rsPasajeros = stmtPasajeros.executeQuery();
                List<Pasajero> pasajeros = new ArrayList<>();
                while (rsPasajeros.next()) {
                    Pasajero pasajero = new Pasajero();
                    pasajero.setPasaporte(rsPasajeros.getString("pasaporte"));
                    pasajero.setNombre(rsPasajeros.getString("nombre"));
                    pasajero.setApellido(rsPasajeros.getString("apellido"));
                    pasajero.setNacionalidad(rsPasajeros.getString("nacionalidad"));
                    pasajero.setAsiento(rsPasajeros.getInt("asiento"));
                    pasajeros.add(pasajero);
                }
                vuelo.setPasajeros(pasajeros);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vuelo;
    }
    
}
