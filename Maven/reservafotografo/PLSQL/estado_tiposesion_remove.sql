CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_tiposesion_remove`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
   	# Variables para parseo del objeto JSON
   	DECLARE nombreEstadoParam VARCHAR(50);
    DECLARE nombreTipoSesionParam VARCHAR(50);
   	DECLARE ordenParam TINYINT;

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
               	SET ordenParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].bOrden')));
               
            	DELETE FROM Estado_TipoSesion WHERE nombreEstado = `nombreEstadoParam` AND nombreTipoSesion = `nombreTipoSesionParam`;
               	
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;
   	COMMIT;
END