USE BEEL_BALAM;

CREATE PROCEDURE CREAR_USUARIO(
--datos usuario
@u_nombre VARCHAR(25),
@u_contraseña VARCHAR (20),
@u_correo VARCHAR (35),
@u_numCelular VARCHAR (14),
@u_ptos INT,
--datos tarjeta
@t_cvc INT,
@t_primerNombre VARCHAR(15),
@t_segundoNombre VARCHAR(15),
@t_primerApellido VARCHAR(15),
@t_segundoApellido VARCHAR(15),
@t_fechaVigencia INT,
@t_numero VARCHAR (17)
)
AS
BEGIN
	IF EXISTS (SELECT NOMBRE_U FROM USUARIO WHERE NOMBRE_U = @u_nombre)
		BEGIN 
				SELECT 'ESA USUARIO YA ESTÁ REGISTRADO';
		END 
	ELSE
	BEGIN 
		IF EXISTS (SELECT NUM_TARJETA FROM TARJETA WHERE NUM_TARJETA = @t_numero)
			BEGIN 
				SELECT 'ESA TARJETA YA ESTÁ REGISTRADA';
			END 
		ELSE
			BEGIN 
				INSERT INTO TARJETA
				VALUES (@t_cvc,@t_primerNombre,@t_segundoNombre,@t_primerApellido,@t_segundoApellido,@t_fechaVigencia,@t_numero);
			END
		INSERT INTO USUARIO
		VALUES (@u_nombre,@u_contraseña,@u_correo,@u_numCelular,@u_ptos,@t_numero); 
	END 
END

--pruebas ejecucion 
EXECUTE CREAR_USUARIO 'juanito','12decd23','juan@dsnd','99823743',0,123,'juan',NULL,'perez',NULL,1290,'0983648';
EXECUTE CREAR_USUARIO 'luisito','12decd23','juan@dsnd','99823743',0,123,'juan',NULL,'perez',NULL,1290,'1234567890123456';
EXECUTE CREAR_USUARIO 'luisito','12decd23','juan@dsnd','99823743',0,123,'juan',NULL,'perez',NULL,1290,'1234567890123456';

DROP PROCEDURE ELIMINAR_USUARIO;

CREATE PROCEDURE ELIMINAR_USUARIO(
	--usuario
	@ub_nombre VARCHAR(25),
	--tarjeta
	@tb_numero VARCHAR (17)
)
AS
BEGIN
	DECLARE @auxIdCliente INT;
	SELECT @auxIdCliente = ID_CLIENTE FROM RESERVA WHERE NOMBRE_U=@ub_nombre;

	DELETE FROM RESERVA WHERE NOMBRE_U=@ub_nombre;
	SELECT 'SE HA ELIMINADO CORRECTAMENTE LA RESERVA';

	DELETE FROM CLIENTE WHERE ID_CLIENTE=@auxIdCliente;
	SELECT 'SE HA ELIMINADO CORRECTAMENTE AL CLIENTE';

	DELETE FROM USUARIO WHERE NOMBRE_U=@ub_nombre;
	SELECT 'SE HA ELIMINADO CORRECTAMENTE EL USUARIO';

	DECLARE @numVecesTarj INT;
	SELECT @numVecesTarj = COUNT(NUM_TARJETA) FROM TARJETA WHERE NUM_TARJETA=@tb_numero;
	IF @numVecesTarj>=2
		BEGIN
			SELECT 'LA TARJETA LA POSEEN DOS USUARIOS';
		END
	ELSE 
		BEGIN
			DELETE FROM TARJETA WHERE NUM_TARJETA=@tb_numero;
			SELECT 'SE HA ELIMINADO CORRECTAMENTE LA TARJETA';
		END

END

--PRUEBAS 
SELECT * FROM USUARIO;
SELECT * FROM TARJETA;
SELECT * FROM CLIENTE;
SELECT * FROM RESERVA;
EXECUTE ELIMINAR_USUARIO 'adalcv','6734567890123456';
EXECUTE ELIMINAR_USUARIO 'anahisc','1134567890123456';


DROP PROCEDURE CANCELAR_RESERVA;

CREATE PROCEDURE CANCELAR_RESERVA(
	@cod_reserva INT	
)
AS
BEGIN
	DECLARE @auxIdCliente INT;
	SELECT @auxIdCliente = ID_CLIENTE FROM RESERVA WHERE COD_R=@cod_reserva;

	DECLARE @auxNombreU VARCHAR(25);
	SELECT @auxNombreU = NOMBRE_U FROM RESERVA WHERE COD_R=@cod_reserva;

	DECLARE @auxPtosAcum INT;
	SELECT @auxPtosAcum = PTOS_ACUM_U FROM USUARIO WHERE NOMBRE_U=@auxNombreU;

	DELETE FROM RESERVA WHERE COD_R=@cod_reserva;
	SELECT 'SE HA BORRADO CORRECTAMENTE LA RESERVA';
	UPDATE USUARIO SET PTOS_ACUM_U=(PTOS_ACUM_U-@auxPtosAcum) WHERE NOMBRE_U=@auxNombreU;
	SELECT 'SE HAN MODIFICADO CORRECTAMENTE LOS PUNTOS ACUMULADOS';
	DELETE FROM CLIENTE WHERE ID_CLIENTE=@auxIdCliente; 
	SELECT 'SE HA BORRADO CORRECTAMENTE AL CLIENTE';	
END 

--HACIENDO PRUEBAS DE EJECUCIÓN :D 
SELECT * FROM RESERVA;
SELECT * FROM USUARIO;
UPDATE USUARIO SET PTOS_ACUM_U=100 WHERE NOMBRE_U='itzeeelcava';
SELECT * FROM CLIENTE;

EXECUTE CANCELAR_RESERVA '9876';

--PARA UPDATE EN CASCADA
ALTER TABLE RESERVA WITH CHECK ADD  CONSTRAINT [FK_RESERVA-USUARIO] FOREIGN KEY(NOMBRE_U)
REFERENCES USUARIO (NOMBRE_U)
ON UPDATE CASCADE
GO

CREATE PROCEDURE EDITAR_USUARIO(
--falta validar el newNombre, newContraseña,newCorreo,newCel,newNumeroTarjeta

@u_nombre VARCHAR (25),
--nuevos datos del usuario
@u_newNombre VARCHAR (25),
@u_newContraseña VARCHAR (20),
@u_newCorreo VARCHAR (35),
@u_newCel VARCHAR (14),
--datos de la nueva tarjeta
@u_newNumeroTarjeta VARCHAR (17),
@t_cvc INT,
@t_primerNombre VARCHAR (15),
@t_segundoNombre VARCHAR (15),
@t_primerApellido VARCHAR (15),
@t_segundoApellido VARCHAR (15),
@t_fechaVigencia INT
)
AS 
BEGIN 
	IF EXISTS (SELECT NOMBRE_U FROM USUARIO WHERE NOMBRE_U = @u_nombre)
		BEGIN
			IF (@u_newContraseña IS NOT NULL)
				BEGIN
					UPDATE USUARIO SET CONTRASENIA_U = @u_newContraseña WHERE NOMBRE_U = @u_nombre;	
				END
			IF (@u_newCorreo IS NOT NULL)
				BEGIN
					UPDATE USUARIO SET CORREO_U = @u_newCorreo WHERE NOMBRE_U = @u_nombre;	
				END
			IF (@u_newCel IS NOT NULL)
				BEGIN
					UPDATE USUARIO SET NUM_CEL_U = @u_newCel WHERE NOMBRE_U = @u_nombre;	
				END
			IF (@u_newNumeroTarjeta IS NOT NULL)
				BEGIN
					IF EXISTS (SELECT NUM_TARJETA FROM TARJETA WHERE NUM_TARJETA = @u_newNumeroTarjeta)--ya existe la tarjeta
						BEGIN
							UPDATE USUARIO SET NUM_TARJETA_U = @u_newNumeroTarjeta WHERE NOMBRE_U = @u_nombre;
						END
					ELSE 
						BEGIN--no existe la tarjeta
							--se registra la tarjeta
							INSERT INTO TARJETA
							VALUES (@t_cvc,@t_primerNombre,@t_segundoNombre,@t_primerApellido,@t_segundoApellido,@t_fechaVigencia,@u_newNumeroTarjeta);
							--actualiza
							UPDATE USUARIO SET NUM_TARJETA_U = @u_newNumeroTarjeta WHERE NOMBRE_U = @u_nombre; 
						END
				END
			IF (@u_newNombre IS NOT NULL)
				BEGIN
					IF EXISTS (SELECT NOMBRE_U FROM USUARIO WHERE NOMBRE_U = @u_newNombre)
						BEGIN SELECT 'ERROR, ESE USUARIO YA EXISTE'; END
					ELSE 
						BEGIN 
							UPDATE USUARIO SET NOMBRE_U = @u_newNombre WHERE NOMBRE_U = @u_nombre;
						END
				END
		END
	ELSE
		BEGIN
			SELECT 'ERROR, ESE USUARIO NO EXISTE'; --esto no va a pasar ya que se va a eliminar desde el perfil
		END
END

--PRUEBA
EXECUTE EDITAR_USUARIO 'pollito',NULL,'CNSDKNC',NULL,'9987889234','1134567890123456',NULL,NULL,NULL,NULL,NULL,NULL

DROP PROCEDURE COMPRA_BOLETOS
CREATE PROCEDURE COMPRA_BOLETOS(
@c_primerNombre VARCHAR (15),--
@c_segundoNombre VARCHAR (15),--
@c_primerApellido VARCHAR (15),--
@c_segundoApellido VARCHAR (15),--
@c_edad INT,--
@c_nacionalidad VARCHAR (25),--
@matTren VARCHAR (25),--
@fechaReserva DATETIME,--
@u_nombre VARCHAR (25),--
@tr_nombre VARCHAR (25)--
)
AS
BEGIN
	IF((SELECT CAPACIDAD FROM TREN WHERE MAT_TREN = @matTren) > 0 )
		BEGIN
			DECLARE @nClientes INT;
			SET @nClientes = (SELECT COUNT(*) FROM CLIENTE)+1;
			--crea un cliente
			INSERT INTO CLIENTE
			VALUES(@nClientes,@c_primerNombre,@c_segundoNombre,@c_primerApellido,@c_segundoApellido,@c_edad,@c_nacionalidad);

			--genera una reserva
			DECLARE @nReservas INT;
			SET @nReservas = (SELECT COUNT(*) FROM RESERVA)+1;
			INSERT INTO RESERVA
			VALUES (@nReservas,@fechaReserva,@u_nombre,@tr_nombre,@nClientes,0.0);

			--actualiza la capacidad del tren
			UPDATE TREN SET CAPACIDAD = CAPACIDAD - 1 WHERE MAT_TREN = @matTren;

			--calcula el costo 
			DECLARE @costo INT;
			DECLARE @puntos INT;
			DECLARE @puntosAbonados INT;
			SET @costo = (SELECT COSTO_TR FROM TRAMO WHERE NOMBRE_TR = @tr_nombre);
			SET @puntos = (SELECT PTOS_ACUM_U FROM USUARIO WHERE NOMBRE_U = @u_nombre);

			IF (@puntos >= 100)
			BEGIN
				SET @puntosAbonados = 10*(@costo % 700); --puntos que se le van a abonar
				SET @costo = @costo - 300; --descuento
				SET @puntos = (@puntos-100) + @puntosAbonados; --disminuyen los puntos
		
				UPDATE USUARIO SET PTOS_ACUM_U = @puntos WHERE NOMBRE_U = @u_nombre;
			END
		END
	ELSE 
		BEGIN 
			SELECT 'NO HAY ASIENTOS DISPONIBLES'
		END
END

EXECUTE COMPRA_BOLETOS 'ISAIAS','YOSAHANDI','ANGEL',NULL,12,'MEXICANA','456FHS','12/10/21','pollito','TC2'

SELECT * FROM CLIENTE