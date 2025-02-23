CREATE DATABASE AeropuertoDB;

USE AeropuertoDB;

-- Tabla de Vuelos
CREATE TABLE Vuelos (
    id_vuelo INT AUTO_INCREMENT PRIMARY KEY,
    lineaAerea VARCHAR(100),
    origen VARCHAR(100),
    destino VARCHAR(100),
    fechaSalida DATETIME,
    fechaIngreso DATETIME,
    numeroVuelo VARCHAR(50)
);

-- Tabla de Tripulación
CREATE TABLE Tripulacion (
    id_tripulante INT AUTO_INCREMENT PRIMARY KEY,
    id_vuelo INT,
    pasaporte VARCHAR(50),
    nombre VARCHAR(100),
    nacionalidad VARCHAR(50),
    puesto VARCHAR(50),
    FOREIGN KEY (id_vuelo) REFERENCES Vuelos(id_vuelo) ON DELETE CASCADE
);

-- Tabla de Pasajeros
CREATE TABLE Pasajeros (
    id_pasajero INT AUTO_INCREMENT PRIMARY KEY,
    id_vuelo INT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    nacionalidad VARCHAR(50),
    numero_asiento INT,
    pasaporte VARCHAR(50),
    FOREIGN KEY (id_vuelo) REFERENCES Vuelos(id_vuelo) ON DELETE CASCADE
);