DROP PROCEDURE IF EXISTS `cliente_search_by_direccion`;
DELIMITER $$
CREATE PROCEDURE `cliente_search_by_direccion` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sDireccionParam VARCHAR(250);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
                SET sDireccionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sDireccion')));
                SELECT * FROM Cliente WHERE sDireccion = `sDireccionParam`;
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;    
END $$
DELIMITER ;