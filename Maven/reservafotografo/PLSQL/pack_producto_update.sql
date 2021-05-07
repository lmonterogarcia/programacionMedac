CREATE DEFINER=`fotografo`@`%` PROCEDURE `reservafotografo`.`pack_producto_update`(IN oObject JSON)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    # Variables para parseo del objeto JSON
    DECLARE nombrePackParam VARCHAR(50);
    DECLARE nombreProductoParam VARCHAR(50);

    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);
       
        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
            
            	SET nombrePackParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oPack.sNombrePack')));
                SET nombreProductoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].oProducto.sNombrePack')));
                
                UPDATE Pack_Producto 
                SET nombreProducto = nombreProductoParam
               	WHERE nombrePack = nombrePackParam;
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
   	COMMIT;
END