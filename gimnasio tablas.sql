CREATE TABLE administrador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cedula VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE plan_membresia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    duracion INT NOT NULL 
);

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cedula VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    plan_id INT NOT NULL,
    fecha_pago DATE NOT NULL,
    monto_pago DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (plan_id) REFERENCES plan_membresia(id)
);

CREATE TABLE entrenador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cedula VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

CREATE TABLE asistencia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE clase (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL
);

CREATE TABLE horario_clase (
    id INT AUTO_INCREMENT PRIMARY KEY,
    clase_id INT NOT NULL,
    entrenador_id INT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    FOREIGN KEY (clase_id) REFERENCES clase(id),
    FOREIGN KEY (entrenador_id) REFERENCES entrenador(id)
);

SELECT * FROM administrador;
ALTER TABLE entrenador CHANGE COLUMN email correo VARCHAR(255) NOT NULL;



SELECT * FROM entrenador;

SELECT * FROM cliente;

SELECT * FROM administrador;
ALTER TABLE entrenador ADD COLUMN email VARCHAR(100);
SELECT * FROM entrenador;
ALTER TABLE entrenador CHANGE COLUMN correo email VARCHAR(100) NOT NULL;

ALTER TABLE cliente 
ADD objetivo VARCHAR(255);

SELECT * FROM cliente;
DESCRIBE Asistencia;
ALTER TABLE Asistencia ADD cliente_cedula VARCHAR(80); 
ALTER TABLE Asistencia ADD hora_entrada TIME; 
ALTER TABLE Asistencia MODIFY cliente_id INT DEFAULT NULL;

SELECT * FROM Asistencia;
#DELETE * FROM <nombre-tabla>.  borrar datos de la tabla