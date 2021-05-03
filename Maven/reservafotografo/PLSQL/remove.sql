CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`remove`(IN oObject JSON, IN P_JavaVarName VARCHAR(255), IN P_TablaName VARCHAR(255), IN P_TableVarName VARCHAR(255))
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
   	# Variables para parseo del objeto JSON
   	DECLARE Param_int INTEGER;
   	DECLARE Param_varchar VARCHAR(255);
   	# Creaccion de la excepcion si se busca por integer
   	DECLARE CONTINUE HANDLER FOR 1366
   		BEGIN
	   		SET Param_int = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].',P_JavaVarName)));
			SET @Sentencia = CONCAT('DELETE FROM ',P_TablaName,' WHERE ',P_TableVarName,' = ',Param_int);
    		PREPARE stmt FROM @Sentencia;
    		EXECUTE stmt;
    		DEALLOCATE PREPARE stmt;
    	END;

    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
            	BEGIN   
            		SET Param_varchar = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].',P_JavaVarName)));
					SET @Sentencia = CONCAT('DELETE FROM ',P_TablaName,' WHERE ',P_TableVarName,' = "',Param_varchar,'"');
    				PREPARE stmt FROM @Sentencia;
    				EXECUTE stmt;
    				DEALLOCATE PREPARE stmt;
               	END;
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;
END