DELIMITER //
CREATE procedure sp_agregarCliente(in Nombre varchar(50),in Ap_Paterno varchar(50),in Ap_Materno varchar(50),
in Domicilio varchar(200), in Fecha_Nacimiento date )
BEGIN
    -- Sentencia SQL para insertar el nuevo cliente en la tabla clientes
    INSERT INTO clientes (nombre, apellidoP,apellidoM,domicilio,fecha_nacimiento) VALUES (Nombre, Ap_Paterno,Ap_Materno,Domicilio,Fecha_nacimiento);
END //
DELIMITER ;

-- Crear el procedimiento almacenado
DELIMITER //

CREATE PROCEDURE actualizar_cliente(
in Nombre varchar(50),
in Domicilio varchar(200)
)
BEGIN
    -- Sentencia SQL para actualizar el nombre y el correo electrónico del cliente en la tabla clientes
    UPDATE clientes 
    SET  domicilioA=Domicilio
    WHERE nombreA = Nombre;
END//
DELIMITER ;





CREATE TEMPORARY TABLE historial_transacciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cuenta_origen INT,
    monto int,
    fecha TIMESTAMP
);

/*Trigger*/
DELIMITER $$
CREATE TRIGGER historial_transferencias_retiros
AFTER INSERT ON transacciones
FOR EACH ROW
BEGIN
	-- Insertar la información en la tabla temporal historial_transacciones
        INSERT INTO historial_transacciones (id_cuenta_origen, monto, fecha)
        VALUES (NEW.id_cuenta_origen, NEW.monto, NOW());

END;
$$
DELIMITER ;


/* Transaccion*/
START TRANSACTION;
-- 1. Verificar si el cliente existe
SELECT id_cliente INTO @id_cliente FROM clientes WHERE nombre = 'Nombre del Cliente';

-- 2. Si el cliente existe, guardar la cuenta
INSERT INTO cuentas (numero_cuenta,fecha_de_Apertura, saldo, id_cliente)
SELECT numero_cuenta, @id_cliente, 0 FROM clientes
WHERE id_cliente = @id_cliente;

-- 3. Confirmar la transacción
COMMIT;
SELECT 'Cuenta guardada exitosamente' AS mensaje;


