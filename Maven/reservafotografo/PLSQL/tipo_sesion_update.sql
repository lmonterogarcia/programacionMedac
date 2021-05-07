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
   	COMMIT;
END