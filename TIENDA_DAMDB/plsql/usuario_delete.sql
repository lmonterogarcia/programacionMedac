DROP PROCEDURE IF EXISTS `cliente_delete`;
DELIMITER $$
CREATE PROCEDURE `cliente_delete` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sEmailParam VARCHAR(250);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
                SET sEmailParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sEmail')));                
                DELETE FROM Usuario WHERE email = `sEmailParam`;
                SET vIndex = vIndex + 1;
            END WHILE;            
        END IF;	
    END IF;
    
END $$
DELIMITER ;