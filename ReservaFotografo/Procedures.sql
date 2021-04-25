CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`empresa_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE cifNifParam VARCHAR(9);
    DECLARE nombreEmpresaParam VARCHAR(50);
    DECLARE emailEmpresaParam VARCHAR(100);    
    DECLARE telefonoEmpresaParam VARCHAR(250);    
    DECLARE idLugarParam MEDIUMINT;
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET cifNifParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sCifNif')));
                SET nombreEmpresaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreEmpresa')));
                SET emailEmpresaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sEmailEmpresa')));
                SET telefonoEmpresaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTelefonoEmrpesa')));
                SET idLugarParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oLugar.iIdLugar')));
               
                -- AQUI TENDRA QUE IR LA LLAMADA AL PROCEDIMEITNO PARA CREAR EL LUGAR CUANDO SE IMPLEMENTE
                
                INSERT INTO Empresa VALUES (`cifNifParam`, `nombreEmpresaParam`, `emailEmpresaParam`, `telefonoEmpresaParam`, idLugarParam);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;    
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`empresa_remove`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE cifNifParam VARCHAR(9);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET cifNifParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sCifNif')));
                
                DELETE FROM  Empresa WHERE cifNif = cifNifParam;  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;    
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`empresa_search_by_pk`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE cifNifParam VARCHAR(9);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
                SET cifNifParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sCifNif')));
                SELECT * FROM Empresa WHERE cifNif = `cifNifParam`;
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`empresa_update`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE cifNifParam VARCHAR(9);
    DECLARE nombreEmpresaParam VARCHAR(50);
    DECLARE emailEmpresaParam VARCHAR(100);    
    DECLARE telefonoEmpresaParam VARCHAR(250);    
    DECLARE idLugarParam MEDIUMINT;
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET cifNifParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sCifNif')));
                SET nombreEmpresaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreEmpresa')));
                SET emailEmpresaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sEmailEmpresa')));
                SET telefonoEmpresaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTelefonoEmrpesa')));
                SET idLugarParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oLugar.iIdLugar')));
               
                -- AQUI TENDRA QUE IR LA LLAMADA AL PROCEDIMEITNO PARA CREAR EL LUGAR CUANDO SE IMPLEMENTE
                
                UPDATE Empresa 
                SET 
                	nombreEmpresa = nombreEmpresaParam, 
               		emailEmpresa = emailEmpresaParam,
               		telefonoEmpresa = telefonoEmpresaParam,
               		idLugar = idLugarParam
               	WHERE cifNif = cifNifParam;
               
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;    
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreEstadoParam VARCHAR(50);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET nombreEstadoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreEstado')));
                
                INSERT INTO Estado VALUES (`nombreEstadoParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_remove`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreEstadoParam VARCHAR(50);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET nombreEstadoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreEstado')));
                
                DELETE FROM  Estado WHERE nombreEstado = nombreEstadoParam;
               
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_search_by_pk`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreEstadoParam VARCHAR(50);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
                SET nombreEstadoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreEstado')));
               
                SELECT * FROM Estado WHERE nombreEstado = nombreEstadoParam;
               
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_update`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreEstadoParam VARCHAR(50);
   	DECLARE nombreEstadoAntiguoParam VARCHAR(50);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
        
		SET nombreEstadoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', 0, '].sNombreEstado')));
		SET nombreEstadoAntiguoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', 1, '].sNombreEstado')));
                
		INSERT INTO Estado VALUES (nombreEstadoParam);
		-- Cuando se conecte con la tabla NM se tiene que verificar que se cambien bien las relaciones....
		DELETE FROM  Estado WHERE nombreEstado = nombreEstadoAntiguoParam;

    END IF;
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`tipo_sesion_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreTipoSesionParam VARCHAR(50);
    DECLARE duracionTipoSesionParam SMALLINT;
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET nombreTipoSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreTipoSesion')));
                SET duracionTipoSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].shDuracionTipoSesion')));
                
                INSERT INTO TipoSesion VALUES (`nombreTipoSesionParam`, duracionTipoSesionParam);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`tipo_sesion_remove`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreTipoSesionParam VARCHAR(50);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET nombreTipoSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreTipoSesion')));
                
                DELETE FROM  TipoSesion WHERE nombreTipoSesion = nombreTipoSesionParam;
               
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`tipo_sesion_search_by_pk`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreTipoSesionParam VARCHAR(50);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
                SET nombreTipoSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreTipoSesion')));
               
                SELECT * FROM TipoSesion WHERE nombreTipoSesion = `nombreTipoSesionParam`;
               
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`tipo_sesion_update`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreTipoSesionParam VARCHAR(50);
    DECLARE duracionTipoSesionParam SMALLINT;
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET nombreTipoSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreTipoSesion')));
                SET duracionTipoSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].shDuracionTipoSesion')));
                
                UPDATE TipoSesion 
                SET  
                	duracionTipoSesion = duracionTipoSesionParam
               	WHERE nombreTipoSesion = nombreTipoSesionParam;
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
END;
