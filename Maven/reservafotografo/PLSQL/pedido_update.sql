CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`pedido_update`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE idPedidoParam VARCHAR(9);
    DECLARE pagadoBooParam VARCHAR(10);
   	DECLARE pagadoParam TINYINT;
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET idPedidoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].iIdPedido')));
                -- SET pagadoBooParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].booPagado')));

               	SET pagadoBooParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].booPagado')));
               
               	IF pagadoBooParam = 'true' THEN
               		SET pagadoParam = 1;
               	ElSE
               		SET pagadoParam = 0;
               	END IF;
               
                UPDATE Pedido 
                SET
               		pagado = pagadoParam
               	WHERE idPedido = idPedidoParam;
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
   	COMMIT;
END