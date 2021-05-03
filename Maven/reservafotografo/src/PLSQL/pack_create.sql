CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`pack_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombrePackParam VARCHAR(50);
    DECLARE precioPackParam DECIMAL(7,2);
    DECLARE descripcionPackParam VARCHAR(255);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET nombrePackParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombrePack')));
                SET precioPackParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].fPrecioPack')));
                SET descripcionPackParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sDescripcionPack')));
               
                -- AQUI TENDRA QUE IR LA LLAMADA AL PROCEDIMEITNO PARA CREAR EL LUGAR CUANDO SE IMPLEMENTE
                
                INSERT INTO Pack VALUES (`nombrePackParam`, `precioPackParam`, `descripcionPackParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;    
END