CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`lugar_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE nombreLugarParam VARCHAR(100);
	DECLARE googleMapLinkParam VARCHAR(255);
	DECLARE latitudParam DECIMAL(9,7);
	DECLARE longitudParam DECIMAL(10,7);
	DECLARE calleLugarParam VARCHAR(100);
	DECLARE numeroLugarParam VARCHAR(10);
	DECLARE referenciaCodigoPostalParam VARCHAR(50);
	DECLARE nombreLocalidadParam VARCHAR(100);
	DECLARE nombreProvinciaParam VARCHAR(100);
	DECLARE nombrePaisParam VARCHAR(100);

	DECLARE controlCodigoPostal INTEGER;
	DECLARE controlLocalidad INTEGER;
	DECLARE controlProvincia INTEGER;
	DECLARE controlPais INTEGER;
	DECLARE controlCodigoPostal_Localidad_Pais_Provincia INTEGER;
	DECLARE controlPais_Provincia INTEGER;

    SET vJsonIsValid = JSON_VALID(oObject);
    SET controlCodigoPostal = -1;
	SET controlLocalidad = -1;
	SET controlProvincia = -1;
	SET controlPais = -1;
	SET controlCodigoPostal_Localidad_Pais_Provincia = -1;
	SET controlPais_Provincia = -1;

	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET nombreLugarParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreLugar')));
                SET googleMapLinkParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sGoogleMapLink')));
                SET latitudParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].fLatitud')));
                SET longitudParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].fLongitud')));
				SET calleLugarParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sCalleLugar')));
				SET numeroLugarParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNumeroLugar')));
				SET referenciaCodigoPostalParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oCodigoPostalLocalidadPaisProvincia.oCodigoPostal.sReferenciaCodigoPostal')));
				SET nombreLocalidadParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oCodigoPostalLocalidadPaisProvincia.oLocalidad.sNombreLocalidad')));
				SET nombreProvinciaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oCodigoPostalLocalidadPaisProvincia.oPaisProvincia.oProvincia.sNombreProvincia')));
				SET nombrePaisParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oCodigoPostalLocalidadPaisProvincia.oPaisProvincia.oPais.sNombrePais')));
               
                -- CONTROLES E INSERT EN LAS SUBTABLAS --
            	IF referenciaCodigoPostalParam IS NOT NULL THEN
            		SELECT COUNT(*) INTO controlCodigoPostal FROM CodigoPostal WHERE referenciaCodigoPostal = referenciaCodigoPostalParam;
            	END IF;
            
            	IF referenciaCodigoPostalParam IS NOT NULL THEN
            		SELECT COUNT(*) INTO controlLocalidad FROM Localidad WHERE nombreLocalidad = nombreLocalidadParam;
            	END IF;
            
            	IF referenciaCodigoPostalParam IS NOT NULL THEN
            		SELECT COUNT(*) INTO controlProvincia FROM Provincia WHERE nombreProvincia = nombreProvinciaParam;
            	END IF;
            
            	IF referenciaCodigoPostalParam IS NOT NULL THEN
            		SELECT COUNT(*) INTO controlPais FROM Pais WHERE nombrePais = nombrePaisParam;
            	END IF;
            	
            	IF referenciaCodigoPostalParam IS NOT NULL THEN
            		SELECT COUNT(*) INTO controlPais_Provincia 
          			FROM Pais_Provincia 
          			WHERE nombrePais = nombrePaisParam AND nombreProvincia = nombreProvinciaParam;
            	END IF;
            
            	IF referenciaCodigoPostalParam IS NOT NULL THEN
            		SELECT COUNT(*) INTO controlCodigoPostal_Localidad_Pais_Provincia 
          			FROM CodigoPostal_Localidad_Pais_Provincia 
          			WHERE referenciaCodigoPostal = referenciaCodigoPostalParam 
          			AND nombreLocalidad = nombreLocalidadParam 
          			AND nombrePais = nombrePaisParam 
          			AND nombreProvincia = nombreProvinciaParam;
            	END IF;

          		IF controlCodigoPostal = 0 THEN
          			INSERT INTO CodigoPostal VALUES(referenciaCodigoPostalParam);
          		END IF;
          	
          		IF controlLocalidad = 0 THEN
          			INSERT INTO Localidad VALUES(nombreLocalidadParam);
          		END IF;
          	
          		IF controlProvincia = 0 THEN
          			INSERT INTO Provincia VALUES(nombreProvinciaParam);
          		END IF;
          	
          		IF controlPais = 0 THEN
          			INSERT INTO Pais VALUES(nombrePaisParam);
          		END IF;
          	
          		IF controlPais_Provincia = 0 THEN
          			INSERT INTO Pais_Provincia VALUES(nombreProvinciaParam, nombrePaisParam);
          		END IF;
          	
          		IF controlCodigoPostal_Localidad_Pais_Provincia = 0 THEN
          			INSERT INTO CodigoPostal_Localidad_Pais_Provincia VALUES(referenciaCodigoPostalParam, nombreLocalidadParam, nombreProvinciaParam, nombrePaisParam);
          		END IF;
			
            	-- INSERT FINAL --    
                INSERT INTO Lugar 
               	VALUES (
              	null,
            	`nombreLugarParam`,
            	`googleMapLinkParam`,
           		`latitudParam`,
          		`longitudParam`,
        		`calleLugarParam`,
        		`numeroLugarParam`,
       			`referenciaCodigoPostalParam`,
      			`nombreLocalidadParam`,
     			`nombreLocalidadParam`,
    			`nombrePaisParam`);
    		
    			-- DEVOLUCION DE IDLUGAR --
    			IF nombreLugarParam IS NOT NULL THEN
    				SELECT idLugar FROM Lugar WHERE nombreLugar = nombreLugarParam;
    			ELSE
                	SELECT idLugar FROM Lugar 
                	WHERE calleLugar = calleLugarParam
					AND numeroLugar = numeroLugarParam
					AND referenciaCodigoPostal = referenciaCodigoPostalParam 
          			AND nombreLocalidad = nombreLocalidadParam 
          			AND nombrePais = nombrePaisParam 
          			AND nombreProvincia = nombreProvinciaParam;
          		END IF;
    			
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
   	COMMIT;
END