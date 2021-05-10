CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`participante_sesion_search_by`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
   	# Variables para parseo del objeto JSON
   	DECLARE idParticipanteParam MEDIUMINT;
    DECLARE idSesionParam MEDIUMINT;

    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
		
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
            WHILE vIndex < vItems DO
                SET idParticipanteParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].idParticipante')));
                SET idSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].iIdSesion')));
               
               	SELECT * FROM Participante_Sesion WHERE idParticipante = idParticipanteParam AND idSesion = idSesionParam;
               	
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;
END