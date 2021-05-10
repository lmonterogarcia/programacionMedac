CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`pack_sesion_search_by`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
   	# Variables para parseo del objeto JSON
   	DECLARE nombrePackParam VARCHAR(9);
    DECLARE idSesionParam MEDIUMINT;

    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
		
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
            WHILE vIndex < vItems DO
                SET nombrePackParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].nombrePack')));
                SET idSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].iIdSesion')));
               
               	SELECT * FROM Pack_Sesion WHERE nombrePack = nombrePackParam AND idSesion = idSesionParam;
               	
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;
END