USE BEEL_BALAM;
--CONSULTAS SIMPLES
--1. VER TRAMO (I)

--2. VER INFORMACI?N DE LA TARJETA (T)

--3. VER INFORMACI?N DE LA CTA DE USUARIO (A)
	DECLARE @nUsuario VARCHAR(25);
	SELECT @nUsuario = 'llatita';
	SELECT NOMBRE_U,CORREO_U,NUM_CEL_U,PTOS_ACUM_U,NUM_TARJETA_U FROM USUARIO WHERE NOMBRE_U=@nUsuario;

--4. VER INFORMACI?N DE LA RESERVA (I)

--5. VER INFORMACI?N DEL CLIENTE (T)


--CONSULTAS MULTITABLA
--1. VER QU? TARJETA TIENE CIERTO USUARIO (A)
	DECLARE @nUsuarioT VARCHAR(25);
	SELECT @nUsuarioT = 'llatita';
	SELECT NOMBRE_U,NUM_TARJETA FROM USUARIO,TARJETA WHERE NUM_TARJETA=NUM_TARJETA_U 
	AND NOMBRE_U=@nUsuarioT;
	
--2. VER NOMBRE DE USUARIO Y CLIENTE(S) RELACIONADO(S) (I)

--3. VER LAS ESTACIONES DE CIERTO TRAMO (T)

--4. VER LA RESERVA DE CIERTO CLIENTE (A)
	DECLARE @idCliente INT;
	SELECT @idCliente = 502;
	SELECT CLIENTE.ID_CLIENTE,PRIMER_NOMBRE_C,SEGUNDO_NOMBRE_C,
	PRIMER_APELLIDO_C,SEGUNDO_APELLIDO_C, COD_R,FECHA_R,NOMBRE_TR FROM CLIENTE,RESERVA
	WHERE CLIENTE.ID_CLIENTE=RESERVA.ID_CLIENTE AND CLIENTE.ID_CLIENTE=@idCliente;
	
--5. VER QU? RESERVA CIERTO USUARIO (I)


--CONSULTAS DE RESUMEN
--1. ?CU?NTAS RESERVAS SON DE CIERTA FECHA EN CIERTO TRAMO? (T)

--2. ?CU?NTOS CLIENTES HAY DE CIERTO PA?S? (A)
	DECLARE @nacionalidad VARCHAR(25);
	SELECT @nacionalidad = 'BRASIL';
	SELECT COUNT(ID_CLIENTE) AS NUM_PAIS FROM CLIENTE WHERE NACIONALIDAD_C=@nacionalidad;

--3. ?CU?NTOS CLIENTES HAY DE CIERTA EDAD? (I)

--4. ?CU?NTAS PERSONAS SUBEN EN CIERTA ESTACI?N? (T)

--5. ?CU?NTAS PERSONAS BAJAN EN CIERTA ESTACI?N? (A)
	DECLARE @estFinal VARCHAR(25);
	SELECT @estFinal = 'TULUM';
	SELECT COUNT(NOMBRE_TR) AS 'NUM_EST_FINAL' FROM TRAMO WHERE EST_F=@estFinal;
	