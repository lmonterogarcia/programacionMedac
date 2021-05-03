CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`estado_update`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreEstadoParam VARCHAR(50);
   	DECLARE nombreEstadoAntiguoParam VARCHAR(50);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
        
		SET nombreEstadoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', 0, '].sNombreEstado')));
		SET nombreEstadoAntiguoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', 1, '].sNombreEstado')));
                
		INSERT INTO Estado VALUES (nombreEstadoParam);
		-- Cuando se conecte con la tabla NM se tiene que verificar que se cambien bien las relaciones....
		DELETE FROM  Estado WHERE nombreEstado = nombreEstadoAntiguoParam;

    END IF;
END