CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`sesion_create`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE fechaParam VARCHAR(100);
   	DECLARE horaParam VARCHAR(100);
   	DECLARE idClienteParam MEDIUMINT;
  	DECLARE idLugarParam MEDIUMINT;
 	DECLARE idPedidoParam MEDIUMINT;
	DECLARE nombreTipoSesionParam VARCHAR(50);
	DECLARE nombreEstadoParam VARCHAR(50);
   	
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO
            	
                SET fechaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].fecha')));
               	SET horaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].hora')));
              	SET idClienteParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].iIdCliente')));
             	SET idLugarParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].iIdLugar')));
            	SET idPedidoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].iIdPedido')));
           		SET nombreTipoSesionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreTipoSesion')));
          		SET nombreEstadoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreEstado')));
          	
          		IF fechaParam = 'null' THEN
          			SET fechaParam = NULL;
          		END IF;
          	
          		IF horaParam = 'null' THEN
          			SET horaParam = NULL;
          		END IF;
          	
                INSERT INTO Sesion 
               	VALUES (null, fechaParam,horaParam,idClienteParam,idLugarParam,idPedidoParam,nombreTipoSesionParam,nombreEstadoParam);
                
               SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
   	COMMIT;
END