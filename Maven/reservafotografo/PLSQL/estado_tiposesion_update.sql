CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_tiposesion_update`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    # Variables para parseo del objeto JSON
    DECLARE nombreEstadoParam VARCHAR(50);
    DECLARE nombreTipoSesionParam VARCHAR(50);
   	DECLARE ordenParam TINYINT;
   	DECLARE nombreEstadoParam2 VARCHAR(50);
    DECLARE nombreTipoSesionParam2 VARCHAR(50);
   	DECLARE ordenParam2 TINYINT;

    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
		
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
            WHILE vIndex < vItems DO
                SET nombreEstadoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oEstado.sNombreEstado')));
                SET nombreTipoSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oTipoSesion.sNombreTipoSesion')));
               	-- SET ordenParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].bOrden')));
               	SELECT orden INTO ordenParam FROM Estado_TipoSesion WHERE nombreEstado = nombreEstadoParam AND nombreTipoSesion = nombreTipoSesionParam;
               
               	SET nombreEstadoParam2 = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex + 1, '].oEstado.sNombreEstado')));
                SET nombreTipoSesionParam2 = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex + 1, '].oTipoSesion.sNombreTipoSesion')));
               	-- SET ordenParam2 = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex + 1, '].bOrden')));
               	SELECT orden INTO ordenParam2 FROM Estado_TipoSesion WHERE nombreEstado = nombreEstadoParam2 AND nombreTipoSesion = nombreTipoSesionParam2;
                
                UPDATE Estado_TipoSesion 
                SET orden = ordenParam2
               	WHERE nombreEstado = nombreEstadoParam AND nombreTipoSesion = nombreTipoSesionParam;
               
               	UPDATE Estado_TipoSesion 
                SET orden = ordenParam
               	WHERE nombreEstado = nombreEstadoParam2 AND nombreTipoSesion = nombreTipoSesionParam2;
                  
                SET vIndex = vIndex + 2;
            END WHILE;
            
        END IF;	
    END IF;
   	COMMIT;
END