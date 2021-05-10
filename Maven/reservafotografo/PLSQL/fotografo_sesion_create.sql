CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`fotografo_sesion_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    # Variables para parseo del objeto JSON
    DECLARE dniFotografoParam VARCHAR(9);
    DECLARE idSesionParam MEDIUMINT;

    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
		
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
            WHILE vIndex < vItems DO
                SET dniFotografoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].dniFotografo')));
                SET idSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].iIdSesion')));
                INSERT INTO Fotografo_Sesion VALUES (idSesionParam, `dniFotografoParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE; 
        END IF;	
    END IF;
   	COMMIT;
END