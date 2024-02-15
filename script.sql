CREATE DATABASE IF NOT EXISTS Banco;
USE Banco;

CREATE TABLE Clientes(
ID_Cliente int PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(50),
Ap_Paterno VARCHAR(50),
Ap_Materno VARCHAR(50),
Domicilio VARCHAR(200),
Fecha_Nacimiento DATE,
Edad INT
);

DELIMITER //

CREATE TRIGGER calcular_edad
BEFORE INSERT ON Clientes
FOR EACH ROW
BEGIN
    SET NEW.Edad = YEAR(CURDATE()) - YEAR(NEW.Fecha_Nacimiento) - 
                   (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(NEW.Fecha_Nacimiento, '%m%d'));
END//

DELIMITER ;


CREATE TABLE Cuentas(
Numero_Cuenta INT PRIMARY KEY AUTO_INCREMENT,
Fecha_de_Apertura DATE,
Saldo INT,
ID_Cliente INT, 
FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente)
);

CREATE TABLE Transacciones(
ID_Transaccion INT PRIMARY KEY AUTO_INCREMENT,
Fecha DATE,
Monto INT,
Numero_de_cuenta_destino INT,
FOREIGN KEY (Numero_de_cuenta_destino) REFERENCES Cuentas(Numero_Cuenta)
);

CREATE TABLE RetirosSinCuenta(
ID_RetiroSinCuenta INT PRIMARY KEY AUTO_INCREMENT,
Numero_Cuenta INT,
Folio_de_operacion INT,
 ESTADOS VARCHAR(50) check(ESTADOS in("pendiente","concluido","en proceso")),
Contraseña VARCHAR(50),
Fecha DATE,
FOREIGN KEY (Numero_Cuenta ) REFERENCES Cuentas(Numero_Cuenta)
)
