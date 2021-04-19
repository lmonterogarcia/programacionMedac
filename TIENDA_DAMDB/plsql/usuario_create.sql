DROP PROCEDURE IF EXISTS `usuario_create`;
DELIMITER $$
CREATE PROCEDURE `usuario_create` (
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    DECLARE vValido INT;
    
    # Variables para parseo del objeto JSON
    DECLARE sEmailParam VARCHAR(250);
    DECLARE sPasswordParam VARCHAR(12);
    
	
    SET vJsonIsValid = JSON_VALID(oObject);
    SET vValido = 0;
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";     
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO
				
                SET sEmailParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sEmail')));
                SET sPasswordParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sPassword')));
                
                INSERT INTO Usuario VALUES (`sEmailParam`, `sPasswordParam`);
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
        SET vValido = 1;
    END IF;
    
    SELECT vValido;
    
END $$
DELIMITER ;