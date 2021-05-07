lugar_search_by_direccionCREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`lugar_search_by_direccion`(IN oObject JSON)
BEGIN
	
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
   
   	# Variables para parseo del objeto JSON
   	DECLARE calleLugarParam VARCHAR(100);
	DECLARE numeroLugarParam VARCHAR(10);
	DECLARE referenciaCodigoPostalParam VARCHAR(50);
	DECLARE nombreLocalidadParam VARCHAR(100);
	DECLARE nombreProvinciaParam VARCHAR(100);
	DECLARE nombrePaisParam VARCHAR(100);
   	

    SET vJsonIsValid = JSON_VALID(oObject);
   
   	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET calleLugarParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sCalleLugar')));
				SET numeroLugarParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNumeroLugar')));
				SET referenciaCodigoPostalParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oCodigoPostalLocalidadPaisProvincia.oCodigoPostal.sReferenciaCodigoPostal')));
				SET nombreLocalidadParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oCodigoPostalLocalidadPaisProvincia.oLocalidad.sNombreLocalidad')));
				SET nombreProvinciaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oCodigoPostalLocalidadPaisProvincia.oPaisProvincia.oProvincia.sNombreProvincia')));
				SET nombrePaisParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oCodigoPostalLocalidadPaisProvincia.oPaisProvincia.oPais.sNombrePais')));
  
				SELECT * FROM Lugar 
        		WHERE calleLugar = calleLugarParam
				AND numeroLugar = numeroLugarParam
				AND referenciaCodigoPostal = referenciaCodigoPostalParam 
        		AND nombreLocalidad = nombreLocalidadParam 
        		AND nombrePais = nombrePaisParam 
        		AND nombreProvincia = nombreProvinciaParam;
    			
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
END