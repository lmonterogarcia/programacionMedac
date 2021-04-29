-- ##### UNIVERSALES #####

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`listar`(IN P_TablaName VARCHAR(255))
BEGIN
	SET @Sentencia = CONCAT('SELECT * FROM ',P_TablaName);
   	PREPARE stmt FROM @Sentencia;
   	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;

END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`remove`(IN oObject JSON, IN P_JavaVarName VARCHAR(255), IN P_TablaName VARCHAR(255), IN P_TableVarName VARCHAR(255))
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
   	# Variables para parseo del objeto JSON
   	DECLARE Param_int INTEGER;
   	DECLARE Param_varchar VARCHAR(255);
   	# Creaccion de la excepcion si se busca por integer
   	DECLARE CONTINUE HANDLER FOR 1366
   		BEGIN
	   		SET Param_int = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].',P_JavaVarName)));
			SET @Sentencia = CONCAT('DELETE FROM ',P_TablaName,' WHERE ',P_TableVarName,' = ',Param_int);
    		PREPARE stmt FROM @Sentencia;
    		EXECUTE stmt;
    		DEALLOCATE PREPARE stmt;
    	END;

    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
            	BEGIN   
            		SET Param_varchar = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].',P_JavaVarName)));
					SET @Sentencia = CONCAT('DELETE FROM ',P_TablaName,' WHERE ',P_TableVarName,' = "',Param_varchar,'"');
    				PREPARE stmt FROM @Sentencia;
    				EXECUTE stmt;
    				DEALLOCATE PREPARE stmt;
               	END;
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;
END;

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`search_by`(IN oObject JSON, IN P_JavaVarName VARCHAR(255), IN P_TablaName VARCHAR(255), IN P_TableVarName VARCHAR(255))
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
   	# Variables para parseo del objeto JSON
   	DECLARE Param_int INTEGER;
   	DECLARE Param_varchar VARCHAR(255);
   	# Creaccion de la excepcion si se busca por integer
   	DECLARE CONTINUE HANDLER FOR 1366
   		BEGIN
	   		SET Param_int = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].',P_JavaVarName)));
			SET @Sentencia = CONCAT('SELECT * FROM ',P_TablaName,' WHERE ',P_TableVarName,' = ',Param_int);
    		PREPARE stmt FROM @Sentencia;
    		EXECUTE stmt;
    		DEALLOCATE PREPARE stmt;
    	END;

    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
            	BEGIN   
            		SET Param_varchar = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].',P_JavaVarName)));
					SET @Sentencia = CONCAT('SELECT * FROM ',P_TablaName,' WHERE ',P_TableVarName,' = "',Param_varchar,'"');
    				PREPARE stmt FROM @Sentencia;
    				EXECUTE stmt;
    				DEALLOCATE PREPARE stmt;
               	END;
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;
END;

-- ##### EMPRESA #####
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

-- ##### ESTADO #####
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

-- ##### TIPO SESION #####
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