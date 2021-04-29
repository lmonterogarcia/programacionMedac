
-- ##### EMPRESA #####
CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`empresa_remove`(IN oObject JSON) -- DEPRECATED
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

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`empresa_search_by_pk`(IN oObject JSON) -- DEPRECATED
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

-- ##### ESTADO #####

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_remove`(IN oObject JSON) -- DEPRECATED
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

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_search_by_pk`(IN oObject JSON) -- DEPRECATED
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

-- ##### TIPO SESION #####

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`tipo_sesion_remove`(IN oObject JSON) -- DEPRECATED
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

CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`tipo_sesion_search_by_pk`(IN oObject JSON) -- DEPRECATED
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